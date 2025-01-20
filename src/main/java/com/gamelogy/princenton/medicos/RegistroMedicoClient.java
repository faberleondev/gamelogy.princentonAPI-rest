package com.gamelogy.princenton.medicos;

import com.gamelogy.princenton.direccion.DireccionMedicosClient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegistroMedicoClient(@NotBlank
                                   String nombre,
                                   @NotBlank
                                   @Email
                                   String email,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{8,20}")
                                   String telefono,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{4,8}")
                                   String matricula,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{6,10}")
                                   String documento,
                                   @NotNull
                                   Especialidad especialidad,
                                   @NotNull @Valid
                                   DireccionMedicosClient direccion) {

}
