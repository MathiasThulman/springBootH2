package com.example.h2test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TrainingUnitController {

    @Autowired
    private TrainingUnitRepository trainingUnitRepository;

    @GetMapping("/trainingUnits")
    public List<TrainingUnit> fetchEntries() {
        return trainingUnitRepository.findAll();
    }

    @PutMapping("/trainingUnits/{trainingUnitID}")
    public void putEntry(@PathVariable("trainingUnitID") long trainingUnitID, @RequestBody TrainingUnit updatedTrainingUnit) {

       this.trainingUnitRepository.findById(trainingUnitID)
               .map(trainingUnit -> {
                   trainingUnit.setDate(updatedTrainingUnit.getDate());
                   trainingUnit.setDuration(updatedTrainingUnit.getDuration());
                   trainingUnit.setTrainedMuscles(updatedTrainingUnit.getTrainedMuscles());
                   trainingUnit.setWeight(updatedTrainingUnit.getWeight());

                   return this.trainingUnitRepository.save(trainingUnit);
               });

    }

    @PostMapping("/trainingUnits")
    public void postEntry(@RequestBody TrainingUnit addedTrainingUnit) {
        TrainingUnit trainingUnit = new TrainingUnit(addedTrainingUnit.getDate(), addedTrainingUnit.getDuration(),
                addedTrainingUnit.getTrainedMuscles(), addedTrainingUnit.getWeight());

        this.trainingUnitRepository.save(trainingUnit);
    }

    @DeleteMapping("/trainingUnits")
    public void deleteAllTrainingUnits() {
        trainingUnitRepository.deleteAll();
    }

    @DeleteMapping("/trainingUnits/{id}")
    public void deleteById(@PathVariable("id") long id) {
        trainingUnitRepository.deleteById(id);
    }

}
