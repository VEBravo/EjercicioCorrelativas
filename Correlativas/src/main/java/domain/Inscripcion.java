package domain;

import java.util.List;

public class Inscripcion {
    private String idInscripcion;
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(String idInscripcion, Alumno alumno, List<Materia> materias) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materias = materias;
    }

    public Boolean aprobada() {
        if(this.materias.isEmpty()) {return false;}
        else {
            return this.materias
                    .stream()
                    .allMatch(m -> m.cumpleCorrelativas(alumno));
        }
    }
}
