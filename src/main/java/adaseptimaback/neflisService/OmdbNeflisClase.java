package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Capitulo;
import adaseptimaback.Netflis2model.Temporada;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties (ignoreUnknown = true)
public class OmdbNeflisClase implements Serializable {

    private String Title;
    private String Year;
    private String Director;
    private String Runtime;

    public OmdbNeflisClase(String title, String year, String director, String runtime, String plot, String actors, Integer totalSeasons, String type) {
        Title = title;
        Year = year;
        Director = director;
        Runtime = runtime;
        Plot = plot;
        Actors = actors;
        this.totalSeasons = totalSeasons;
        Type = type;
    }

    private String Plot;
    private String Actors;
    private Integer totalSeasons = null;
    private String Type;

    public OmdbNeflisClase(){}



    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }





}
