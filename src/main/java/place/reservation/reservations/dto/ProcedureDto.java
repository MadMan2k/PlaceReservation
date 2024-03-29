package place.reservation.reservations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureDto {

    private static final int NAME_MIN_LENGTH = 2;

    @Size(min = NAME_MIN_LENGTH, message = "Name must be at least " + NAME_MIN_LENGTH + " characters long")
    private String name;

    @Min(value = 0, message = "Please enter the procedure duration")
    private int durationInMinutes;

    @Min(value = 0, message = "Please enter the procedure price")
    private double price;
}
