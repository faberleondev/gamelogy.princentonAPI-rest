// ENTIDAD JPA!!!!

package com.gamelogy.princenton.controller;

import com.gamelogy.princenton.domain.medicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicosRepository medicosRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody @Valid RegistroMedicoClient registroMedicoClient,
                                          UriComponentsBuilder uriComponentsBuilder){
        Medico medico = medicosRepository.save(new Medico(registroMedicoClient));
        DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getMatricula());
        System.out.println("Datos cargados correctamente");
        // RETURN 201 Creado

        // URL donde encontrar al medico
        //        URI urlLocalHostMedicoCreado = URI.create("http://localhost:8080/medicos/" + medicos.getId());
        URI urlMedicoCreado = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(urlMedicoCreado).body(datosRespuestaMedico);

        }

    @GetMapping
    public ResponseEntity<Page<DatosListadoMedico>> listadoMedicos(Pageable paginacion){
        return ResponseEntity.ok(
                medicosRepository.findByActivoTrue(paginacion)
                .map(DatosListadoMedico::new));
//                .map((Medicos nombre) -> new DatosListadoMedico(nombre)).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicosRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizardatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosRespuestaMedico(
                                medico.getId(),
                                medico.getNombre(),
                                medico.getEspecialidad().toString(),
                                medico.getMatricula()));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarMedico(@PathVariable Long id){
        Medico medico = medicosRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }
//      DELETE EN DB
//    public void eliminarMedico(@PathVariable Long id){
//        Medicos medicos = medicosRepository.getReferenceById(id);
//        medicosRepository.delete(medicos);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedico> retornarMedicoEspecifico(@PathVariable Long id){
        Medico medico = medicosRepository.getReferenceById(id);
        var datosMedico = new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getMatricula());
        return ResponseEntity.ok(datosMedico);
    }
}
