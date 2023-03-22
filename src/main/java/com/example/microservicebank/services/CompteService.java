package com.example.microservicebank.services;



public interface CompteService {
    void virement(Long idCompteSource, Long idCompteDestination, double montant);
}
