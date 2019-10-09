package adaseptimaback.Netflis2;

import java.util.ArrayList;
import java.util.List;


public class Capitulo extends UnidadDeContenido {
    private Integer numeroDeCapitulo;
    private List <Actor> actoresInvitados= new ArrayList<>();
    private Integer duracionDeCapitulo;
    private Temporada temporada;
    private Serie serie;


    public String generoDeSerie(){
        return this.getSerie().getGenero();
    }


    public Capitulo(Integer numeroDeCapitulo, Integer duracionDeCapitulo, Temporada temporada, Serie serie){
        this.numeroDeCapitulo=numeroDeCapitulo;
        this.duracionDeCapitulo=duracionDeCapitulo;
        this.temporada=temporada;
        this.setSerie(serie);
        this.setGenero(generoDeSerie());
    }


    public void setActoresInvitados (Actor unActorInvitado){

        this.actoresInvitados.add(unActorInvitado);
    }

    public Boolean actuo(Actor actor){

        return actoresInvitados.contains(actor);
    }


    public Integer cuantoDura() {

        return duracionDeCapitulo;
    }


    public Integer getNumeroDeCapitulo() {

        return numeroDeCapitulo;
    }

    public void setNumeroDeCapitulo(Integer numeroDeCapitulo) {

        this.numeroDeCapitulo = numeroDeCapitulo;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
