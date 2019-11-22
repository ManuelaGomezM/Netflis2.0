package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public abstract class UnidadDeContenido implements Contenido {
    @JsonProperty ("genre")
    public String genero;
    @JsonProperty("title")
    private String titulo;
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("duration")
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
