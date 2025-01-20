package com.gamelogy.princenton.domain.medicos;

import com.gamelogy.princenton.domain.direccion.DireccionMedicosClient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegistroMedicoClient(@NotBlank(message = "{nombre.obligatorio}")
                                   String nombre,
                                   @NotBlank(message = "{email.obligatorio}")
                                   @Email(message = "{email.invalido}")
                                   String email,
                                   @NotBlank(message = "{telefono.obligatorio}")
                                   @Pattern(regexp = "\\d{8,20}")
                                   String telefono,
                                   @NotBlank(message = "La matrícula es obligatorio")
                                   @Pattern(regexp = "\\d{4,8}")
                                   String matricula,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{6,10}")
                                   String documento,
                                   @NotNull(message = "{especialidad.obligatorio}")
                                   Especialidad especialidad,
                                   @NotNull(message = "{direccion.obligatorio}")
                                   @Valid
                                   DireccionMedicosClient direccion) {

}
