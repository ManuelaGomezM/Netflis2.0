package adaseptimaback.Netflis2model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CapituloTest {

    private Capitulo capitulo1;
    private Capitulo capitulo2;
    private Temporada temporada1;
    private Temporada temporada2;
    private Serie Sherlock;
    private Serie Lost;
    private Actor BenedictC;
    private Actor EvagelineL;

    @BeforeEach
    void setUp() {

        temporada1 = mock(Temporada.class);
        temporada2 = mock(Temporada.class);
        Sherlock = mock(Serie.class);
        Lost = mock(Serie.class);
        capitulo1 = new Capitulo(1, 45, temporada1, Sherlock);
        capitulo2 = new Capitulo(2, 50, temporada2, Lost);
        BenedictC = mock(Actor.class);
        EvagelineL = mock(Actor.class);
    }

    /**
     * actuo
     **/

    @Test
    void actuoTest() {


        capitulo1.setActoresInvitados(EvagelineL);
        assertTrue(capitulo1.actuo(EvagelineL));

    }

    /**
     * getDuracion
     **/

    @Test
    void cuantoDuraTest() {

        capitulo1.setDuracion(45);
        assertEquals(45, capitulo1.getDuracion().intValue());
    }

    /**generodeCapitulo**/

    @Test

    void generoDeCapitulo (){

        when(Sherlock.getGenero()).thenReturn("miterio");
        capitulo1.setSerie(Sherlock);
        assertEquals("miterio",capitulo1.generoDeSerie());


    }


}
