package com.cs5500.MyFitnessAppwithMVC.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the primary data object for our application. It is tagged with the Spring
 * Boot @Entity tag, indicating to Spring that this object should be mapped onto our activities
 * table.
 */
@Entity
@Table(name = "activities")
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = true)
  private String activityName;

  @Column(nullable = true)
  private Integer duration;

  @Column(nullable = true)
  private Integer calories;

  @Column(nullable = true)
  private Integer distance;

  @Column(nullable = false)
  private String date;


  public Integer getId() {
    return id;
  }

  public void setId(Integer activityId) {
    this.id = activityId;
  }

  public String getActivityName() {
    return activityName;
  }

  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Integer getCalories() {
    return calories;
  }

  public void setCalories(Integer calories) {
    this.calories = calories;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Activity{" +
        "activityId=" + id +
        ", activityName='" + activityName + '\'' +
        ", duration=" + duration +
        ", calories=" + calories +
        ", distance=" + distance +
        ", Date='" + date + '\'' +
        '}';
  }

}
