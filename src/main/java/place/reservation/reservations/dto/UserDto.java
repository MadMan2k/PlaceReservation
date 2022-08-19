package place.reservation.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import place.reservation.reservations.entity.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Size(min = 2, message="Name must be at least 2 characters long")
    private String firstName;

    @Size(min = 2, message="Name must be at least 2 characters long")
    private String lastName;

    @NotBlank(message = "Email can not be empty")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 10, message = "Please enter your phone number")
    private String phoneNumber;

    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>€]).{8,20}$",
//            message = "From 8 to 20 characters, at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;

    private String passwordConfirmation;

    private UserRole userRole;

}
