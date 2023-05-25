package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.dto.validator.EmailValidator;
import place.reservation.reservations.dto.validator.PasswordValidator;
import place.reservation.reservations.dto.validator.PhoneNumberValidator;
import place.reservation.reservations.entity.User;
import place.reservation.reservations.service.UserNotFoundException;
import place.reservation.reservations.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userServiceInput) {
        this.userService = userServiceInput;
    }

    /**
     * @param model
     * @return all users view
     */
    @GetMapping(value = {"/", ""})
    public String showUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    /**
     * @param model
     * @return new user creation view
     */
    @GetMapping("/new/")
    public String showNewUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "newUser";
    }

    /**
     * @param userDto
     * @param errors
     * @return all users view if no errors, otherwise stay at the same view
     */
    @PostMapping("/new/save")
    public String saveUser(@Valid UserDto userDto, Errors errors) {

        PasswordValidator.passwordValidation(userDto, errors);

        if (errors.hasErrors()) {
            for (FieldError fe : errors.getFieldErrors()) {
                System.out.println("Field error - '" + fe.getField() + "'; Code error - '" + fe.getCode() + "'");
            }

            return "newUser";
        }

        userService.createNewUser(userDto);
        return "redirect:/users";
    }

    /**
     * @param id
     * @return redirect to users view
     * @throws UserNotFoundException
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) throws UserNotFoundException {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    /**
     * @param id
     * @param model
     * @return edit user view
     * @throws UserNotFoundException
     */
    @GetMapping("/edit/{id}/")
    public String editUser(@PathVariable("id") long id, Model model) throws UserNotFoundException {
        UserDto userDtoWithoutPassword = userService.getUserDtoWithoutPasswordById(id);
        model.addAttribute("userDto", userDtoWithoutPassword);
        return "newUser";
    }

    /**
     * @param id
     * @param userDtoWithoutPassword
     * @param errors
     * @return users view if ok, same view if not ok
     * @throws UserNotFoundException
     */
    @PostMapping("/edit/{id}/save")
    public String updateUser(@PathVariable("id") long id,
                             @Valid @ModelAttribute("userDto") UserDto userDtoWithoutPassword,
                             Errors errors) throws UserNotFoundException {

        EmailValidator.emailValidation(id, userDtoWithoutPassword, errors, userService);
        PhoneNumberValidator.phoneNumberValidation(id, userDtoWithoutPassword, errors, userService);


        if (errors.hasErrors()) {
            for (FieldError fe : errors.getFieldErrors()) {
                System.out.println("Field error - '" + fe.getField() + "'; Code error - '" + fe.getCode() + "'");
            }

            return "newUser";
        }

        userService.updateUser(userDtoWithoutPassword, id);

        return "redirect:/users";
    }

}
