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
               /* esto va en el Storage/persistence
                try {

                    URL url = new URL(" http://www.omdbapi.com/?apikey=f6038a82&t="+titulo);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");

                    if (conn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

                    String output;
                    System.out.println("Output from Server .... \n");
                    while ((output = br.readLine()) != null) {
                        System.out.println(output);
                    }

                    conn.disconnect();

                } catch (MalformedURLException e) {

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();


                }*/
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
