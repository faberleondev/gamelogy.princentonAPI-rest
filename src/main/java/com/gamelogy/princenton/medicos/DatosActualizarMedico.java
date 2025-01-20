package com.gamelogy.princenton.medicos;

import com.gamelogy.princenton.direccion.Direccion;
import com.gamelogy.princenton.direccion.DireccionMedicosClient;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String email,
        String telefono,
        DireccionMedicosClient direccion
        ) {

}
