package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Serie implements Contenido {
    @JsonProperty ("title")
    private String nombreDeSerie;
    @JsonProperty("actors")
    private List<Actor> actoresFijosDeLaSerie = new ArrayList<>();
    @JsonProperty ("seasons")
    private List<Temporada> temporadas = new ArrayList<>();
    @JsonProperty ("genre")
    private String genero;
    private Long id;


    public Serie(){}


    public Serie(String nombreDeSerie, String genero){
        this.setNombreDeSerie(nombreDeSerie);
        this.genero=genero;
    }

    public void setActoresFijosDeLaSerie (Actor unActor){
        this.actoresFijosDeLaSerie.add(unActor);
    }

    public Boolean actuo(Actor actor){

        return actoresFijosDeLaSerie.contains(actor);
    }

    public void agregarTemporada(Temporada unaTemporada) {

        this.temporadas.add(unaTemporada);
    }
    @JsonProperty("number_of_seasons")
    public Integer totalSeasons() {

        return this.temporadas.size();
    }

    public Temporada ultimaTemporadadisponible() {
        return temporadas.get(temporadas.size()-1);
    }

    public Capitulo ultimoCapituloDeLaSerie(){
        return this.ultimaTemporadadisponible().ultimoCapituloDisponible();
    }
    public boolean vistoCompleto(Usuario unUsuario) {
        return this.temporadas.stream()
                .allMatch(temporada -> temporada.vistoCompleto(unUsuario));

    }
    public Integer duracionDeTodaLaSerieEnMinutos() {
        return temporadas.stream()
                .mapToInt(t -> t.cuantosMinutosDuraLatemporadaCompleta())
                .sum();
    }
    @JsonProperty( "number_of_episodes")
    public Integer cantidadDeCapitulosenLaSerie(){
        return this.temporadas.stream()
                .mapToInt(t->t.sizeTemporada())
                .sum();
    }

    public Integer getDuracion(){
        return duracionDeTodaLaSerieEnMinutos();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return nombreDeSerie;
    }

    public void setNombreDeSerie(String nombreDeSerie) {
        this.nombreDeSerie = nombreDeSerie;
    }

    public List<String> nombresDeActores(){
        return this.actoresFijosDeLaSerie.stream()
                .map(actor -> actor.getName())
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

