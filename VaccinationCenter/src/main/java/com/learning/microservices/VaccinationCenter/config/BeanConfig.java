package com.learning.microservices.VaccinationCenter.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {


    @Bean
    @LoadBalanced // for translating service names into dns
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
