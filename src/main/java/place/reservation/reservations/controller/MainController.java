package place.reservation.reservations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
     * @return application main page
     */
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }
}
