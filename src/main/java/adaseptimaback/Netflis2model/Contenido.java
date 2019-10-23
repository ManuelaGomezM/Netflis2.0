package adaseptimaback.Netflis2model;


import java.io.Serializable;
import java.util.List;

public interface Contenido extends Serializable {
    Long getId();
    boolean vistoCompleto(Usuario unUsuario);

    String getTitulo();

    String getGenero();

    Integer getDuracion();

    Boolean actuo(Actor actor);

    List<String> nombresDeActores();


}
