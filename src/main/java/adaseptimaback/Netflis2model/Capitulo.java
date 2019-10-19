package adaseptimaback.Netflis2model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Capitulo extends UnidadDeContenido {
    private Integer numeroDeCapitulo;
    private List<Actor> actoresInvitados = new ArrayList<>();
    private Temporada temporada;
    private Serie serie;

    public Capitulo(){}



    public Capitulo(Integer numeroDeCapitulo, Integer duracionDeCapitulo, Temporada temporada, Serie serie) {
        this.numeroDeCapitulo = numeroDeCapitulo;
        this.setDuracion(duracionDeCapitulo);
        this.temporada = temporada;
        this.setSerie(serie);
        this.setGenero(this.serie.getGenero());

    }



    public void setActoresInvitados(Actor unActorInvitado) {

        this.getActoresInvitados().add(unActorInvitado);
    }

    public List<String> nombresDeActores(){
        return this.actoresInvitados.stream()
                .map(actor -> actor.getName())
                .collect(Collectors.toList());
    }
    public Boolean actuo(Actor actor) {

        return getActoresInvitados().contains(actor);
    }


     public Integer getNumeroDeCapitulo() {

        return numeroDeCapitulo;
    }

    public void setNumeroDeCapitulo(Integer numeroDeCapitulo) {

        this.numeroDeCapitulo = numeroDeCapitulo;
    }



    public List<Actor> getActoresInvitados() {
        return actoresInvitados;
    }


    public Serie getSerie() {
            return serie;
        }



    public void setSerie(Serie serie) {
        this.serie = serie;

    }
    public String generoDeSerie(){
        return this.getSerie().getGenero();
    }


}