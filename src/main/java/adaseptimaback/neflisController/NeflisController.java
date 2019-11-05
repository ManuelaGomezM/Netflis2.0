package adaseptimaback.neflisController;
import adaseptimaback.Netflis2model.Response;
import adaseptimaback.neflisService.NeflisContenidoService;
import adaseptimaback.neflisService.NeflisOmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

    @RestController

    public class NeflisController {

        @Autowired
        private NeflisContenidoService neflisContenidoService;
        @Autowired
        private NeflisOmdbService neflisOmdbService;


        @GetMapping("/contents")
        public List<Response> contenidos(@RequestParam(value = "titulo", required = false) String titulo) {
          //  if (neflisContenidoService.contenidos(titulo).equals(false));{
                return neflisContenidoService.contenidos(titulo);
        }
        @GetMapping("/contenido")
        public Response contenidoOmdb(@RequestParam(value = "title") String titulo) {
                return neflisOmdbService.contenido(titulo);



      /**  @PostMapping("/mascotas")
        public Mascota addMascota(@RequestBody Mascota mascota) {
            return this.mascotaService.agregarMascota(mascota);
        }


        @PatchMapping("/mascotas/{id}")
        public Mascota modifyMascota(@RequestBody Mascota mascota,@PathVariable (value="id") Integer id){
            return this.mascotaService.updateMascota(mascota,id);

        }}*/
        }
    }