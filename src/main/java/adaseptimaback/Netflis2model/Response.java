package adaseptimaback.Netflis2model;

import adaseptimaback.neflisService.OmdbNeflisClase;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {
    private Long id;
    private String title = null;
    private String year = null;
    private String director;
    private Integer duration = null;
    private String genre = null;
    private List<String> actors = null;
    private String plot = null;
    private List<Temporada> seasons = null;
     private List<Capitulo> episodes = null;
    private OmdbNeflisClase omdbNeflisClase;
    private Integer totalSeasons=null;



    public Response() {
    }

    public Response(Contenido c) {
        this.id = c.getId();
        this.title = c.getTitulo();
        this.duration = c.getDuracion();
        this.actors = c.nombresDeActores();
        this.genre = c.getGenero();
    }

 public void conviertoOmdbAResponse(OmdbNeflisClase omdbNeflisClase){
        this.title=omdbNeflisClase.getTitle();
        this.actors=omdbNeflisClase.getActors();
        this.year=omdbNeflisClase.getYear();
        this.director=omdbNeflisClase.getDirector();
        this.duration= Integer.valueOf(omdbNeflisClase.getRuntime().split("\\s")[0]);
        this.plot=omdbNeflisClase.getPlot();
        this.totalSeasons=omdbNeflisClase.getTotalSeasons();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public List<Temporada> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Temporada> seasons) {
        this.seasons = seasons;
    }

    public List<Capitulo> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Capitulo> episodes) {
        this.episodes = episodes;
    }
}