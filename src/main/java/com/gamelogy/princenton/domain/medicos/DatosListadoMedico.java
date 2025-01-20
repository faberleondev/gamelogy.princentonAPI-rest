package com.gamelogy.princenton.domain.medicos;

public record DatosListadoMedico(
        Long id,
        String nombre,
        String matricula,
        String especialidad,
        String email
) {
    public DatosListadoMedico(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getMatricula(), medico.getEspecialidad().toString(), medico.getEmail());
    }
}
