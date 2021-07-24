package com.cs5500.MyFitnessAppwithMVC.storylineParser;

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
     */
    public void TableInsertion(ArrayList<String> ActivityArray,ArrayList<Integer>  DurationArray,
                     ArrayList<Integer> CaloriesArray, ArrayList<Integer> DistanceArray,
                     ArrayList<String> DateArray){

        try {
                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/fitnessdb", "root", "6413");

                Statement statement = connection.createStatement();

                //String add = "INSERT INTO people VALUES(6, 'Sally')";
                for (int i = 0; i < ActivityArray.size(); i++) {
                    String add = "INSERT INTO activities VALUES(" + i + ",'" + ActivityArray.get(i) +
                            "', " + CaloriesArray.get(i) + ',' +
                            DateArray.get(i) + "," + DistanceArray.get(i) + "," +  "'" + DurationArray.get(i) + "')";

                    statement.executeUpdate(add);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


