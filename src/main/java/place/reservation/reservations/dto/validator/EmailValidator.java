package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.service.UserService;

public class EmailValidator {

//    private final UserService userService;
//
//    public EmailValidator(UserService userServiceInput) {
//        this.userService = userServiceInput;
//    }

    public static void emailValidation (UserDto userDto, Errors errors, UserService userService) {
        boolean isEmailUnique = userService.isEmailUnique(userDto.getEmail());
        if (!isEmailUnique) {
            errors.rejectValue("email", "AlreadyExist.Email", "Email exist already");
        }
    }
}
