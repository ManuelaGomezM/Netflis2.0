package adaseptimaback.Netflis2;

public interface Contenido {
    boolean vistoCompleto(Usuario unUsuario);

    String getGenero();

    Integer cuantoDura();

    Boolean actuo(Actor actor);

}
