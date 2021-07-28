package com.cs5500.MyFitnessAppwithMVC.activity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * This interface extends the Spring framework's Crud Repository, which allows for generic
 * CRUD operations.
 */
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
  /**
   * This method queries the database and checks how many entries match a specified id, checking
   * to make sure each id is unique.
   * @param id (Integer) specified id value
   * @return (Long) number of entries matching id value
   */
  public Long countById(Integer id);

  /**
   * Adding project specific queries to Spring framework's Crud repo
   */
  @Query(value = "SELECT c FROM Activity c WHERE c.activityName = 'Running' ORDER BY Calories DESC")
  List<Activity> findRunning();
  @Query(value = "SELECT c FROM Activity c ORDER BY Calories DESC")
  List<Activity> orderCalories();
};