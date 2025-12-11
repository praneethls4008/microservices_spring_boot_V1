package com.learning.microservices.CitizenService.Controller;

import com.learning.microservices.CitizenService.Entity.Citizen;
import com.learning.microservices.CitizenService.service.CitizenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping("/get")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> getByVaccinationCenterId(@PathVariable Integer id){
        return new ResponseEntity<>(citizenService.getAllCitizensByVaccinationId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> saveNewCitizen(@RequestBody Citizen newCitizen){
        return new ResponseEntity<>(citizenService.saveNewCitizen(newCitizen), HttpStatus.OK);
    }


}
