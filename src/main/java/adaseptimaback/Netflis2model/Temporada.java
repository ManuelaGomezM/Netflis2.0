package adaseptimaback.Netflis2model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Temporada  {
    @JsonIgnore
    private Serie serie;
    @JsonProperty("number")
    private Integer numeroDeTemporada;
    @JsonProperty("episodes")
    private List<Capitulo> capitulos = new ArrayList<>();

    private Long id;



    public Integer cantidadDeCapitulosEnTemporada() {
        return capitulos.size();
    }

    public Integer getNumeroDeTemporada() {
        return numeroDeTemporada;
    }

    public void setNumeroDeTemporada(Integer numeroDeTemporada) {
        this.numeroDeTemporada = numeroDeTemporada;
    }

    public void agregarCapitulo(Capitulo unCapitulo) {
        this.capitulos.add(unCapitulo);
    }

    public boolean vistoCompleto(Usuario unUsuario) {
        return this.capitulos.stream()
                .allMatch(capitulo -> capitulo.vistoCompleto(unUsuario));
    }

    public Integer cuantosMinutosDuraLatemporadaCompleta() {
        return capitulos.stream()
                .mapToInt(capitulo -> capitulo.getDuracion())
                .sum();
    }

    public Capitulo ultimoCapituloDisponible() {
        return capitulos.get(capitulos.size()-1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
