package adaseptimaback.Netflis2;

import java.util.ArrayList;
import java.util.List;

public class Capitulo extends UnidadDeContenido {

    private Integer numeroDeCapitulo;
    private List<Actor> actoresInvitados= new ArrayList<>();
    private Integer duracionDeCapitulo;
    private Temporada temporada;
    private Serie serie;

    public Capitulo(Integer numeroDeCapitulo, Integer duracionDeCapitulo, Temporada temporada){
        super();
        this.numeroDeCapitulo=numeroDeCapitulo;
        this.setDuracionDeCapitulo(duracionDeCapitulo);
        this.temporada=temporada;

    }

    public void setActoresInvitados (Actor unActorInvitado){

        this.getActoresInvitados().add(unActorInvitado);
    }

    public Boolean actuo(Actor actor){

        return getActoresInvitados().contains(actor);
    }


    public Integer cuantoDura() {

        return getDuracionDeCapitulo();
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


    public Integer getDuracionDeCapitulo() {
        return duracionDeCapitulo;
    }

    public void setDuracionDeCapitulo(Integer duracionDeCapitulo) {
        this.duracionDeCapitulo = duracionDeCapitulo;
    }
}
