package com.learning.microservices.VaccinationCenter.Controller;

import com.learning.microservices.VaccinationCenter.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    @PostMapping("/publish")
    public String send(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka topic!";
    }
}