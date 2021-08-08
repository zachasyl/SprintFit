package com.cs5500.MyFitnessAppwithMVC.BarGraphs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BarGraphsControllerWeb {
    @Autowired
    private BarGraphsRepository barGraphsRepository;

    @GetMapping("/barGraphs")
    public String barGraphs(@RequestParam(name="id", required=false, defaultValue="2") int id, Model model) {
        Optional<BarGraphs> barGraphs = barGraphsRepository.findById(Long.valueOf(id));
        if (barGraphs.isPresent()) {
            model.addAttribute("name", barGraphs.get().getContent());
        } else {
            model.addAttribute("name", "No Match");
        }

        Integer totalRunning =  barGraphsRepository.sumCaloriesRunning();
        model.addAttribute("runValue", totalRunning);


        List<List<Integer>> calsPerYear =  barGraphsRepository.caloriesEachYear();

        model.addAttribute("calsPerYear", calsPerYear);


        Integer totalWalking =  barGraphsRepository.sumCaloriesWalking();
        model.addAttribute("walkValue", totalWalking);

        Integer totalCycling =  barGraphsRepository.sumCaloriesCycling();
        model.addAttribute("cycleValue", totalCycling);

        Integer distanceRunning =  barGraphsRepository.sumDistanceRunning();
        model.addAttribute("runDistanceValue", distanceRunning);

        Integer distanceWalking =  barGraphsRepository.sumDistanceWalking();
        model.addAttribute("walkDistanceValue", distanceWalking);

        Integer distanceCycling =  barGraphsRepository.sumDistanceCycling();
        model.addAttribute("cycleDistanceValue", distanceCycling);


        return "barGraphs"; // "view"/webpage named "barGraphs.html"
    }

}

