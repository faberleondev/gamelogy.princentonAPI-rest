package com.gamelogy.princenton.medicos;

import com.gamelogy.princenton.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public MedicoJPA(RegistroMedicoClient registroMedicoClient) {
        this.nombre = registroMedicoClient.nombre();
        this.email = registroMedicoClient.email();
        this.documento = registroMedicoClient.documento();
        this.especialidad = registroMedicoClient.especialidad();
        this.direccion = new Direccion(registroMedicoClient.direccion());
    }
}
