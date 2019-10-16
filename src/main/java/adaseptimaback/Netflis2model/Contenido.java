package adaseptimaback.Netflis2model;

public interface Contenido {

    boolean vistoCompleto(Usuario unUsuario);

    String getGenero();

    Integer cuantoDura();

    Boolean actuo(Actor actor);

}
