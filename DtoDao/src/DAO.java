import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO implements ExerciseDAO {

    @Override
    public ExerciseDTO getExercise(int id) {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/Fitness", "root", "");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if (rs.next()) {
                ExerciseDTO exerciseDTO = new ExerciseDTO();

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

    public static void addExercise(ExerciseDTO exerciseDTO) {
        try {
            Connection connection = DriverManager.getConnection
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
