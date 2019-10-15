package adaseptimaback.Netflis2model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario implements Serializable {
    private Integer id;
    private List<Contenido> contenidosVistosPorUsuario = new ArrayList<>();

    public void yaLoViste(Contenido unContenido) {
        this.getContenidosVistosPorUsuario().add(unContenido);
    }

    public Boolean visteCompletoEsto(Contenido unContenido) {
        return unContenido.vistoCompleto(this);
    }

    public Integer cuantasUnidadesDeContenidoViste() {
        return this.getContenidosVistosPorUsuario().size();
    }

    public Boolean contenidoFueVisto(Contenido unContenido) {
        return this.getContenidosVistosPorUsuario().contains(unContenido);
    }

    //se pide una coleccion sin repetir de strings que son los generos
    // ( previo map(=transformacion) por ser atributos del contenido)


    public List<String> generosVistosPorUsuario() {
        return getContenidosVistosPorUsuario().stream()
                .map(contenido -> contenido.getGenero())
                .distinct()
                .collect(Collectors.toList());
    }

    public List <Contenido> contenidosPorGenero(String ungenero) {
        return getContenidosVistosPorUsuario().stream()
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
        return getContenidosVistosPorUsuario().stream().allMatch(c-> c.actuo(actor));
    }

    public List<Contenido> contenidosIncompletos(){
        return this.getContenidosVistosPorUsuario().stream()
                .filter(contenido -> !contenido.vistoCompleto(this))
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public List<Contenido> getContenidosVistosPorUsuario() {
        return contenidosVistosPorUsuario;
    }

    public void setContenidosVistosPorUsuario(List<Contenido> contenidosVistosPorUsuario) {
        this.contenidosVistosPorUsuario = contenidosVistosPorUsuario;
    }
}
