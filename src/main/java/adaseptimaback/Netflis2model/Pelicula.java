package adaseptimaback.Netflis2model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Pelicula extends UnidadDeContenido {
    @Id
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name= "incrementator",strategy = "increment")
    @Column(name = "ID", unique = true, nullable = false)
    private List<Actor> actoresDePeliculas = new ArrayList<>();

    public Pelicula(){}

    public Pelicula(String titulo,String genero,Integer duracionDePelicula){
        super.setGenero(genero);
        this.setTitulo(titulo);
        super.setDuracion(duracionDePelicula);
    }
    public void setActoresDePeliculas(Actor unActortrizDePelicula) {
        this.actoresDePeliculas.add(unActortrizDePelicula);

    }

    public List<String> nombresDeActores(){
        return this.actoresDePeliculas.stream()
                .map(actor -> actor.getName())
                .collect(Collectors.toList());
    }


//prueba numero mil para dar por vista una pelicula.
// se entiende que una peli esta vista cuando esta agregada a la coleccion del usuario
    // ese metodo se hizo en el usuario pero esta mal. aplicaria misma solucion a capitulo


    public Boolean actuo(Actor actor){

        return actoresDePeliculas.contains(actor);
    }
}
