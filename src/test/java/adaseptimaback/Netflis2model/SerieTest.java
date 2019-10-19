package adaseptimaback.Netflis2model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SerieTest {

    private Serie Sherlock;
    private Serie Lost;
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

    void setUp (){

        capitulo1=mock(Capitulo.class);
        capitulo2=mock(Capitulo.class);
        temporada1=mock (Temporada.class);
        temporada2 = mock(Temporada.class);
        Sherlock= new Serie("Sherlock","policial");
        Lost = new Serie("Lost","misterio");
        MatthewFox=mock(Actor.class);
        BenedictC=mock(Actor.class);
        Vicky= mock(Usuario.class);
        Anita=mock(Usuario.class);
    }

    /**actuo**/

    @Test

    void actuo(){

        Sherlock.setActoresFijosDeLaSerie(BenedictC);
        assertTrue(Sherlock.actuo(BenedictC));
    }

    /**cuantasTemporadasTenes**/

    @Test

     void cuantasTemporadasTenes(){

        Sherlock.agregarTemporada(temporada1);
        Sherlock.agregarTemporada(temporada2);
        assertEquals(2,Sherlock.cuantasTemporadasTenes().intValue());

    }
    /**vistoCompleto**/

    @Test
     void vistoCompleto (){
        Sherlock.agregarTemporada(temporada1);
        Sherlock.agregarTemporada(temporada2);
        when(temporada1.vistoCompleto(Anita)).thenReturn(true);
        when(temporada2.vistoCompleto(Anita)).thenReturn(true);
        assertTrue(Sherlock.vistoCompleto(Anita));
    }

    /**getDuracion**/

    @Test

    void cuantoDuraTest(){

        Lost.agregarTemporada(temporada2);
        Lost.agregarTemporada(temporada1);
        when(temporada1.cuantosMinutosDuraLatemporadaCompleta().intValue()).thenReturn(45);
        when(temporada2.cuantosMinutosDuraLatemporadaCompleta().intValue()).thenReturn(50);
        assertEquals(95,Lost.getDuracion().intValue());

    }







}
