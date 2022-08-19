package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.dto.validator.PasswordValidator;
import place.reservation.reservations.entity.User;
import place.reservation.reservations.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userServiceInput) {
        this.userService = userServiceInput;
    }

    /**
     * @param model
     * @return all users page
     */
    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    /**
     * @param model
     * @return new user creation page
     */
    @GetMapping("/users/new")
    public String showNewUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "newUser";
    }

    /**
     * @param userDto
     * @param errors
     * @return all users page if no errors, otherwise stay at the same page
     */
    @PostMapping("/users/save")
    public String saveUser(@Valid UserDto userDto, Errors errors) {

//        if (!(userDto.getPassword().equals(userDto.getPasswordConfirmation()))) {
//            errors.rejectValue
//                    ("passwordConfirmation", "NotMatch.Password", "Passwords are not matched");
//        }

        PasswordValidator.passwordValidation(userDto, errors);

        if (errors.hasErrors()) {
            for (FieldError fe : errors.getFieldErrors()) {
                System.out.println("This is field error" + fe.getField() + " " + fe.getCode());
            }

            return "newUser";
        }

        userService.createNewUser(userDto);
        return "redirect:/users";
    }

//    @GetMapping("/users/new")
//    public String showNewUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "newUser";
//    }
//
//    @PostMapping("/users/save")
//    public String saveUser(User user) {
//        System.out.println(user);
//
//        return "redirect:/users";
//    }


}
