package place.reservation.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import place.reservation.reservations.dto.constraint.DataType;
import place.reservation.reservations.dto.constraint.UniqueValue;
import place.reservation.reservations.entity.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private static final int PHONE_NUMBER_MAX_LENGTH = 20;
    private static final int PHONE_NUMBER_MIN_LENGTH = 10;
    private static final int PASSWORD_MIN_LENGTH = 3;
    private static final int NAME_MIN_LENGTH = 2;


    @Size(min = NAME_MIN_LENGTH, message = "Name must be at least " + NAME_MIN_LENGTH + " characters long")
    private String firstName;

    @Size(min = NAME_MIN_LENGTH, message = "Name must be at least " + NAME_MIN_LENGTH + " characters long")
    private String lastName;

//    @UniqueValue(dataType = DataType.EMAIL)
    @NotBlank(message = "Email can not be empty")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = PHONE_NUMBER_MIN_LENGTH, max = PHONE_NUMBER_MAX_LENGTH, message = "Please enter your phone number")
    @Pattern(regexp = "\\d{2} \\d{2} \\d{2} \\d{2} \\d{2}", message = "Phone number format should be 01 23 45 67 89")
    private String phoneNumber;

    @Size(min = PASSWORD_MIN_LENGTH, message = "Password must have at least " + PASSWORD_MIN_LENGTH + " characters")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>€]).{8,20}$",
//            message = "From 8 to 20 characters, at least one uppercase letter,
//            one lowercase letter, one number and one special character")
    private String password;

    private String passwordConfirmation;

    private UserRole userRole;

}
