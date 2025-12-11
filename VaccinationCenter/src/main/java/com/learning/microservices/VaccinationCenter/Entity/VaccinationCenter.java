package com.learning.microservices.VaccinationCenter.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String centerName;

    @Column
    private String centerAddress;
}
