package concesionaria.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import concesionaria.model.Modelo;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.HashMap;

@Service
public class ModelosService {
    private String urlApi = "https://apiconcesionaria.herokuapp.com/v1/automovil";

    public ModelosService(){}

    public Modelo[] findAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> autoResponse = restTemplate.exchange(urlApi,
                HttpMethod.GET,null, String.class);

        Modelo[] obj = mapper.readValue(autoResponse.getBody(), Modelo[].class);

        return obj;
    }

    public Boolean putObject(Modelo equipamiento){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(urlApi, equipamiento);
        return true;
    }

    public Boolean deleteObject(String nombre){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("nombre",nombre);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(urlApi, params);
        return true;
    }
}
