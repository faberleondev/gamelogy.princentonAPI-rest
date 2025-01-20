// ENTIDAD JPA!!!!

package com.gamelogy.princenton.domain.medicos;

import com.gamelogy.princenton.domain.direccion.Direccion;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public @Data class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean activo;
    private String email;
    private String telefono;
    private String matricula;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico() {}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Medico(RegistroMedicoClient registroMedicoClient) {
        this.nombre = registroMedicoClient.nombre();
        this.activo = true;
        this.matricula = registroMedicoClient.matricula();
        this.email = registroMedicoClient.email();
        this.telefono = registroMedicoClient.telefono();
        this.documento = registroMedicoClient.documento();
        this.especialidad = registroMedicoClient.especialidad();
        this.direccion = new Direccion(registroMedicoClient.direccion());
    }

    public void actualizardatos(DatosActualizarMedico datosActualizarMedico) {
        if (datosActualizarMedico.email() != null){
            this.email = datosActualizarMedico.email();
        }
        if (datosActualizarMedico.telefono() != null){
            this.telefono = datosActualizarMedico.telefono();
        }
        if (datosActualizarMedico.direccion() != null){
            this.direccion = direccion.actualizarDireccion(datosActualizarMedico.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
