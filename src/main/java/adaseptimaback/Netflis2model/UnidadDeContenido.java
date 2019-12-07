package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Unidad de Contenido")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class UnidadDeContenido implements Contenido {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name= "incrementator",strategy = "increment")
    @Column(name="IdUC", unique = true, nullable = false)
    private Long id;
    //@JsonProperty ("genre")
    @Column(name="GenreUC", unique = true, nullable = false)
    public String genero;
   // @JsonProperty("title")
   @Column(name="TitleUC", unique = true, nullable = false)
    private String titulo;
   // @JsonProperty("duration")
   @Column(name="DuracionUC", unique = true, nullable = false)
    private Integer duracion;

    public UnidadDeContenido(){    }

    public boolean vistoCompleto(Usuario unUsuario) {
        return unUsuario.contenidoFueVisto(this);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Boolean actuo(Actor actor) {
        return actor.actuoEn(this);
    }

    public void setDuracion(Integer duracion)
    {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
