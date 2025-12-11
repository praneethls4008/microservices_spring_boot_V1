package com.learning.microservices.VaccinationCenter.repository;

import com.learning.microservices.VaccinationCenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {
}
