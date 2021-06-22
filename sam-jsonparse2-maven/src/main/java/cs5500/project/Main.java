package cs5500.project;

import com.google.gson.Gson;

public class Main {

  public static void main(String[] args) {

    deserializeStoryline();
  }

  private static void deserializeStoryline() {
    String dateJson = "{'activity' : 'walking', 'group' : 'walking',"
        + " 'duration' : 1845.0, 'distance' : 1562.0, "
        + "'steps' : 2254, 'calories' : 78 }";

    Gson gson = new Gson();
    ActivityEntry date = gson.fromJson(dateJson, ActivityEntry.class);
    System.out.println(date);
  }
}
