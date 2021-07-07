import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO implements ExerciseDAO {

    /**
     * Connects to JDBC and uses SQL select where statement to fill a row of the table
     * with one object. This method is inspired by: https://dzone.com/articles/building-simple-data-access-layer-using-jdbc
     *
     * @param id The identification attribute of the object we want to get.
     *
     * @returns ExerciseDgTO object.
     */
    public static ExerciseDTO getExercise(int id) {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/Fitness", "root", "");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Fitness WHERE Fitnessid =" + id);
            ExerciseDTO exerciseDTO = new ExerciseDTO();

            if (rs.next()) {

                exerciseDTO.setActivity(rs.getString("activity"));
                exerciseDTO.setCalories(rs.getInt("calories"));
                exerciseDTO.setDate(rs.getString("date"));
                exerciseDTO.setDistance(rs.getInt("distance"));
                exerciseDTO.setDuration(rs.getInt("duration"));

                return exerciseDTO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Connects to JDBC and uses SQL insert statement to fill a row of the table
     * with one object.
     *
     * @param exerciseDTO The object whose attributes will be passed to the mySQL database.
     *
     * @returns void.
     */
    public static void addExercise(ExerciseDTO exerciseDTO) {
        try {
            Connection connection = DriverManager.getConnection
                    // Technically this should read in information from text file.
                    ("jdbc:mysql://localhost:3306/Fitness", "root", "");

            Statement statement = connection.createStatement();

            String add = "INSERT INTO Fitness VALUES(" + exerciseDTO.getId() + ",'" + exerciseDTO.getActivity() +
                    "', " + exerciseDTO.getDuration() + ',' +
                    exerciseDTO.getCalories() + "," +
                    exerciseDTO.getDistance() + "," + "'" + exerciseDTO.getDate() + "')";

            statement.executeUpdate(add);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
