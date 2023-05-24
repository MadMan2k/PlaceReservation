package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import place.reservation.reservations.entity.Procedure;
import place.reservation.reservations.service.ProcedureService;

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
}
