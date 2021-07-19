package edu.neu.khoury.FitnessApp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FitnessAppRepository extends CrudRepository<Fitness,
        Integer> {

    @Query("SELECT c FROM Fitness c WHERE c.Activity = 'Running'")
    public List<Fitness> findRunning();

}