package adaseptimaback.Netflis2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PeliculaTest {

    private Pelicula Inception;
    private Actor LeonardoDiCaprio;
    private Pelicula Titanic;
    private Actor KateWinslet;
    private Usuario Vicky;
    private Usuario Anita;


    @BeforeEach

    void setUp (){

        Inception = new Pelicula("suspenso","Inception",140);
        Titanic = new Pelicula ("drama","Titanic",160);
        LeonardoDiCaprio= mock (Actor.class);
        KateWinslet = mock(Actor.class);
        Vicky = mock(Usuario.class);
        Anita = mock (Usuario.class);
    }

    /**actuo**/

    @Test

    void actuoEn(){

        Titanic.setActoresDePeliculas(KateWinslet);
        assertTrue(Titanic.actuo(KateWinslet));
    }

    /**cuantoduraTest**/

    @Test

    void cuantoDuraTest (){
        Titanic.setDuracionDePelicula(160);
        assertEquals(160,Titanic.cuantoDura().intValue());
    }

    /**vistoCompleto**/

    @Test

    void vistoCompletoTest(){


        when(Vicky.().contains(Titanic)).thenReturn(true);
        //when(Vicky.contenidoFueVisto(Titanic)).thenReturn(true);//
        assertTrue(Titanic.vistoCompleto(Vicky));
    }









}
