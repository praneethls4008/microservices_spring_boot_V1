package com.learning.microservices.CitizenService.service;

import com.learning.microservices.CitizenService.CitizenServiceApplication;
import com.learning.microservices.CitizenService.Entity.Citizen;
import com.learning.microservices.CitizenService.repository.CitizenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenService {

    private final CitizenRepo citizenRepo;

    public List<Citizen> getAllCitizensByVaccinationId(Integer id){
        return citizenRepo.findByVaccinationCenterId(id);
    }

    public Citizen saveNewCitizen(Citizen newCitizen) {
        return citizenRepo.save(newCitizen);
    }
}
