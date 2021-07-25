package com.cs5500.MyFitnessAppwithMVC.activity;

import org.springframework.data.repository.CrudRepository;

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
}
