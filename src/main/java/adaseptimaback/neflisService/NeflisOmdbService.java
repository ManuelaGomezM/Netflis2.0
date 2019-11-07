package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class NeflisOmdbService {
    //aca detallar clase con atributos omdb
   RestTemplate restTemplate ;
    @Autowired
    private ObjectMapper objectMapper;
    @Bean
    public RestTemplate restTemplate(){
        restTemplate = new RestTemplate();
        return restTemplate;
    }

    public OmdbNeflisClaseContenido omdbResponsePorTitulo(String title){
        try {
            final String uri = "http://www.omdbapi.com/?apikey=f6038a82&t=" + title.toLowerCase();
            String json = restTemplate.getForObject(uri, String.class);
            OmdbNeflisClaseContenido omdbContent = objectMapper.readValue(json, OmdbNeflisClaseContenido.class);
            return omdbContent;
        }
        catch (IOException ioe) {
            throw new RuntimeException("problem in serialization", ioe);
        }
    }
    public OmdbNeflisTemporada omdbResponsePorTituloTEmp1(String title){
    try {
        final String uri = "http://www.omdbapi.com/?apikey=f6038a82&t=" + title.toLowerCase()+"&season=1";
        String json = restTemplate.getForObject(uri, String.class);
        OmdbNeflisTemporada omdbTemp1 = objectMapper.readValue(json, OmdbNeflisTemporada.class);
        return omdbTemp1;
    }
        catch (IOException ioe) {
        throw new RuntimeException("problem in serialization", ioe);
    }
}
    public Response contenido(String titulo) {
        Response response = new Response();
       response.conviertoOmdbAResponse(this.omdbResponsePorTitulo(titulo));
       if(response.getNumber_of_seasons() != null){
           response.addSeason(this.omdbResponsePorTituloTEmp1(titulo).convertirOmdbATemporada());
       }
       return response;
    }
    //
//    @Autowired
//    RestTemplate restTemplate ;
//
//    @Bean
//    public RestTemplate restTemplate(){
//        restTemplate = new RestTemplate();
//        return restTemplate;
//    }
//
//        public OmdbNeflisClaseContenido omdbResponsePorTitulo(String title){
//            final String uri = "http://www.omdbapi.com/?apikey=f6038a82&t="+title.toLowerCase();
//            return restTemplate.getForObject(uri, OmdbNeflisClaseContenido.class);
//
//    }
//    public Response contenido(String titulo){
//        Response response= new Response();
//        return response.conviertoOmdbAResponse(this.omdbResponsePorTitulo(titulo));
//
//    }
//
//
//}
}
