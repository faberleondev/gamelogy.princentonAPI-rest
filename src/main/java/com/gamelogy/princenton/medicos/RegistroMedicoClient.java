package com.gamelogy.princenton.medicos;

import com.gamelogy.princenton.direccion.DireccionMedicosClient;

public record RegistroMedicoClient(String nombre,
                                   String email,
                                   String documento,
                                   Especialidad especialidad,
                                   DireccionMedicosClient direccion) {
}
