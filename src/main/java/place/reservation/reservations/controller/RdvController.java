package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import place.reservation.reservations.entity.Rdv;
import place.reservation.reservations.service.RdvService;

import java.util.List;

@Controller
@RequestMapping("/rdvs")
public class RdvController {

    private final RdvService rdvService;

    public RdvController(RdvService rdvServiceInput) {
        this.rdvService = rdvServiceInput;
    }

    @GetMapping(value = {"/", ""})
    public String showRdvs(Model model) {
        List<Rdv> allRdvs = rdvService.getAllRdvs();
        model.addAttribute("rdvs", allRdvs);
        return "rdvs/rdvs";
    }
}
