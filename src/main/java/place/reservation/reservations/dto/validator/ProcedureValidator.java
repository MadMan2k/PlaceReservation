package place.reservation.reservations.dto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.service.ProcedureService;

public class ProcedureValidator {
    public static void procedureValidation(long id, ProcedureDto procedureDto,
                                           Errors errors,
                                           ProcedureService procedureService) {
//        if (!errors.getFieldErrors().isEmpty()) {
//            for (FieldError fe : errors.getFieldErrors()) {
//                if (fe.getCode().equals("typeMismatch")) {
//
//
//                    switch (fe.getField()) {
//                        case "durationInMinutes" : errors.rejectValue("durationInMinutes", "typeMismatch.durationInMinutes", "Please enter valid value");
//                    }
//                }
//            }
//        }

        boolean isNameUnique = procedureService.isNameUnique(id, procedureDto.getName());
        if (!isNameUnique) {
            errors.rejectValue("name", "AlreadyExist.Name", "Procedure name exist already");
        }



        for (FieldError fe : errors.getFieldErrors()) {
            System.out.println("Field error VALIDATOR - '" + fe.getField() + "'; Code error - '" + fe.getCode() + "'");
        }
    }
}
