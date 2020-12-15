package com.scotia.challenge.car.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model", length = 256)
    @NonNull
    private String model;

    @Column(name = "year")
    @NonNull
    private Integer year;
}
