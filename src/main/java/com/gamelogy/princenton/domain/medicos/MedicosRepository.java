package com.gamelogy.princenton.domain.medicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<Medicos, Long> {
    Page<Medicos> findByActivoTrue(Pageable paginacion);
}
