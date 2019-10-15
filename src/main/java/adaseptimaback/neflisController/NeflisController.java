package adaseptimaback.neflisController;
import adaseptimaback.Netflis2model.Contenido;
import adaseptimaback.Netflis2model.UnidadDeContenido;
import adaseptimaback.Netflis2model.Usuario;
import adaseptimaback.neflisService.NeflisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController

    public class NeflisController {

        private NeflisService neflisService;

        public NeflisController (NeflisService neflisservice) {
            this.neflisService = neflisService;
        }

        @GetMapping("/contents")
        public List<UnidadDeContenido> contenidos(@RequestParam(value = "titulo", required = false) String titulo) {
            return neflisService.contenidos(titulo);
        }

        @GetMapping("/user/{id}featuredcontents")
        public List<Contenido> contenidosDestacados(Usuario user,@PathVariable (value="id") Integer id ){
            return this.neflisService.contenidosDestacados(user, id);
        }

      /**  @PostMapping("/mascotas")
        public Mascota addMascota(@RequestBody Mascota mascota) {
            return this.mascotaService.agregarMascota(mascota);
        }


        @PatchMapping("/mascotas/{id}")
        public Mascota modifyMascota(@RequestBody Mascota mascota,@PathVariable (value="id") Integer id){
            return this.mascotaService.updateMascota(mascota,id);
        }}*/
}
