import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


class ParseJSON {
    static String jsonString = "";

    public static void main(String[] args) {

        String file = "storyline.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(file))));

            //this array will contain all the contents of the JSON string.
            // we can look up keys from the array to get data.
            JSONArray arr = new JSONArray(contents);
            //JSONArray arr = new JSONArray(jsonString);

            //for each entry in the array
            for (int x = 0; x < arr.length() ; x++) {

                // For each object, we will find the key "date" which represents a string date

                String date = arr.getJSONObject(x).getString("date");

                // some of the summary arrays actually are not arrays and are null ;(
                if (arr.getJSONObject(x).isNull("summary")) {
                    System.out.println("null");
                } else {
                    // we will find the key "summary" which represents an array.
                    JSONArray summary = arr.getJSONObject(x).getJSONArray("summary");
                    System.out.println(date);
                    System.out.println(summary);
                    System.out.println(summary.get(0));
                    // we will print out the date, as it is just a string.
                    //System.out.println(date);


                    // We will search summary array (which contains objects)
                    for (int i = 0; i < summary.length(); i++) {

                        //System.out.println(summary.get(i)); would print each summary array

                        // we will search within each OBJECT in summary array
                        // for the object key activity and key duration.
                        // each activity is in a different object.
                        // the activity and duration string value is printed.

                        String activity = summary.getJSONObject(i).getString("activity");
                        int duration = summary.getJSONObject(i).getInt("duration");

//                        System.out.println(activity);
//                        System.out.println(duration);

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}