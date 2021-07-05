public class ExerciseDTO {

    //activity, duration, calories, distance, date
    private int id;
    private String activity;
    private int duration;
    private int calories;
    private int distance;
    private String date;


    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getActivity() {
        return activity;
    }

    public int getDuration() {
        return duration;
    }

    public int getCalories() {
        return calories;
    }

    public int getDistance() {
        return distance;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
       return  id;
    }



}
