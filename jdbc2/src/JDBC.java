// https://www.youtube.com/watch?v=e8g9eNnFpHQ youtube tutorial on JDBC which inspired this class.


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * This class allows a connection to the MySQL database.
 */
public class JDBC {

    /**
     * Connects to jdbc and uses SQL insert statement to fill each row of the table
     * with one piece of data from each of the five arrays.
     * Each of Activity, Calories, Date, Distance, and Duration can be thought of as columns.
     *
     * @param ActivityArray The activities we want to insert into the database.
     * @param CaloriesArray The calories burned we want to insert into the database
     * @param DateArray     The dates we want to insert into the database.
     * @param DistanceArray The distances traveled we want to insert into the database
     * @param DurationArray The duration of activities we want to inset into the database
     *
     * @returns void.
     */
    public void TableInsertion(ArrayList<String> ActivityArray,ArrayList<Integer>  DurationArray,
                     ArrayList<Integer> CaloriesArray, ArrayList<Integer> DistanceArray,
                     ArrayList<String> DateArray){

        try {
                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/Fitness", "root", "zxcvbnM1!3211");

                Statement statement = connection.createStatement();

                //String add = "INSERT INTO people VALUES(6, 'Sally')";
                for (int i = 0; i < ActivityArray.size(); i++) {
                    String add = "INSERT INTO Fitness VALUES(" + i + ", '" + ActivityArray.get(i) +
                            "', " + DurationArray.get(i) + ',' +
                            CaloriesArray.get(i) + "," + DistanceArray.get(i) + "," +  "'" + DateArray.get(i) + "')";

                    statement.executeUpdate(add);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


