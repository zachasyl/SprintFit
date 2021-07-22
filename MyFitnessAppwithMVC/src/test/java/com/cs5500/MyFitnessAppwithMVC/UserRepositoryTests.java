package com.cs5500.MyFitnessAppwithMVC;

import com.cs5500.MyFitnessAppwithMVC.activity.Activity;
import com.cs5500.MyFitnessAppwithMVC.activity.ActivityRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {
  @Autowired
  private ActivityRepository repo;

  @Test
  public void testAddNew() {
    Activity activity = new Activity();
    activity.setActivityName("Running");
    activity.setCalories(50);
    activity.setDate("20201124");
    activity.setDuration(5);
    activity.setDistance(100);

    Activity savedActivity = repo.save(activity);

    Assertions.assertThat(savedActivity).isNotNull();
    Assertions.assertThat(savedActivity.getId()).isGreaterThan(0);

  }
}
