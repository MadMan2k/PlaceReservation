package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import place.reservation.reservations.dto.UserDto;

public class PasswordValidator {

    public static void passwordValidation(UserDto userDto, Errors errors) {
        if (!(userDto.getPassword().equals(userDto.getPasswordConfirmation()))) {
            errors.rejectValue
                    ("passwordConfirmation", "NotMatch.Password", "Passwords are not matched");
        }
    }
}
