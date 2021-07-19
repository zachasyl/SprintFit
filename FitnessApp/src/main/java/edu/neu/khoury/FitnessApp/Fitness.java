package edu.neu.khoury.FitnessApp;
// like a dto

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fitness {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long Fitnessid;
    private  String Activity;
    private int Duration;
    private int Calories;
    private int Distance;
    private String Date;

    public Fitness(){

    }

    public long getId() {
        return Fitnessid;
    }

    public void setId(long id) {
        this.Fitnessid = Fitnessid;
    }

    public String getActivity() {
        return Activity;
    }

    public void setActivity(String activity) {
        this.Activity = activity;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        this.Duration = Duration;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int calories) {
        this.Calories = Calories;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        this.Distance = Distance;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public Fitness(String name) {
        this.Fitnessid = -1;
        this.Activity = Activity;
        this.Duration = Duration;
        this.Calories = Calories;
        this.Distance = Distance;
        this.Date = Date;
    }


}

