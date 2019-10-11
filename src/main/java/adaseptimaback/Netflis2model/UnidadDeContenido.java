package adaseptimaback.Netflis2model;

public class UnidadDeContenido implements Contenido {
    public String genero;
    private String titulo;

    public UnidadDeContenido(){

    }


    public boolean vistoCompleto(Usuario unUsuario) {
        return unUsuario.contenidoFueVisto(this);

    }
    private Integer duracion;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer cuantoDura() {
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
}
