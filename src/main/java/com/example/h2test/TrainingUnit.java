package com.example.h2test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "trainingUnits")
public class TrainingUnit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String date;
    private int duration;
    private String trainedMuscles;
    private int weight;

    public TrainingUnit(String date, int duration, String trainedMuscles, int weight) {
        this.date = date;
        this.duration = duration;
        this.trainedMuscles = trainedMuscles;
        this.weight = weight;
    }
}

