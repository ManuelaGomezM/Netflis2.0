package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Inheritance(strategy= InheritanceType.JOINED)

public abstract class UnidadDeContenido implements Contenido {

    public String genero;
   // @JsonProperty("title")
    private String titulo;
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
   // @JsonProperty("duration")
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
