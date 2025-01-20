package com.gamelogy.princenton.direccion;

import jakarta.validation.constraints.NotBlank;

public record DireccionMedicosClient(@NotBlank
                                     String calle,
                                     @NotBlank
                                     String numero,
                                     @NotBlank
                                     String dpto,
                                     @NotBlank
                                     String barrio,
                                     @NotBlank
                                     String ciudad) {
}
