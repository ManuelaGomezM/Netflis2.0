package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Response;
import adaseptimaback.neflisPersistence.NeflisStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OmdbContentService {
    RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private NeflisOmdbService neflisOmdbService;
    @Autowired
    private NeflisContenidoService neflisContenidoService;
    @Autowired
    private NeflisStorage neflisStorage;

    @Bean
    public RestTemplate restTemplate2() {
        restTemplate = new RestTemplate();
        return restTemplate;
    }

    //cuando busquemos por titulo, en realidad deberiamos buscar  por ID pues titulo no es clave unica.primaria
    public List<Response> contenidosGenerales(String titulo) {
        List<Response> conteniditos = this.neflisStorage.contenidos();
        if (titulo == null) {
            return conteniditos;
        } List<Response> contenidito = this.neflisContenidoService.filtrarContenidoPorTitulo2(titulo,conteniditos);
            if (contenidito==null||contenidito.isEmpty()) {
                List<Response> conteniditoOmdb = new ArrayList<>();
                conteniditoOmdb.add(this.neflisOmdbService.contenido(titulo));
                conteniditos.add(this.neflisOmdbService.contenido(titulo));
                this.neflisStorage.save(conteniditos);
                return conteniditoOmdb;
            } else if (!contenidito.isEmpty()) {
                return contenidito;
            }
            return null;
        }
    }


