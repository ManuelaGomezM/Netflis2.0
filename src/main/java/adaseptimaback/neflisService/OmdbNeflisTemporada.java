package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Capitulo;
import adaseptimaback.Netflis2model.Temporada;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbNeflisTemporada {
    private String Season;
    private List<OmdbNeflisCapitulo> Episodes;
    public OmdbNeflisTemporada(){}
    @JsonCreator
    public OmdbNeflisTemporada(@JsonProperty String Season,
                                @JsonProperty List<OmdbNeflisCapitulo> Episodes){
        this.Season=Season;
        this.Episodes=Episodes;
    }
    public String getSeason() {
        return Season;
    }
    public void setSeason(String season) {
        Season = season;
    }
    public List<OmdbNeflisCapitulo> getEpisodes() {
        return Episodes;
    }
    public void setEpisodes(List<OmdbNeflisCapitulo> episodes) {
        Episodes = episodes;
    }
    public List<Capitulo> convertirEpisodiosACapitulos(){
        return this.Episodes.stream()
                .map(c->c.convertirOmdbACapitulo()).
                        collect(Collectors.toList());
    }
    public Temporada convertirOmdbATemporada(){
        Temporada temporada= new Temporada();
        temporada.setNumeroDeTemporada(Integer.valueOf(this.getSeason()));
        temporada.setCapitulos(this.convertirEpisodiosACapitulos());
        return  temporada;
    }
}
