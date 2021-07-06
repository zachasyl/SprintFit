public class Activity {

    private String activityType;
    private String groupType;
    private double duration;
    private double distance;
    private double caloriesBurned;
    private double steps;

    public Activity(String activityType, String groupType,
                    double duration, double distance,
                    double caloriesBurned, double steps) {
        this.activityType = activityType;
        this.groupType = groupType;
        this.duration = duration;
        this.distance = distance;
        this.caloriesBurned = caloriesBurned;
        this.steps = steps;
    }

    public Activity(String activityType, String groupType, double duration, double distance) {
        this.activityType = activityType;
        this.groupType = groupType;
        this.duration = duration;
        this.distance = distance;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public double getDuration() {
        return this.duration;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getCaloriesBurned() {
        return this.caloriesBurned;
    }

    public double getSteps() {
        return this.steps;
    }

}

