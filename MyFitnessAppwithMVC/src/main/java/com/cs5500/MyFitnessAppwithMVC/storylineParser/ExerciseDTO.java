package com.cs5500.MyFitnessAppwithMVC.storylineParser;

/**
 * This class parses represents an Exercise object.
 * An exercise is a certain activity, the duration of that activity,
 * the calories burned during the activity, the distance traveled, and the date.
 */
public class ExerciseDTO {

    //activity, duration, calories, distance, date
    private int id;
    private String activity;
    private int duration;
    private int calories;
    private int distance;
    private String date;

    /**
     * Construct a ExerciseDTO with the provided parameters. This constructor is not currently used;
     * rather, the default constructor is used. This is because we do not need to
     * instantiate objects with parameters.
     *
     * @param activity  string, the name of the exercise.
     * @param duration  int, the duration of the exercise.
     * @param calories  int, the calories burned during the exercise.
     * @param distance  int, the distance traveled.
     * @param date      date, the date the exercise took place on.
     */
    public ExerciseDTO(String activity, int duration, int calories, int distance,
                       String date){
        this.id = id;
        this.activity = activity;
        this.duration = duration;
        this.calories = calories;
        this.distance = distance;
        this.date = date;
    };

    /**
     * Default constructor.
     */
    public ExerciseDTO(){

    };

    /**
     * The following methods set attributes of an object created by the default constructor.
     *
     * @return  duration, calories, distance, date, id
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getActivity() {
        return activity;
    }

    /**
     * The following methods return attributes of an object.
     *
     * @return  duration, calories, distance, date, id
     */
    public int getDuration() {
        return duration;
    }

    public int getCalories() {
        return calories;
    }

    public int getDistance() {
        return distance;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
       return  id;
    }



}
