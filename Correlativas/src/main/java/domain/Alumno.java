package domain;

import java.util.List;

public class Alumno {
    private String legajo;
    private List<Materia> materiasAprobadas;
    private List<Inscripcion> inscripciones;

    public Alumno(String legajo, List<Materia> materias, List<Inscripcion> inscripciones) {
        this.legajo = legajo;
        this.materiasAprobadas = materias;
        this.inscripciones = inscripciones;
    }

    public Boolean aprobada(Materia materia) {
        return materiasAprobadas.contains(materia);
    }
}