package com.example.h2test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2testApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(H2testApplication.class, args);
    }

    @Autowired
    private TrainingUnitRepository trainingUnitRepository;

    @Override
    public void run(String... args) throws Exception {

        TrainingUnit unit1 = new TrainingUnit("2022-01-12", 7, "benchpress", 80);
        TrainingUnit unit2 = new TrainingUnit("2022-01-12", 8, "squats", 100);
        TrainingUnit unit3 = new TrainingUnit("2022-01-13", 13, "curls", 25);

        trainingUnitRepository.save(unit1);
        trainingUnitRepository.save(unit2);
        trainingUnitRepository.save(unit3);
    }

}
