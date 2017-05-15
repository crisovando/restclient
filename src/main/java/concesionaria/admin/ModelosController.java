package concesionaria.admin;

import concesionaria.model.Modelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ModelosController {
    private final ModelosService modelosService;

    public ModelosController(ModelosService modelosService){
        this.modelosService = modelosService;
    }

    @GetMapping("/models")
    public String modelos(Model model) throws IOException {
        Modelo[] models =  modelosService.findAll();
        List<Modelo> result = new ArrayList();
        for (Modelo m : models) {
            if (m.getOpcionales().length == 0) {
                result.add(m);
            }
        }

        model.addAttribute("models", result);
        return "admin/models_list";
    }

    @PostMapping("/models")
    public RedirectView equip(Modelo modelo) throws IOException {
        modelosService.putObject(modelo);
        return new RedirectView("/models");
    }

    @PostMapping("/models_del")
    public RedirectView equip(@RequestBody String nombre) throws IOException {
        modelosService.deleteObject(nombre);
        return new RedirectView("/models");
    }
}
