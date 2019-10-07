package adaseptimaback.Netflis2;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private Serie serie;
    private Integer numeroDeTemporada;
    public List<Capitulo> capitulos2 = new ArrayList<>();


    public Integer cantidadDeCapitulosEnTemporada() {
        return capitulos2.size();
    }

    public Integer getNumeroDeTemporada() {
        return numeroDeTemporada;
    }

    public void setNumeroDeTemporada(Integer numeroDeTemporada) {
        this.numeroDeTemporada = numeroDeTemporada;
    }

    public void agregarCapitulo(Capitulo unCapitulo) {
        this.capitulos2.add(unCapitulo);
    }

    public boolean vistoCompleto(Usuario unUsuario) {
        return this.capitulos2.stream()
                .allMatch(capitulo -> capitulo.vistoCompleto(unUsuario));
    }

    public Integer cuantosMinutosDuraLatemporadaCompleta() {
        return capitulos2.stream()
                .mapToInt(capitulo -> capitulo.cuantoDura())
                .sum();
    }

    public Capitulo ultimoCapituloDisponible() {
        return capitulos2.get(capitulos2.size()-1);
    }
}
