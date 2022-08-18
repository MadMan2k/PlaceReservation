package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.entity.User;
import place.reservation.reservations.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "newUser";
    }

    @PostMapping("/users/save")
    public String saveUser(UserDto userDto) {
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
