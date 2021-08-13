package com.cs5500.MyFitnessAppwithMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This serves as a main controller that directs the user to the homepage of the web app.
 */
@Controller
public class MainController {
  //This stub tells Spring that the app should show the Home Page by default.
  @GetMapping("")
  public String showHomePage() {
    return "index";
  }
}
