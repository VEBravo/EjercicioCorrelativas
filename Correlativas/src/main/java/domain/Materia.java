package domain;

import java.util.List;

public class Materia {
    private String idMateria;
    private List<Materia> materias;

    public Materia(String idMateria, List<Materia> materias) {
        this.idMateria = idMateria;
        this.materias = materias;
    }

    public Boolean cumpleCorrelativas(Alumno alumno) {
        return (this.materias
                .stream()
                .allMatch(alumno::aprobada)
                && !alumno.aprobada(this));
    }
}
