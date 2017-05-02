package concesionaria.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import concesionaria.model.Automovil;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
