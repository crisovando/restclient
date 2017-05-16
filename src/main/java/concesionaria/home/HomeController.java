package concesionaria.home;

import concesionaria.admin.ModelosService;
import concesionaria.model.Modelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristian.ovando on 26/04/2017.
 */
@Controller
public class HomeController {
    private final ModelosService modelosService;

    public HomeController(ModelosService modelosService){ this.modelosService = modelosService; }

    @GetMapping("/")
    public String home(Model model, @RequestParam String opcionales) throws IOException {
        Modelo[] models =  modelosService.findAll();
        List<Modelo> result = new ArrayList();
        for (Modelo m : models) {
            if (m.getOpcionales().length == 0) {
                result.add(m);
            }
        }
        model.addAttribute("models", result);
        return "home/home";
    }
}
