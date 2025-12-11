package com.learning.microservices.VaccinationCenter.Controller;

import com.learning.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.learning.microservices.VaccinationCenter.Model.VaccinationCenterResponse;
import com.learning.microservices.VaccinationCenter.service.VaccinationCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vaccination-center")
@RequiredArgsConstructor
public class VaccinationCenterController {

    private final VaccinationCenterService vaccinationCenterService;

    @GetMapping("/id/{id}")
    public ResponseEntity<VaccinationCenterResponse> getByVaccinationCenterData(@PathVariable Integer id){
         return new ResponseEntity<>(vaccinationCenterService.getVaccinationCenterData(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> saveNewCitizen(@RequestBody VaccinationCenter newVaccinationCenter){
        return new ResponseEntity<>(vaccinationCenterService.saveNewVaccinationCenter(newVaccinationCenter), HttpStatus.OK);
    }


}
