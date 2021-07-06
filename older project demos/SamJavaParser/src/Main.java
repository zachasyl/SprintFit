import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    ReadFile newFile = new ReadFile();
    JSONArray fileContentArray = newFile.getContentArray();
    // Create a HashMap that has a String key and ArrayList<String> as a value.
    HashMap<String, ArrayList> summaryDictionary = new HashMap<>();

    // Loops through the File Content Array
    for (int i = 0; i < fileContentArray.length() ; i++) {

      // Grab each date as a String.
      String date = fileContentArray.getJSONObject(i).getString("date");

      // Checks for invalid summary arrays (non-arrays)
      if (fileContentArray.getJSONObject(i).isNull("summary")) {
        System.out.println("Array is null");
      } else {
        // Retrieve summary object
        JSONArray summary = fileContentArray.getJSONObject(i).getJSONArray("summary");

        ArrayList<String> listOfActivities = new ArrayList<>();
        // Loops through the length of each individual summary and adds each activity to list.
        for (int j = 0; j < summary.length(); j++) {
          listOfActivities.add(summary.get(j).toString());
        }
        summaryDictionary.put(date, listOfActivities);
      }
    }

    // See the output of the Hashmap formatted.
    summaryDictionary.forEach((k, v) -> {
      System.out.println("Date: " + k + System.lineSeparator() + "Summary: " + v);
      //System.out.println(v.size());
    });

    // Retrieves the summary for the specified date. Date must be in String format (e.g. "20130209")
    ArrayList array = summaryDictionary.get("20130209");
    String firstEntry = array.get(0).toString();
    String[] words = firstEntry.split(",");
    for (String word: words) {
      //System.out.println(word);
    }




  }
}
