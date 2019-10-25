package adaseptimaback.neflisPersistence;
import adaseptimaback.Netflis2model.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.List;


    @Component
    public class NeflisStorage {
        private ObjectMapper objectMapper;

        public NeflisStorage(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        public List<Response> contenidos() {
            try {
                return objectMapper.readValue(
                        new File("src\\main\\resources\\peliculas.json"),
                        new TypeReference<List<Response>>() {
                        }
                );

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("No se pudo leer el archivo",e);

            }
        }



     /**   public void nuevoContenido (List <Contenido> contenidosActualizados){
            try {
                objectMapper.writeValue(
                        new File("verRuta"),contenidosActualizados);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("No se pudo escribir es archivo",e);

            }

        }


    }*/
}
