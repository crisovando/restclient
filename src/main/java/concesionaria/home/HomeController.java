package concesionaria.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

/**
 * Created by cristian.ovando on 26/04/2017.
 */
@Controller
public class HomeController {

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @GetMapping("/")
    public String home(Principal principal){

        return "home/home";
    }
}
