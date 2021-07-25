package com.cs5500.MyFitnessAppwithMVC.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * This class serves as our Controller for the Activity class. It connects and handles the UI's
 * CRUD links with an instance of the ActivityService class.
 */
@Controller
public class ActivityController {
  @Autowired
  private ActivityService service;

  @GetMapping("/activities")
  public String showActivityList(Model model) {
    List<Activity> activityList = service.listAll();
    model.addAttribute("activityList", activityList);

    return "activities";
  }

  @GetMapping("/activities/new")
  public String showNewForm(Model model) {
    model.addAttribute("activity", new Activity());
    model.addAttribute("pageTitle", "Add New Activity");
    return "activity_form";
  }

  @PostMapping("/activities/save")
  public String saveActivity(Activity activity, RedirectAttributes ra) {
    service.save(activity);
    ra.addFlashAttribute("message", "The activity has been saved successfully.");
    return "redirect:/activities";
  }

  @GetMapping("/activities/edit/{id}")
  public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
    try {
      Activity activity = service.get(id);
      model.addAttribute("activity", activity);
      model.addAttribute("pageTitle", "Edit Activity (ID: " + id + ")");
      return "activity_form";
    } catch (ActivityNotFoundException e) {
      ra.addFlashAttribute("message", e.getMessage());
      return "redirect:/activities";
    }
  }

  @GetMapping("/activities/delete/{id}")
  public String deleteActivity(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
    try {
      service.delete(id);
      ra.addFlashAttribute("message", "The Activity ID " + id + " has been deleted.");
    } catch (ActivityNotFoundException e) {
      ra.addFlashAttribute("message", e.getMessage());
    }
    return "redirect:/activities";
  }

}
