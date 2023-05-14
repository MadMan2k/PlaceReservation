package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.service.UserService;

public class EmailValidator {

    public static void emailValidation (long id, UserDto userDto, Errors errors, UserService userService) {
        boolean isEmailUnique = userService.isEmailUnique(id, userDto.getEmail());
        if (!isEmailUnique) {
            errors.rejectValue("email", "AlreadyExist.Email", "Email exist already");
        }
    }
}
