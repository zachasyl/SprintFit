package com.cs5500.MyFitnessAppwithMVC.storylineParser;

import java.sql.*;

public class DAOJDBC implements ExerciseDAO {

    /**
     * Connects to JDBC and uses SQL select where statement to fill a row of the table
     * with one object.
     *
     * @param id The identification attribute of the object we want to get.
     *
     * @returns ExerciseDgTO object.
     */
    public static ExerciseDTO getExercise(int id) {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/Fitness", "root", "zxcvbnM1!3211");

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
    public static void addExercise(ExerciseDTO exerciseDTO) throws SQLException {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection
                    // Technically this should read in from text file.
                    ("jdbc:mysql://localhost:3306/Fitness", "root", "zxcvbnM1!3211");

            Statement statement = connection.createStatement();

            String add = "INSERT INTO activities VALUES(" + exerciseDTO.getId() + ",'" + exerciseDTO.getActivity() +
                    "', " + exerciseDTO.getDuration() + ',' +
                    exerciseDTO.getCalories() + "," +
                    exerciseDTO.getDistance() + "," + "'" + exerciseDTO.getDate() + "')";

            statement.executeUpdate(add);

        }catch(SQLException sqlEx){
        /*To catch any SQLException thrown during DB
         *Operations and continue processing like sending alert to admin
         *that exception occurred.
         */
    }finally{
        /*This block should be added to your code
         * You need to release the resources like connections
         */
        if(connection!=null)
            connection.close();
    }

    }
}
