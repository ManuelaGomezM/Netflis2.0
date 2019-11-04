package adaseptimaback.neflisService;

import adaseptimaback.Netflis2model.Capitulo;
import adaseptimaback.Netflis2model.Temporada;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties (ignoreUnknown = true)
public class OmdbNeflisClase implements Serializable {
    private String Title;
    private String Year;
    private String Director;
    private String Runtime;
    private String Plot;
    private String Actors;
    private String totalSeasons = null;
    private String Type;
    private String Genre;
    private Integer Seasons;
    @JsonCreator
    public OmdbNeflisClase(@JsonProperty String Title,
                           @JsonProperty String Year,
                           @JsonProperty String Director,
                           @JsonProperty String Runtime,
                           @JsonProperty String Plot,
                           @JsonProperty String Actors,
                           @JsonProperty String totalSeasons,
                           @JsonProperty String Type,
                           @JsonProperty String Genre,
                           @JsonProperty String Season) {
        this.Title = Title;
        this.Year = Year;
        this.Director = Director;
        this.Runtime = Runtime;
        this.Plot = Plot;
        this.Actors = Actors;
        this.totalSeasons = totalSeasons;
        this.Type = Type;
        this.Genre=Genre;

    }

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
    public String getTotalSeasons() {
        return totalSeasons;
    }
    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }
    /*private String Title;
    private String Year;
    private String Director;
    private String Runtime;
    private String Plot;
    private String Actors;
    private Integer totalSeasons = null;
    private String Type;

    public OmdbNeflisClase(String title, String year, String director, String runtime, String plot, String actors, Integer totalSeasons, String type) {
        this.Title = title;
        this.Year = year;
        this.Director = director;
        this.Runtime = runtime;
        this.Plot = plot;
        this.Actors = actors;
        this.totalSeasons = totalSeasons;
        this.Type = type;
    }



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

    public Integer getNumber_of_seasons() {
        return totalSeasons;
    }

    public void setNumber_of_seasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
*/




}
