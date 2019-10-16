package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Contenido;
import adaseptimaback.Netflis2model.UnidadDeContenido;
import adaseptimaback.Netflis2model.Usuario;
import adaseptimaback.neflisPersistence.NeflisStorage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


    @Service

    public class NeflisService {
        private List<UnidadDeContenido> contenidos;
        private NeflisStorage neflisStorage;
        private Integer id;
        private List<Usuario> usuarios;

        public NeflisService(NeflisStorage neflisStorage){
            this.neflisStorage= neflisStorage;
        }

        public List<UnidadDeContenido> contenidos(String titulo) {
            contenidos=neflisStorage.contenidos();
            if (titulo == null)
                return contenidos;
            else {
                return contenidos.stream().filter(contenido ->contenido.getTitulo().equals(titulo))
                        .collect(Collectors.toList());
            }
        }

        public List<UnidadDeContenido> getContenidos() {
            return contenidos;
        }

        public List<Contenido> contenidosDestacados(Usuario user, Integer id){
            return
                    this.usuarios.stream().
                            filter(u -> u.getId().equals(id)).findFirst().get()
                    .contenidosIncompletos();
          //  this.neflisStorage.contenidosDestacados();
        }

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

}
