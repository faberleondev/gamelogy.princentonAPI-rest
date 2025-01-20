package com.gamelogy.princenton.domain.medicos;

import com.gamelogy.princenton.domain.direccion.DireccionMedicosClient;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String email,
        String telefono,
        DireccionMedicosClient direccion
        ) {

}
