package com.example.microservicebank.dtos;

import lombok.Data;

@Data
public class VirementRequestDTO {
    private Long idSource;
    private Long idDestination;
    private Double montant;
}
