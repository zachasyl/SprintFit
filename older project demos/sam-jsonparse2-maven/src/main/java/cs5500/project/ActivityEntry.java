package cs5500.project;

//TODO how to refactor this class for walking vs transport and other future activities.

/**
 * This class represents a single Activity Entry in our Summary Object.
 */
public class ActivityEntry {
  //TODO Zach you mentioned calculating some of these fields based on other fields.
  // Could help with standardizing between different activities.
  private String activity;
  private String group;
  private double duration;
  private double distance;
  private double steps;
  private double calories;

  /**
   * This is a public constructor for an Activity Entry.
   * It is critical that the names of these fields match the JSON file keys.
   * @param activity String name representation of this activity.
   * @param group String name representation of this group. (superfluous at this point)
   * @param duration Double of the duration of this activity in seconds.
   * @param distance Double of the distance of this distance in meters.
   * @param steps Double of the number of steps taken
   * @param calories Double of the number of calories burned.
   */
  public ActivityEntry(String activity, String group, double duration, double distance,
      double steps, double calories) {
    this.activity = activity;
    this.group = group;
    this.duration = duration;
    this.distance = distance;
    this.steps = steps;
    this.calories = calories;
  }

  @Override
  public String toString() {
    return "Activity: " + this.activity + System.lineSeparator()
        + "Group: " + this.group + System.lineSeparator()
        + "Duration: " + this.duration + System.lineSeparator()
        + "Distance: " + this.distance + System.lineSeparator()
        + "Steps: " + this.steps + System.lineSeparator()
        + "Calories: " + this.calories + System.lineSeparator();
  }

}