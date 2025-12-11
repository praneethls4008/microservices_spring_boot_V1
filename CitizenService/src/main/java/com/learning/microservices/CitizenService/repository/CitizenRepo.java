package com.learning.microservices.CitizenService.repository;

import com.learning.microservices.CitizenService.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
    public List<Citizen> findByVaccinationCenterId(Integer id);
}
