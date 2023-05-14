package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import place.reservation.reservations.dto.UserDto;
import place.reservation.reservations.service.UserService;

public class PhoneNumberValidator {
    public static void phoneNumberValidation(long id, UserDto userDtoWithoutPassword,
                                             Errors errors, UserService userService) {
        boolean isPhoneNumberUnique = userService.isPhoneNumberUnique(id, userDtoWithoutPassword.getPhoneNumber());
        if (!isPhoneNumberUnique) {
            errors.rejectValue("phoneNumber", "AlreadyExist.PhoneNumber", "Phone number exist already");
        }
    }
}
