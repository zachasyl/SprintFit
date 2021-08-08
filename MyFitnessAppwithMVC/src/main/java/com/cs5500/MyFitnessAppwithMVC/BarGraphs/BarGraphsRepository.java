package com.cs5500.MyFitnessAppwithMVC.BarGraphs;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BarGraphsRepository extends CrudRepository<BarGraphs, Long> {


//    Queries for calorie sums
    @Query(value = "SELECT SUM(Calories) FROM activities WHERE activity_name = 'running'", nativeQuery = true)
    public Integer sumCaloriesRunning();

    @Query(value = "SELECT SUM(Calories) FROM activities WHERE activity_name = 'cycling'", nativeQuery = true)
    public Integer sumCaloriesCycling();

    @Query(value = "SELECT SUM(Calories) FROM activities WHERE activity_name = 'walking'", nativeQuery = true)
    public Integer sumCaloriesWalking();

//  Queries for distance sums
    @Query(value = "SELECT SUM(Distance) FROM activities WHERE activity_name = 'running'", nativeQuery = true)
    public Integer sumDistanceRunning();

    @Query(value = "SELECT SUM(Distance) FROM activities WHERE activity_name = 'cycling'", nativeQuery = true)
    public Integer sumDistanceCycling();

    @Query(value = "SELECT SUM(Distance) FROM activities WHERE activity_name = 'walking'", nativeQuery = true)
    public Integer sumDistanceWalking();

    @Query(value = "SELECT SUM(Calories), YEAR(Date) FROM activities GROUP BY YEAR(Date) ORDER BY YEAR(Date) DESC", nativeQuery = true)
    List<List<Integer>> caloriesEachYear();

}

