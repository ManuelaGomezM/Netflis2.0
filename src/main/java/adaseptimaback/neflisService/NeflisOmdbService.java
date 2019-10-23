package adaseptimaback.neflisService;

import org.springframework.web.client.RestTemplate;

public class NeflisOmdbService {
    //aca detallar clase con atributos omdb

    public OmdbNeflisClase omdbResponse(){
        final String uri = " http://www.omdbapi.com/?apikey=f6038a82&t=";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, OmdbNeflisClase.class);


    }
}
