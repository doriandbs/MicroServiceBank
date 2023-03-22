package com.example.microservicebank;

import com.example.microservicebank.entities.Compte;
import com.example.microservicebank.enums.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.microservicebank.repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class MicroServiceBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceBankApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepo){
        return args -> {
            compteRepo.save(new Compte(null,50000, new Date(), TypeCompte.CHEQUE));
            compteRepo.save(new Compte(null,1000, new Date(), TypeCompte.COURANT));
            compteRepo.save(new Compte(null,50, new Date(), TypeCompte.PEL));
            compteRepo.findAll().forEach(compte -> {
                System.out.println("ID :" + compte.getId() +
                        "SOLDE : " +compte.getSolde());
            });
        };
    }
}
