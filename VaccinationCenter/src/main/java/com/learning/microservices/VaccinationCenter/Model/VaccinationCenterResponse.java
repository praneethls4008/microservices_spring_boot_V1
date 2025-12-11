package com.learning.microservices.VaccinationCenter.Model;

import com.learning.microservices.VaccinationCenter.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenterResponse {
    private VaccinationCenter center;
    private List<Citizen> citizen;
}
