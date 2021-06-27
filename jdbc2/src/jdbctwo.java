// https://www.youtube.com/watch?v=e8g9eNnFpHQ youtube tutorial.


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbctwo {

        public static void main(String[] args){

            try {

                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/jdbc", "root", "");

                Statement statement = connection.createStatement();
                String add = "INSERT INTO people VALUES(6, 'Sally')";
                statement.executeUpdate(add);
                ResultSet resultset = statement.executeQuery("select * from people");

                //prints ALL firstnames -- 1-4 already in the table and 5, sally.
                while (resultset.next()) {
                    System.out.println(resultset.getString("firstname"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


