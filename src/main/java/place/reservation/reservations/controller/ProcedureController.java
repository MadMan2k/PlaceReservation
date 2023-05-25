package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import place.reservation.reservations.dto.ProcedureDto;
import place.reservation.reservations.dto.validator.ProcedureValidator;
import place.reservation.reservations.entity.Procedure;
import place.reservation.reservations.service.ProcedureNotFoundException;
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

    /**
     * @param model
     * @return procedures view
     */
    @GetMapping(value = {"/", ""})
    public String showProcedures(Model model) {
        List<Procedure> allProcedures = procedureService.getAllProcedures();

//        Collections.sort(allProcedures, Comparator.comparing(Procedure::getName));

        model.addAttribute("procedures", allProcedures);
        return "procedures";
    }

    /**
     * @param model
     * @return new procedure creation view
     */
    @GetMapping("/new/")
    public String createNewProcedure(Model model) {
        ProcedureDto procedureDto = new ProcedureDto();
        model.addAttribute("procedureDto", procedureDto);
        return "newProcedure";
    }

    /**
     * @param procedureDto
     * @param errors
     * @return all procedures view if no errors, otherwise stay at the same view
     */
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

    /**
     * @param id
     * @return redirect to procedures view
     * @throws ProcedureNotFoundException
     */
    @GetMapping("/delete/{id}")
    public String deleteProcedure(@PathVariable("id") long id) throws ProcedureNotFoundException {
        procedureService.deleteProcedure(id);
        return "redirect:/procedures";
    }

    /**
     * @param id
     * @param model
     * @return edit procedure view
     * @throws ProcedureNotFoundException
     */
    @GetMapping("edit/{id}")
    public String editProcedure(@PathVariable("id") long id, Model model) throws ProcedureNotFoundException {
        ProcedureDto procedureDto = procedureService.getProcedureById(id);
        model.addAttribute("procedureDto", procedureDto);
        return "newProcedure";
    }

    /**
     * @param id
     * @param procedureDto
     * @param errors
     * @return procedures view if ok, same view if not ok
     * @throws ProcedureNotFoundException
     */
    @PostMapping("/edit/{id}/save")
    public String updateProcedure(@PathVariable("id") long id,
                                  @Valid @ModelAttribute("procedureDto") ProcedureDto procedureDto,
                                  Errors errors) throws ProcedureNotFoundException {
        ProcedureValidator.procedureValidation(id, procedureDto, errors, procedureService);

        if (errors.hasErrors()) {
            for (FieldError fe : errors.getFieldErrors()) {
                System.out.println("Field error - '" + fe.getField() + "'; Code error - '" + fe.getCode() + "'");
            }
            return "newProcedure";
        }

        procedureService.updateProcedure(procedureDto, id);
        return "redirect:/procedures";
    }
}
