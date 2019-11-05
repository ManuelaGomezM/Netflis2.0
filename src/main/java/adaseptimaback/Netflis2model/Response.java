package adaseptimaback.Netflis2model;

import adaseptimaback.neflisService.OmdbNeflisClaseContenido;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {
    private Long id;
    private String title = null;
    private String year = null;
    private String director;
    private Integer duration = null;
    private String genre = null;
    private String actors = null;
    private String plot = null;
   private List<Temporada> seasons = null;
    //private Integer seasons=null;
  //  private List<Capitulo> episodes = null;
    private Integer number_of_seasons =null;
    private Integer number_of_episodes=null;
    private Serie serie;
    public Response() {
    }
    public Response(Contenido c) {
        this.id = c.getId();
        this.title = c.getTitulo();
        this.duration = c.getDuracion();
        this.actors = String.join(" , ",c.nombresDeActores());
        this.genre = c.getGenero();

    }
 public Response conviertoOmdbAResponse(OmdbNeflisClaseContenido omdbNeflisClase){
        this.title=omdbNeflisClase.getTitle();
        this.actors=omdbNeflisClase.getActors();
        this.year=omdbNeflisClase.getYear();
        this.director=omdbNeflisClase.getDirector();
        this.duration= Integer.valueOf(omdbNeflisClase.getRuntime().split("\\s")[0]);
        this.plot=omdbNeflisClase.getPlot();
        this.number_of_seasons =(Integer.valueOf(omdbNeflisClase.getTotalSeasons()));//ver esto
        this.genre=omdbNeflisClase.getGenre();

        return this;
    }

    public void addSeason(Temporada temporada){
        this.seasons.add(temporada);
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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

 //  public Integer getSeasons() {
    // return this.seasons;
   // }

  //  public void setSeasons(Integer seasons) {
   //    this.seasons = seasons;
   // }

  //  public List<Capitulo> getEpisodes() {
    //    return episodes;
    //}

   // public void setEpisodes(List<Capitulo> episodes) {
      //  this.episodes = episodes;
    //}

    public Integer getNumber_of_seasons() {
        return this.number_of_seasons;
    }

   public void setNumber_of_seasons(Integer number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public Integer getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(Integer number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public List<Temporada> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Temporada> seasons) {
        this.seasons = seasons;
    }
}