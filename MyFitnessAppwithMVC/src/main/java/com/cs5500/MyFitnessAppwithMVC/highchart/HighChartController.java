package com.cs5500.MyFitnessAppwithMVC.highchart;

import com.cs5500.MyFitnessAppwithMVC.activity.Activity;
import com.cs5500.MyFitnessAppwithMVC.activity.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as our controller for the HighChart view. It connects and handles the UI's
 * CRUD links with an instance of the ActivityService class.
 */
@Controller
public class HighChartController {
  @Autowired
  private ActivityService service;

  @GetMapping("/highchartview")
  public String showHighChart(Model model) {
    List<String> ActivityNames = new ArrayList<>();
    ActivityNames.add("transport");
    ActivityNames.add("walking");
    ActivityNames.add("running");
    ActivityNames.add("other");
    model.addAttribute("activityNames", ActivityNames);

    List<Integer> ActivityValues = new ArrayList<>();
    Integer transport = 0;
    Integer walking = 0;
    Integer running = 0;
    Integer other = 0;

    List<Activity> activityList = service.listAll();
    for (Activity a : activityList) {
      //System.out.println(a.getDistance());
      if (a.getActivityName().equalsIgnoreCase("transport")) {
        transport += a.getDistance();
      } else if (a.getActivityName().equalsIgnoreCase("walking")) {
        walking += a.getDistance();
      } else if (a.getActivityName().equalsIgnoreCase("running")) {
        running += a.getDistance();
      } else {
        other += a.getDistance();
      }
    }
    ActivityValues.add(transport);
    ActivityValues.add(walking);
    ActivityValues.add(running);
    ActivityValues.add(other);

    model.addAttribute("activityValues", ActivityValues);

    return "highchartview";
  }
}
