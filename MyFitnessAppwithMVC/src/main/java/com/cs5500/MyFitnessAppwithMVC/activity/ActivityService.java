package com.cs5500.MyFitnessAppwithMVC.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

  @Autowired
  private ActivityRepository repo;

  public List<Activity> listAll() {
    return (List<Activity>) repo.findAll();
  }

  public void save(Activity activity) {
    repo.save(activity);
  }

  public Activity get(Integer id) throws ActivityNotFoundException {
    Optional<Activity> result = repo.findById(id);
    if (result.isPresent()) {
      return result.get();
    }
    throw new ActivityNotFoundException("Could not find activity matching id.");
  }

  public void delete(Integer id) throws ActivityNotFoundException {
    Long count = repo.countById(id);
    if (count == null || count == 0) {
      throw new ActivityNotFoundException("Could not find activity matching id.");
    }
    repo.deleteById(id);
  }
}
