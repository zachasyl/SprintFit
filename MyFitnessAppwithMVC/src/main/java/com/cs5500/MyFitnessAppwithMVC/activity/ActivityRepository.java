package com.cs5500.MyFitnessAppwithMVC.activity;

import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {
  public Long countById(Integer id);
}
