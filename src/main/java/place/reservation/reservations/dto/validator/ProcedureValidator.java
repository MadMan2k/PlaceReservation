package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.service.ProcedureService;

public class ProcedureValidator {
    public static void procedureValidation(long id, ProcedureDto procedureDto,
                                           Errors errors,
                                           ProcedureService procedureService) {

        boolean isNameUnique = procedureService.isNameUnique(id, procedureDto.getName());
        if (!isNameUnique) {
            errors.rejectValue("name", "AlreadyExist.Name", "Procedure name exist already");
        }
    }

    public static void procedureValidation(ProcedureDto procedureDto,
                                           Errors errors,
                                           ProcedureService procedureService) {

        if (procedureDto.getName() != null && procedureDto.getName().length() >= 2) {
            boolean isNameUnique = procedureService.isNameUnique(procedureDto.getName());
            if (!isNameUnique) {
                errors.rejectValue("name", "AlreadyExist.Name", "Procedure name exist already");
            }
        }
    }
}
