package concesionaria.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import concesionaria.model.Automovil;
import concesionaria.model.Equipamiento;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import org.json.*;

import java.io.IOException;

/**
 * Created by fabia on 01/05/2017.
 */
@Controller
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    public EquipamientoController(EquipamientoService equipamientoService){
        this.equipamientoService = equipamientoService;
    }

    @GetMapping("/equip")
    public String equip(Model model) throws IOException {
        model.addAttribute("equips", equipamientoService.findAll());
        return "admin/equip_list";
    }

    @PostMapping("/equip")
    public RedirectView equip(Equipamiento equipamiento) throws IOException {
        equipamientoService.putObject(equipamiento);

        return new RedirectView("/equip");
    }

    @PostMapping("/equip_del")
    public RedirectView equip(@RequestBody String id) throws IOException {
        JSONObject obj = new JSONObject(id);
        equipamientoService.deleteObject(obj.getString("id"));

        return new RedirectView("/equip");
    }
}
