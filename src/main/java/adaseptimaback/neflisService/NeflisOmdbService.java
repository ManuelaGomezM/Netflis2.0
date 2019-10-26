package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Response;
import org.springframework.web.client.RestTemplate;

public class NeflisOmdbService {
    //aca detallar clase con atributos omdb

    public OmdbNeflisClase omdbResponse() {
        final String uri = " http://www.omdbapi.com/?apikey=f6038a82&t=";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, OmdbNeflisClase.class);
    }
        public OmdbNeflisClase omdbResponsePorTitulo(String title){
            final String uri = " http://www.omdbapi.com/?apikey=f6038a82&t="+title.toLowerCase();

            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(uri, OmdbNeflisClase.class);

    }
    public Response contenido(String titulo){
        Response response= new Response();
        response.conviertoOmdbAResponse(this.omdbResponsePorTitulo(titulo));
        return response;
    }


}
