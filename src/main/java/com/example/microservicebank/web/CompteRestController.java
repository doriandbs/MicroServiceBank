package com.example.microservicebank.web;

import com.example.microservicebank.dtos.VirementRequestDTO;
import com.example.microservicebank.repositories.CompteRepository;
import com.example.microservicebank.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank")
public class CompteRestController {
    @Autowired
    private CompteService compteService;

    @PutMapping(path ="/comptes/virement")
    public void virement(@RequestBody VirementRequestDTO request){
        compteService.virement(request.getIdSource(), request.getIdDestination(), request.getMontant());
    }
}
