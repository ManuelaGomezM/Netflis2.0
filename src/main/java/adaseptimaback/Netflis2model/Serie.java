package adaseptimaback.Netflis2model;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="Serie", uniqueConstraints = {@UniqueConstraint(columnNames={"Id"})})
public class Serie implements Contenido {


    //@JsonProperty ("title")
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name= "incrementator",strategy = "increment")
    @Column(name="Id", unique = true, nullable = false)
    private Long id;
     //@JsonProperty ("title")
     @Column(name="Title", unique = true, nullable = false)

    private String nombreDeSerie;
   // @JsonProperty("actors")
   @Column(name="ActoresFijos", unique = true, nullable = false)
    private List<Actor> actoresFijosDeLaSerie = new ArrayList<>();
   // @JsonProperty ("seasons")
   @Column(name="Seasons", unique = true, nullable = false)
    private List<Temporada> temporadas = new ArrayList<>();
   // @JsonProperty ("genre")
   @Column(name="Genre", unique = true, nullable = false)
    private String genero;

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
   // @JsonProperty( "number_of_episodes")
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

