package adaseptimaback.Netflis2model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ActorTest {

    private Contenido Inception ;
    private Contenido Endgame ;
    private Actor RobertDowneyJr;

    @BeforeEach
    void setUp() {
        Endgame = mock (Pelicula.class);
        Inception= mock (Pelicula.class);
        RobertDowneyJr= new Actor("Robert Downey Jr");
    }

    /**actuo en**/

    @Test
        void actuoEn (){
        when(Endgame.actuo(RobertDowneyJr)).thenReturn(true);
        assertTrue(RobertDowneyJr.actuoEn(Endgame));
    }

    @Test

    void actuoEnFalse (){
        when(Inception.actuo(RobertDowneyJr)).thenReturn(false);
        assertFalse(RobertDowneyJr.actuoEn(Inception));
    }








}
