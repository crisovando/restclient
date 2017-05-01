package springmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Automovil;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * Created by cristian.ovando on 26/04/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Principal principal) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> autoResponse = restTemplate.exchange("https://apiconcesionaria.herokuapp.com/v1/automovil",
                                                        HttpMethod.GET,null, String.class);

        Automovil[] obj = mapper.readValue(autoResponse.getBody(), Automovil[].class);
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
}
