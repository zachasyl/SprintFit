
public class Main {
    /**
     * The main function creates a ParseJson object, AllData, and calls its ParseJson method
     * FillObjects(). This reads a JSON file and fills objects.
     *
     * Within ParseJson, DAO's add method is called on each filled object to add it to the database.
     */
    public static void main(String[] args) {
        ParseJSON AllData = new ParseJSON();
        AllData.FillObjects();
    }
}
