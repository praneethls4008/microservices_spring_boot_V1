package com.learning.microservices.VaccinationCenter.service;

import com.learning.microservices.VaccinationCenter.Model.Citizen;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenClientService {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name="GetCitizensFallBack", fallbackMethod="fallback")
    public List<Citizen> getCitizens(Integer centerId) {
        return restTemplate.getForObject(
                "http://CITIZEN-SERVICE/citizen/id/" + centerId,
                List.class
        );
    }

    public List<Citizen> fallback(Integer centerId, Throwable t) {
        System.out.println("Fallback activated: " + t.getMessage());
        return Collections.emptyList();
    }
}
