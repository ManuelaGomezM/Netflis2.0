package adaseptimaback.Netflis2model;

import java.util.ArrayList;
import java.util.List;

public class Serie implements Contenido {

    private String nombreDeSerie;
    private List<Actor> actoresFijosDeLaSerie = new ArrayList<>();
    private List<Temporada> temporadas = new ArrayList<>();
    public String genero;



    public Serie(String nombreDeSerie, String genero){
        this.nombreDeSerie=nombreDeSerie;
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

    public Integer cuantasTemporadasTenes() {

        return this.temporadas.size();
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

    public Integer cuantoDura(){
        return duracionDeTodaLaSerieEnMinutos();
    }



    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

