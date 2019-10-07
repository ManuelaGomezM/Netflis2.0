package adaseptimaback.Netflis2;

public class UnidadDeContenido implements Contenido {
    public String genero;


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
}
