package concesionaria.admin;

import concesionaria.model.Modelo;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;

@Controller
public class ModelosController {
    private final ModelosService modelosService;

    public ModelosController(ModelosService modelosService){
        this.modelosService = modelosService;
    }

    @GetMapping("/models")
    public String modelos(Model model) throws IOException {
        model.addAttribute("models", modelosService.findAll());
        return "admin/models_list";
    }

    @PostMapping("/models")
    public RedirectView equip(Modelo equipamiento) throws IOException {
        modelosService.putObject(equipamiento);
        return new RedirectView("/models");
    }

    @PostMapping("/models_del")
    public RedirectView equip(@RequestBody String nombre) throws IOException {
        modelosService.deleteObject(nombre);
        return new RedirectView("/models");
    }
}
