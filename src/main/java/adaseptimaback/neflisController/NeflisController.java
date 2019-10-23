package adaseptimaback.neflisController;
import adaseptimaback.Netflis2model.Contenido;
import adaseptimaback.Netflis2model.Response;
import adaseptimaback.Netflis2model.UnidadDeContenido;
import adaseptimaback.neflisService.NeflisService;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

    @RestController

    public class NeflisController {

        private NeflisService neflisService;

        public NeflisController (NeflisService neflisservice) {
            this.neflisService = neflisService;
        }

        @GetMapping("/contents")
        public List<Response> contenidos(@RequestParam(value = "titulo", required = false) String titulo) {
            if (neflisService.contenidos(titulo).equals(false));{

                return neflisService.contenidos(titulo);
        }

      /**  @PostMapping("/mascotas")
        public Mascota addMascota(@RequestBody Mascota mascota) {
            return this.mascotaService.agregarMascota(mascota);
        }


        @PatchMapping("/mascotas/{id}")
        public Mascota modifyMascota(@RequestBody Mascota mascota,@PathVariable (value="id") Integer id){
            return this.mascotaService.updateMascota(mascota,id);

        }}*/
        }}
