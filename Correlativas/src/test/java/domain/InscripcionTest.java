package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    // Materias
    Materia algoritmos = new Materia("Algoritmos", Collections.emptyList());
    Materia paradigmas = new Materia("Paradigmas", Arrays.asList(algoritmos));
    Materia diseno = new Materia("Diseño de Sistemas", Arrays.asList(paradigmas));
    Materia analisis1 = new Materia("Análisis 1", Collections.emptyList());
    Materia algebra = new Materia("Álgebra", Collections.emptyList());
    Materia analisis2 = new Materia("Análisis 2", Arrays.asList(analisis1, algebra));
    Materia fisica1 = new Materia("Física 1", Collections.emptyList());
    Materia fisica2 = new Materia("Física 2", Arrays.asList(fisica1));
    Materia ingSociedad = new Materia("Ingeniería y Sociedad", Collections.emptyList());

    // Alumnos
    Alumno alumno = new Alumno("12345", Arrays.asList(algoritmos, analisis1), Collections.emptyList());

    // Inscripciones
    Inscripcion inscripcion1 = new Inscripcion("001", alumno, Arrays.asList()); // Rechazada
    Inscripcion inscripcion2 = new Inscripcion("002", alumno, Arrays.asList(diseno,analisis2)); // Rechazada
    Inscripcion inscripcion3 = new Inscripcion("003", alumno, Arrays.asList(ingSociedad, diseno)); // Rechazada
    Inscripcion inscripcion4 = new Inscripcion("004", alumno, Arrays.asList(ingSociedad, paradigmas)); // Aceptada
    Inscripcion inscripcion5 = new Inscripcion("005", alumno, Arrays.asList(analisis1)); // Rechazada
    Inscripcion inscripcion6 = new Inscripcion("006", alumno, Arrays.asList(algebra)); // Rechazada

    @Test
    public void testDesaprobadaVacia() {
        Assertions.assertFalse(inscripcion1.aprobada());
    }

    @Test
    public void testDesaprobadaPorTodas() { // No cumple con ninguna correlativa
        Assertions.assertFalse(inscripcion2.aprobada());
    }

    @Test
    public void testDesaprobadaPorUna() { // No cumple con correlativas de diseno
        Assertions.assertFalse(inscripcion3.aprobada());
    }

    @Test
    public void testAprobada() { // Cumple con correlativas de ingenieria y sociedad y paradigmas
        Assertions.assertTrue(inscripcion4.aprobada());
    }

    @Test
    public void testMateriaYaCursada() { // Un alumno no puede anotarse a una materia que ya curso
        Assertions.assertFalse(inscripcion5.aprobada());
    }

    @Test
    public void testAprobadaSinCorrelativas() { // Un alumno puede anotarse a una materia sin correlativas
        Assertions.assertTrue(inscripcion6.aprobada());
    }

}