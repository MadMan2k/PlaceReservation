package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.service.ProcedureService;

public class ProcedureValidator {
    public static void procedureValidation(long id, ProcedureDto procedureDto, Errors errors, ProcedureService procedureService) {
        boolean isNameUnique = procedureService.isNameUnique(id, procedureDto.getName());
    }
}
