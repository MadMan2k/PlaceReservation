package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.entity.Procedure;
import place.reservation.reservations.service.ProcedureService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/procedures")
public class ProcedureController {

    private final ProcedureService procedureService;

    public ProcedureController(ProcedureService procedureServiceInput) {
        this.procedureService = procedureServiceInput;
    }

    @GetMapping(value = {"/", ""})
    public String showProcedures(Model model) {
        List<Procedure> allProcedures = procedureService.getAllProcedures();
        model.addAttribute("procedures", allProcedures);
        return "procedures";
    }

    @GetMapping("/new/")
    public String createNewProcedure(Model model) {
        ProcedureDto procedureDto = new ProcedureDto();
        model.addAttribute("procedureDto", procedureDto);
        return "newProcedure";
    }

    @PostMapping("new/save")
    public String saveProcedure(@Valid ProcedureDto procedureDto, Errors errors) {

        if (errors.hasErrors()) {
            for (FieldError fe : errors.getFieldErrors()) {
                System.out.println("Field error - '" + fe.getField() + "'; Code error - '" + fe.getCode() + "'");
            }
            return "newProcedure";
        }

        procedureService.saveNewProcedure(procedureDto);
        return "redirect:/procedures";

    }
}
