package com.gamelogy.princenton.medicos;

public record DatosListadoMedico(
        Long id,
        String nombre,
        String matricula,
        String especialidad,
        String email
) {
    public DatosListadoMedico(Medicos medicos) {
        this(medicos.getId(),medicos.getNombre(), medicos.getMatricula(), medicos.getEspecialidad().toString(), medicos.getEmail());
    }
}
