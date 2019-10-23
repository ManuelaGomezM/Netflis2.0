package adaseptimaback.Netflis2model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class UsuarioTest {

    private Serie Sherlock;
    private Serie Lost;
    private Pelicula CodigoEnigma;
    private Actor BenedictC ;
    private Actor MatthewFox;
    private Temporada temporada1;
    private Temporada temporada2;
    private Capitulo capitulo1;
    private Capitulo capitulo2;
    private Capitulo capitulo3;
    private Usuario Vicky;
    private Usuario Anita;

    @BeforeEach
    void setUp(){
        capitulo1=mock(Capitulo.class);
        capitulo2=mock(Capitulo.class);
        temporada1=mock(Temporada.class);
        temporada2=mock(Temporada.class);
        Sherlock=mock(Serie.class);
        Lost=mock(Serie.class);
        CodigoEnigma=mock(Pelicula.class);
        BenedictC=mock(Actor.class);
        MatthewFox=mock(Actor.class);
        Anita=new Usuario();
        Vicky= new Usuario ();

    }

    /**yaLoVisteTest**/

    @Test

    void yaLoVisteTest (){
    }

    /**visteCompletoEstoTest**/

    @Test

    void visteCompletoEstoTest (){
        when(Sherlock.vistoCompleto(Anita)).thenReturn(true);
        assertTrue(Anita.visteCompletoEsto(Sherlock));
    }

    /**unidadesDeContenidoTest**/

    @Test

    void unidadesDeContenidoTest(){
        Vicky.yaLoViste(Sherlock);
        Vicky.yaLoViste(Lost);
        Vicky.yaLoViste(CodigoEnigma);
        assertEquals(3,Vicky.cuantasUnidadesDeContenidoViste().intValue());

    }

    /**generosVistosPorUsuarioTest**/

    @Test

    void generosVistosPorUsuarioTest (){

        when(Sherlock.getGenero()).thenReturn("policial");
        when(CodigoEnigma.getGenero()).thenReturn("suspenso");
        Vicky.yaLoViste(Sherlock);
        Vicky.yaLoViste(CodigoEnigma);
        assertEquals(Arrays.asList("policial","suspenso"),Vicky.generosVistosPorUsuario());
    }


    /**contenidosPorGeneroTest**/

    @Test

    void contenidosPorGenerosTest (){

        when(Sherlock.getGenero()).thenReturn("policial");
        when(CodigoEnigma.getGenero()).thenReturn("policial");
        Vicky.yaLoViste(Sherlock);
        Vicky.yaLoViste(CodigoEnigma);
        assertEquals(Arrays.asList(Sherlock, CodigoEnigma),Vicky.contenidosPorGenero("policial"));


    }

    /**minutosVistosPorGenero**/

    @Test

    void minutosVistosPorGeneroTest (){

        when(Sherlock.getDuracion()).thenReturn(50);
        when(CodigoEnigma.getDuracion()).thenReturn(20);
        when(Sherlock.getGenero()).thenReturn("policial");
        when(CodigoEnigma.getGenero()).thenReturn("policial");
        Anita.yaLoViste(Sherlock);
        Anita.yaLoViste(CodigoEnigma);
        assertEquals(70,Anita.minutosVistosporGenero("policial").intValue());
    }

    /**generoPreferidoTest**/

    @Test

    void generoPreferidoTest (){
        when(Sherlock.getDuracion()).thenReturn(50);
        when(CodigoEnigma.getDuracion()).thenReturn(20);
        when(Sherlock.getGenero()).thenReturn("policial");
        when(CodigoEnigma.getGenero()).thenReturn("suspenso");
        Anita.yaLoViste(Sherlock);
        Anita.yaLoViste(CodigoEnigma);
        assertEquals("policial", Anita.generoPreferido());


    }

    /**esFanDeTest**/

    @Test

    void esFanDeTest (){

    }




}
