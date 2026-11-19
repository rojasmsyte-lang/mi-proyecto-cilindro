package org.ejemplos.proyectojavafx2;

import javafx.css.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.discovery.SelectorResolver;

import static org.junit.jupiter.api.Assertions.*;

class CilindroTest {

     private static final double DELTA = 0.0001;
     private Cilindro cil;

    @BeforeEach
    void setUp() {
        cil = new Cilindro(1.5,2.5);
    }

    @Test
    void setRadio() {
        cil.setRadio(2);
        assertEquals(2,cil.getRadio(), DELTA);
        assertEquals(2 * Math.PI * 1.5 * (1.5 + 2.5), cil.getArea(), DELTA);
        assertEquals(Math.PI * 1.5 * 1.5 * 2.5, cil.getVolumen(), DELTA);
    }

    @Test
    void getRadio() {
        assertEquals(1.5, cil.getRadio(), DELTA);
    }

    @Test
    void setAltura() {
        cil.setAltura(2.5);
        assertEquals(2.5, cil.getAltura(), DELTA);
        assertEquals(2 * Math.PI * 1.5 * (1.5 + 2.5), cil.getArea(), DELTA);
        assertEquals(Math.PI * 1.5 * 1.5 * 2.5 , cil.getVolumen(), DELTA);
    }

    @Test
    void getAltura() {
        assertEquals(2.5, cil.getAltura(), DELTA);
    }

    @Test
    void calcularArea() {
        assertEquals(37.6991, cil.calcularArea(), DELTA);
    }

    @Test
    void calcularVolumen() {
        assertEquals(17.6714, cil.calcularVolumen(), DELTA);
    }

    @Test
    void getArea() {
        assertEquals(2 * Math.PI* 1.5 * (1.5 + 2.5), cil.getArea(), DELTA);
    }

    @Test
    void getVolumen() {
        assertEquals(Math.PI * Math.pow(1.5,2)* 2.5, cil.getVolumen(), DELTA);
    }
}