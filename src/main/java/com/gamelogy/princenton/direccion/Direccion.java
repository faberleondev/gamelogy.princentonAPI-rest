package com.gamelogy.princenton.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String numero;
    private String dpto;
    private String barrio;
    private String ciudad;

    public Direccion(DireccionMedicosClient direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.dpto = direccion.dpto();
        this.barrio = direccion.barrio();
        this.ciudad = direccion.ciudad();

    }
}
