package com.learning.microservices.VaccinationCenter.Model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

   private Integer id;
   private String name;
   private Integer vaccinationCenterId;
}
