package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Temporada  {
    @Id
    @GeneratedValue
    private Long id;
    //@JsonIgnore
    private Serie serie;
    //@JsonProperty("number")
    private Integer numeroDeTemporada;
    //@JsonProperty("Episodes")
    private List<Capitulo> capitulos = new ArrayList<>();

    public Integer sizeTemporada() {
        return getCapitulos().size();
    }

    public Integer getNumeroDeTemporada() {
        return numeroDeTemporada;
    }

    public void setNumeroDeTemporada(Integer numeroDeTemporada) {
        this.numeroDeTemporada = numeroDeTemporada;
    }

    public void agregarCapitulo(Capitulo unCapitulo) {
        this.getCapitulos().add(unCapitulo);
    }

    public boolean vistoCompleto(Usuario unUsuario) {
        return this.getCapitulos().stream()
                .allMatch(capitulo -> capitulo.vistoCompleto(unUsuario));
    }

    public Integer cuantosMinutosDuraLatemporadaCompleta() {
        return getCapitulos().stream()
                .mapToInt(capitulo -> capitulo.getDuracion())
                .sum();
    }

    public Capitulo ultimoCapituloDisponible() {
        return getCapitulos().get(getCapitulos().size()-1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }
}
