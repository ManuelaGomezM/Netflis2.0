package adaseptimaback.neflisService;
import adaseptimaback.Netflis2model.Contenido;
import adaseptimaback.Netflis2model.Response;
import adaseptimaback.neflisPersistence.NeflisStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


    @Service

    public class NeflisContenidoService {
        private List<Response> contenidos;
        @Autowired
        private NeflisStorage neflisStorage;
        private Integer id;


        public List<Response> contenidos(String titulo) {
            contenidos = neflisStorage.contenidos();
            try {
                if (titulo == null) {
                    return contenidos;
                } else {
                    return contenidos.stream().filter(response -> response.getTitle().equals(titulo))
                            .collect(Collectors.toList());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }return null;


      }
    }

        /*esta en rojo y no se por que
            public List<UnidadDeContenido> getContenidos() {
            return contenidos;
        }*/


   /**     public Contenido agregarContenido (Mascota newMascota){
            newMascota.setId(this.id);
            this.id++;
            this.getMascotas().add(newMascota);
            this.mascotaStorage.nuevaMascota(mascotas);
            return newMascota;
        }

        public Mascota updateMascota( Mascota reqMascota, Integer id){
            Mascota mascotaAModificar=( mascotas.stream().filter(mascota -> mascota.getId().equals(id)).findFirst().get());
            if (reqMascota.getDuenie()!=null)mascotaAModificar.setDuenie(reqMascota.getDuenie());
            if (reqMascota.getNombre()!=null)mascotaAModificar.setNombre(reqMascota.getNombre());
            if (reqMascota.getEdad()!=null)mascotaAModificar.setEdad(reqMascota.getEdad());
            if (reqMascota.getTipo()!=null) mascotaAModificar.setTipo(reqMascota.getTipo());
            return mascotaAModificar;

        }
    }*/

