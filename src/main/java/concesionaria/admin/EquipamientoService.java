package concesionaria.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import concesionaria.model.Automovil;
import concesionaria.model.Equipamiento;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EquipamientoService {

    public EquipamientoService(){}

    public Equipamiento[] findAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> autoResponse = restTemplate.exchange("https://apiconcesionaria.herokuapp.com/v1/equipamiento",
                HttpMethod.GET,null, String.class);

        Equipamiento[] obj = mapper.readValue(autoResponse.getBody(), Equipamiento[].class);

        return obj;
    }

    public Boolean putObject(Equipamiento equipamiento){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("https://apiconcesionaria.herokuapp.com/v1/equipamiento", equipamiento);
        return true;
    }

    public Boolean deleteObject(String id){

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("https://apiconcesionaria.herokuapp.com/v1/equipamiento", params);
        return true;
    }
}
