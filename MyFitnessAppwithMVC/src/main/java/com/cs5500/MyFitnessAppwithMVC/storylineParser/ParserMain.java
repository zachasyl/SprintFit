package com.cs5500.MyFitnessAppwithMVC.storylineParser;

public class ParserMain {
    /**
     * The main function creates a ParseJson object, AllData, and calls its ParseJson method
     * FillArrays(). This reads a JSON file and fills five arrays belonging to the ParseJson object:
     * activities, duration, calories, distance, and date.
     *
     * A JDBC object then calls the TableInsertion function, taking in each ParseJson
     * array as a parameter to fill a MYSQL database.
     */
    public static void main(String[] args) {
        ParseJSON AllData = new ParseJSON();
        AllData.FillArrays();

        JDBC MYSQLConnection = new JDBC();
        MYSQLConnection.TableInsertion(
                AllData.getActivitiesArray(),
            AllData.getDurationsArray(), AllData.getCaloriesArray(),
                AllData.getDistancesArray(), AllData.getDatesArray()
        );
    }
}
