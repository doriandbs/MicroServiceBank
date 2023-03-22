package com.example.microservicebank.services;

import com.example.microservicebank.entities.Compte;
import com.example.microservicebank.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public void virement(Long idCompteSource, Long idCompteDestination, double montant) {
        Compte compteSource=  compteRepository.findById(idCompteSource).orElse(null);
        Compte compteDestination =  compteRepository.findById(idCompteDestination).orElse(null);

        if(compteSource!=null && compteDestination!= null){
            compteSource.setSolde(compteSource.getSolde() - montant);
            compteDestination.setSolde(compteDestination.getSolde() + montant);
        }
    }
}
