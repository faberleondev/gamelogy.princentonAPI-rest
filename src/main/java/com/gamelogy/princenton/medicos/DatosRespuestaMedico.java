package com.gamelogy.princenton.medicos;

import com.gamelogy.princenton.direccion.DireccionMedicosClient;

public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String especialidad,
        String matricula
        ) {}
