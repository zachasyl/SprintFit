import org.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class parses activity data from a JSON file.
 * It puts puts corresponding activities, calories, duration, distance, and date into
 * an object. The object is then transferred to a MySQL database each iteration.
 */
public class ParseJSON {

    /**
     * Default constructor. FillObject method will load its attributes.
     */
    public ParseJSON(){

    }

    /**
     * Reads the JSON files and fills the objects.
     *
     */
    public void FillObjects() {

        String file = "/Users/zachary/Desktop/storyline.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(file))));


            //this array will contan all the contents of the JSON string.
            // we can look up keys from the array to get data.
            JSONArray arr = new JSONArray(contents);
            //JSONArray arr = new JSONArray(jsonString);


            //for each entry in the array
            for (int x = 0; x < arr.length(); x++) {
                ExerciseDTO exerciseDTO = new ExerciseDTO();

                // For each object, we will find the key "date" which represents a string date

                String date = arr.getJSONObject(x).getString("date");
                // some of the summary arrays actually are not arrays and are null ;(
                if (arr.getJSONObject(x).isNull("summary")) {
                } else {
                    // we will find the key "summary" which represents an array.
                    JSONArray summary = arr.getJSONObject(x).getJSONArray("summary");


                    // We will search summary array (which contains objects)
                    for (int i = 0; i < summary.length(); i++) {


                        // we will search within each OBJECT in summary array
                        // for the object key activity and key duration.
                        // each activity is in a different object.
                        // the activity and duration string value is printed.

                        String activity = summary.getJSONObject(i).getString("activity");
                        int duration = summary.getJSONObject(i).getInt("duration");
                        // Filling object attributes.
                        exerciseDTO.setActivity(activity);
                        exerciseDTO.setDuration(duration);
                        exerciseDTO.setDate(date);


                        if (summary.getJSONObject(i).isNull("calories")) {
                            exerciseDTO.setCalories(0);

                        } else {

                            int calories = summary.getJSONObject(i).getInt("calories");
                            exerciseDTO.setCalories(calories);
                        }
                        int distance = summary.getJSONObject(i).getInt("distance");
                        exerciseDTO.setDistance(distance);

                    }
                }
                // DAO object's method will send object to the database.
                DAO.addExercise(exerciseDTO);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




