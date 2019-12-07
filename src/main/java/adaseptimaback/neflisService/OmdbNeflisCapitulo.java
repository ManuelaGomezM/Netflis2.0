package adaseptimaback.neflisService;
import adaseptimaback.Netflis2model.Capitulo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbNeflisCapitulo {
    private String Title;
    private String Episode;
// hacer constructores de omdb con json properties
    public OmdbNeflisCapitulo(){}
    @JsonCreator
    public OmdbNeflisCapitulo(
            @JsonProperty String Episode,
            @JsonProperty String Title) {
        this.Episode = Episode;
        this.Title=Title;
    }


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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
