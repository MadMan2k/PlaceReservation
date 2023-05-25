package place.reservation.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import place.reservation.reservations.entity.Procedure;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RdvDto {

    private static final int NAME_MIN_LENGTH = 2;

    @Size(min = NAME_MIN_LENGTH, message = "Name must be at least " + NAME_MIN_LENGTH + " characters long")
    @Pattern(regexp = "^[a-zA-Z][-a-zA-Z ]*[a-zA-Z]$", message = "Only latin letters allowed. For compound names hyphen \''-\'' and/or space \'' \'' allowed")
    private String clientFirstName;

    @Size(min = NAME_MIN_LENGTH, message = "Name must be at least " + NAME_MIN_LENGTH + " characters long")
    @Pattern(regexp = "^[a-zA-Z][-a-zA-Z ]*[a-zA-Z]$", message = "Only latin letters allowed. For compound names hyphen \''-\'' and/or space \'' \'' allowed")
    private String clientLastName;

    @NotBlank(message = "Email can not be empty")
    @Email(message = "Email must be valid")
    private String clientEmail;

    @Pattern(regexp = "\\d{2} \\d{2} \\d{2} \\d{2} \\d{2}", message = "Phone number format should be 01 23 45 67 89")
    private String clientPhoneNumber;

    private LocalDate date;

    private LocalTime time;

    private Procedure procedure;

    @Min(value = 0, message = "Discount must be greater than or equal to 0")
    @Max(value = 100, message = "Discount must be less than or equal to 100")
    private double discount;
}
