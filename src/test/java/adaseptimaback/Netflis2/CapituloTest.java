package adaseptimaback.Netflis2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CapituloTest {

    private Capitulo capitulo1 ;
    private Capitulo capitulo2;
    private Temporada temporada1;
    private Temporada temporada2;
    private Serie Sherlock;
    private Serie Lost;
    private Actor BenedictC;
    private Actor EvagelineL;

    @BeforeEach

    void setUp (){

        capitulo1 = new Capitulo (1,45,temporada1);
        capitulo2 = new Capitulo(2,50,temporada2);
        temporada1 = mock(Temporada.class);
        temporada2= mock (Temporada.class);
        Sherlock = mock (Serie.class);
        Lost = mock(Serie.class);
        BenedictC= mock(Actor.class);
        EvagelineL = mock(Actor.class);
    }

    /**actuo**/

    @Test

    void actuoTest (){

     capitulo1.setActoresInvitados(EvagelineL);
     assertTrue(capitulo1.actuo(EvagelineL));

    }

    /**cuantoDura**/

    @Test

    void cuantoDuraTest (){

        capitulo1.setDuracionDeCapitulo(45);
        assertEquals(45,capitulo1.cuantoDura().intValue());
    }





}
