package adaseptimaback.Netflis2model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//Se comentaron las anotations de jackson porque la idea es migrar esa busqueda inicial a la base de datos.


public class Capitulo extends UnidadDeContenido {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name= "incrementator",strategy = "increment")
    @Column(name="Id", unique = true, nullable = false)
    private Long id;

   // @JsonProperty ("number")
    @Column(name= "NumerodeCapitulo")
    private Integer numeroDeCapitulo;
   // @JsonProperty("guest_actors")
    @Column (name= "ActoresInvitadosCap")
    private List<Actor> actoresInvitados = new ArrayList<>();

    //@JsonIgnore
    @Column (name="Temporada")
    private Temporada temporada;
    //@JsonIgnore

    @Column(name="Serie")
    private Serie serie;

    public Capitulo(){
         }

    public Capitulo(Integer numeroDeCapitulo, Integer duracionDeCapitulo, Temporada temporada, Serie serie) {
        this.numeroDeCapitulo = numeroDeCapitulo;
        this.setDuracion(duracionDeCapitulo);
        this.setTemporada(temporada);
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

    public Boolean actuo(Actor actor) { return getActoresInvitados().contains(actor); }

    public Integer getNumeroDeCapitulo() { return numeroDeCapitulo; }

    public void setNumeroDeCapitulo(Integer numeroDeCapitulo) { this.numeroDeCapitulo = numeroDeCapitulo; }

    public List<Actor> getActoresInvitados() {
        return actoresInvitados;
    }

    public Serie getSerie() {
            return serie;
        }

    public void setSerie(Serie serie) { this.serie = serie; }

    public String generoDeSerie(){
        return this.getSerie().getGenero();
    }

    public Response conviertoContenidoAResponse(){
        Response response = new Response();
        response.setGenre(this.genero);
        response.setDuration(this.getDuracion());
        response.setTitle(this.getTitulo());
        return response;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }
}