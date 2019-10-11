package adaseptimaback.Netflis2model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TemporadaTest {

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

    void setUp(){

        Sherlock=mock(Serie.class);
        Lost=mock(Serie.class);
        capitulo2=mock(Capitulo.class);
        capitulo1=mock(Capitulo.class);
        capitulo3=mock(Capitulo.class);
        Vicky=mock(Usuario.class);
        Anita=mock(Usuario.class);
        BenedictC=mock(Actor.class);
        MatthewFox=mock(Actor.class);
        temporada1=new Temporada();
        temporada2= new Temporada();

    }

    /**cantidadDeCapitulosTest**/
    /**aca tambien testeamos el agregarCapitulo**/

    @Test

    void cantidadDeCapTest(){
        temporada1.agregarCapitulo(capitulo1);
        temporada1.agregarCapitulo(capitulo2);
        assertEquals(2,temporada1.cantidadDeCapitulosEnTemporada().intValue());

    }

    /**vistoCompleto**/

    @Test

    void vistoCompletoTest (){

        //tambien testeamos el agregar capitulo//

        temporada1.agregarCapitulo(capitulo1);
        temporada1.agregarCapitulo(capitulo2);
        when(capitulo1.vistoCompleto(Anita)).thenReturn(true);
        when(capitulo2.vistoCompleto(Anita)).thenReturn(true);
        assertTrue(temporada1.vistoCompleto(Anita));


    }

    /**cuantosMinutosTest**/

    @Test

    void cuantosMinutosTest(){

        temporada1.agregarCapitulo(capitulo1);
        temporada1.agregarCapitulo(capitulo2);
        when(capitulo1.cuantoDura()).thenReturn(30);
        when(capitulo2.cuantoDura()).thenReturn(50);
        assertEquals(80,temporada1.cuantosMinutosDuraLatemporadaCompleta().intValue());


    }

    /**ultimoCapDisponibleTest**/

    @Test

    void ultimoCapDisponibleTest (){
        temporada1.agregarCapitulo(capitulo1);
        temporada1.agregarCapitulo(capitulo2);
        temporada1.agregarCapitulo(capitulo3);
        assertEquals(capitulo3,temporada1.ultimoCapituloDisponible());



    }


}
