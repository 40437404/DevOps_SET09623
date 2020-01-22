package com.napier.DevOps_SET09623;

import java.sql.*;
import java.util.*;

public class App
{
    private Connection con = null;

    /**
     * Connection to the database
     **/
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver"); //Error Message
            System.exit(-1); //system.exit
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database..."); //Progress Message
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "root123!@#");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    public void populationOfACountry(String Continent,int Limit){
        if (con != null)
        {
            try { //To Catch Error
                String execute = "SELECT * FROM world.country where Continent='"+ Continent +"' ORDER BY Population DESC limit "+ Limit +";";
                //Preparing mysql command as a string
                Statement st = con.createStatement(); //Statement Creation
                ResultSet rs = st.executeQuery(execute); //Mysql Command Execution
                while (rs.next()) { //Preparing Output
                    String Code = rs.getString("Code"); //Creating Variable For Country Code
                    String name = rs.getString("Name"); //Creating Variable For Country Name
                    int populationnumber = rs.getInt("Population"); //Creating Variable For Population
                    String region = rs.getString("Continent"); //Creating Variable For Continent
                    System.out.format("Code = %s, Name = %s,Population = %s, Continent = %s\n", Code, name, populationnumber,Continent); //Output Statement
                }
                st.close(); //Closing Statement
            } catch (Exception e) {
                e.printStackTrace(); // To Print Out System Error Messages
            }
        }
    }
    /**
     * Disconnect from database
     * **/
    public void disconnect(){ //Disconnect Function
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void main(String[] args) {
        App a = new App(); // Create new Application
        a.connect();// Connect to database
        // Variable Preparation
        String Continent = "North America";
        int Limit = 10;
        a.populationOfACountry(Continent, Limit);
        // Disconnect from database
        a.disconnect();
    }
}