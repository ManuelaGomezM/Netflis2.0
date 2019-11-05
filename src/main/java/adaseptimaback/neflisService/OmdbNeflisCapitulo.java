package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Capitulo;
import adaseptimaback.Netflis2model.Temporada;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OmdbNeflisCapitulo {

    private String Episode;
// hacer constructores de omdb con json properties

    public Capitulo convertirOmdbACapitulo() {
        Capitulo cap = new Capitulo();
        cap.setNumeroDeCapitulo(Integer.valueOf(this.getEpisode()));
        return cap;


    }

    public String getEpisode() {
        return Episode;
    }

    public void setEpisode(String episode) {
        Episode = episode;
    }
}
