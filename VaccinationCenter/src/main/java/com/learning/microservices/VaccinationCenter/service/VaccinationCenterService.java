package com.learning.microservices.VaccinationCenter.service;

import com.learning.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.learning.microservices.VaccinationCenter.Model.Citizen;
import com.learning.microservices.VaccinationCenter.Model.VaccinationCenterResponse;
import com.learning.microservices.VaccinationCenter.repository.VaccinationCenterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class VaccinationCenterService {

    private final CitizenClientService citizenClientService;
    private final VaccinationCenterRepo vaccinationCenterRepo;

    public VaccinationCenterResponse getVaccinationCenterData(Integer id) {

        Optional<VaccinationCenter> optionalCenter = vaccinationCenterRepo.findById(id);
        if (optionalCenter.isEmpty()) {
            return new VaccinationCenterResponse(null, Collections.emptyList());
        }
        VaccinationCenter center = optionalCenter.get();

        List<Citizen> citizenList = citizenClientService.getCitizens(center.getId());

        return new VaccinationCenterResponse(center, citizenList);
    }


    public VaccinationCenter saveNewVaccinationCenter(VaccinationCenter newVaccinationCenter) {
        return vaccinationCenterRepo.save(newVaccinationCenter);
    }

}
