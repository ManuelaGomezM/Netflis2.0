package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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

    public OmdbNeflisClase omdbResponsePorTitulo(String title){
        try {
            final String uri = "http://www.omdbapi.com/?apikey=f6038a82&t=" + title.toLowerCase();
            String json = restTemplate.getForObject(uri, String.class);
            OmdbNeflisClase omdbContent = objectMapper.readValue(json, OmdbNeflisClase.class);
            return omdbContent;
        }
        catch (IOException ioe) {
            throw new RuntimeException("problem in serialization", ioe);
        }
    }
    public Response contenido(String titulo){
        Response response= new Response();
        return response.conviertoOmdbAResponse(this.omdbResponsePorTitulo(titulo));
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
//        public OmdbNeflisClase omdbResponsePorTitulo(String title){
//            final String uri = "http://www.omdbapi.com/?apikey=f6038a82&t="+title.toLowerCase();
//            return restTemplate.getForObject(uri, OmdbNeflisClase.class);
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
