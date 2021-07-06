import java.util.ArrayList;
import java.util.List;

public class Summary {
    ArrayList<Activity> activityList;


    public Summary() {
        this.activityList = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        this.activityList.add(activity);
    }

    public ArrayList<Activity> getActivityList() {
        return this.activityList;
    }
}
