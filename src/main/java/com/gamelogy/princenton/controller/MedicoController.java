package com.gamelogy.princenton.controller;

import com.gamelogy.princenton.medicos.MedicosRepository;
import com.gamelogy.princenton.medicos.RegistroMedicoClient;
import com.gamelogy.princenton.medicos.MedicoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicosRepository medicosRepository;
    @PostMapping
    public void registrarMedico(@RequestBody RegistroMedicoClient registroMedicoClient){
        medicosRepository.save(new MedicoJPA(registroMedicoClient));
        }
}
