package adaseptimaback.neflisPersistence;
import adaseptimaback.Netflis2model.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


    @Component
    public class NeflisStorage {
        private ObjectMapper objectMapper;

        public NeflisStorage(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }

        public List<Response> peliculas() {
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
        public List<Response> series() {
            try {
                return objectMapper.readValue(
                        new File("src\\main\\resources\\serie.json"),
                        new TypeReference<List<Response>>() {
                        }
                );

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("No se pudo leer el archivo",e);

            }
        }


        public List<Response> contenidos(){
            List<Response> contenidos= new ArrayList<>();
            contenidos.addAll(this.series());
            contenidos.addAll(this.peliculas());
            return contenidos;

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
