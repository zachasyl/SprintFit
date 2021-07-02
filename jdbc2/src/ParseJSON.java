import org.json.JSONArray;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class parses activity data from a JSON file.
 * Its objects have five arrays which can be filled with the JSON data
 * via the FillArrays method.
 */
public class ParseJSON {

    private static ArrayList<String> activitiesArr = new ArrayList<String>();
    private static ArrayList<Integer> durationsArr = new ArrayList<Integer>();
    private static ArrayList<Integer> caloriesArr = new ArrayList<Integer>();
    private static ArrayList<Integer> distancesArr = new ArrayList<Integer>();
    private static ArrayList<String> datesArr = new ArrayList<String>();

    /**
     * Construct a ParseJSON with the provided parameters. This constructor is not currently used;
     * rather, the default constructor is used. This is because we do not need to
     * instantiate ParseJSON objects with parameters; rather, we call FillArrays() to read JSON file
     * and fill the arrays. Maybe use this for resting.
     *
     * @param activitiesArr    an ArrayList of activities
     * @param durationsArr  color of piece, black or white.
     * @param caloriesArr  color of piece, black or white.
     * @param distancesArr  color of piece, black or white.
     * @param datesArr  color of piece, black or white.
     */
    public ParseJSON(ArrayList<String> activitiesArr,ArrayList<Integer> durationsArr,
                     ArrayList<Integer> caloriesArr, ArrayList<Integer> distancesArr,
                     ArrayList<String> datesArr){
        this.activitiesArr = activitiesArr;
        this.durationsArr =durationsArr;
        this.caloriesArr = caloriesArr;
        this.distancesArr = distancesArr;
        this.datesArr = datesArr;
    }

    /**
     * Default constructor. FillArray method will load its arrays.
     */
    public ParseJSON(){

    }

    /**
     * The following methods return new ArrayList objects.
     *
     * @return ArrayList of activities, duration, calories, distance, dates.
     */
    public ArrayList<String> getActivitiesArray() {
        // I am not sure if I should return this.activitiesArr instead like a typical getter.
        // because an array is returned, I think it needs to be a separate object when called in main?
        return new ArrayList<>(activitiesArr);
    }

    public ArrayList<Integer> getDurationsArray() {
        return new ArrayList<>(durationsArr);
    }

    public ArrayList<Integer> getCaloriesArray() {
        return new ArrayList<>(caloriesArr);
    }

    public ArrayList<Integer> getDistancesArray() {
        return new ArrayList<>(distancesArr);
    }

    public ArrayList<String> getDatesArray() {
        return new ArrayList<>(datesArr);
    }

    /**
     * Reads the JSON files and fills the object's arrays.
     *
     * @returns void.
     */
    public void FillArrays() {

        String file = "resources/storyline.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(file))));


            //this array will contan all the contents of the JSON string.
            // we can look up keys from the array to get data.
            JSONArray arr = new JSONArray(contents);
            //JSONArray arr = new JSONArray(jsonString);


            //for each entry in the array
            for (int x = 0; x < arr.length(); x++) {

                // For each object, we will find the key "date" which represents a string date


                String date = arr.getJSONObject(x).getString("date");
                // some of the summary arrays actually are not arrays and are null ;(
                if (arr.getJSONObject(x).isNull("summary")) {
                    //System.out.println("null");
                } else {
                    // we will find the key "summary" which represents an array.
                    JSONArray summary = arr.getJSONObject(x).getJSONArray("summary");

                    // we will print out the date, as it is just a string.


                    // We will search summary array (which contains objects)
                    for (int i = 0; i < summary.length(); i++) {

                        //System.out.println(summary.get(i)); would print each summary array

                        // we will search within each OBJECT in summary array
                        // for the object key activity and key duration.
                        // each activity is in a different object.
                        // the activity and duration string value is printed.

                        String activity = summary.getJSONObject(i).getString("activity");
                        int duration = summary.getJSONObject(i).getInt("duration");
                        activitiesArr.add(activity);
                        durationsArr.add(duration);
                        datesArr.add(date);


                        if (summary.getJSONObject(i).isNull("calories")) {
                            caloriesArr.add(0);

                        } else {

                            int calories = summary.getJSONObject(i).getInt("calories");
                            caloriesArr.add(calories);
                        }
                        int distance = summary.getJSONObject(i).getInt("distance");
                        distancesArr.add(distance);

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}