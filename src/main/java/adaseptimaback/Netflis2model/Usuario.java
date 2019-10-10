package adaseptimaback.Netflis2model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
    private List<Contenido> contenidosVistosPorUsuario = new ArrayList<>();


    public void yaLoViste(Contenido unContenido) {
        this.contenidosVistosPorUsuario.add(unContenido);

    }

    public Boolean visteCompletoEsto(Contenido unContenido) {
        return unContenido.vistoCompleto(this);
    }


    public Integer cuantasUnidadesDeContenidoViste() {
        return this.contenidosVistosPorUsuario.size();
    }

    public Boolean contenidoFueVisto(Contenido unContenido) {
        return this.contenidosVistosPorUsuario.contains(unContenido);
    }

    //se pide una coleccion sin repetir de strings que son los generos
    // ( previo map(=transformacion) por ser atributos del contenido)


    public List<String> generosVistosPorUsuario() {
        return contenidosVistosPorUsuario.stream()
                .map(contenido -> contenido.getGenero())
                .distinct()
                .collect(Collectors.toList());
    }

    public List <Contenido> contenidosPorGenero(String ungenero) {
        return contenidosVistosPorUsuario.stream()
                .filter(c -> c.getGenero().equals(ungenero))
                .collect(Collectors.toList());

    }

    public Integer minutosVistosporGenero(String unGenero) {
        return this.contenidosPorGenero(unGenero).stream()
                .mapToInt(contenido -> contenido.cuantoDura())
                .sum();
    }


    public String generoPreferido() {
        return this.generosVistosPorUsuario().stream()
                .max(Comparator.comparing(genero -> this.minutosVistosporGenero(genero)))
                .get();
    }

    public Boolean esFanDe(Actor actor) {
        return contenidosVistosPorUsuario.stream().allMatch(c-> c.actuo(actor));
    }
}
