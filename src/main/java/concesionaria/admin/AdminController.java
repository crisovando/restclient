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

import java.io.IOException;

/**
 * Created by fabia on 01/05/2017.
 */
@Controller
public class AdminController {

    private final EquipamientoService equipamientoService;

    @ModelAttribute("module")
    String module() {
        return "admin";
    }

    public AdminController(EquipamientoService equipamientoService){
        this.equipamientoService = equipamientoService;
    }

    @GetMapping("/equip")
    public String equip(Model model) throws IOException {
        model.addAttribute("equips", equipamientoService.findAll());
        return "admin/equip_list";
    }

    @PutMapping(value = "/equip")
    public String equip(Equipamiento equipamiento, Model model) throws IOException {
        equipamientoService.putObject(equipamiento);
        model.addAttribute("equips", equipamientoService.findAll());
        return "admin/equip_list";
    }
}
