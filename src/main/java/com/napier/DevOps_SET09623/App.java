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
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
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
    public void continentLarge2small(String ncontinent){
        if (con != null)
        {
            try {
                // sql query
                String query = "SELECT Code,Name,Continent,Population FROM world.country WHERE country.Continent='"+ ncontinent +"' ORDER BY Population DESC ";
                // create the java statement
                Statement st = con.createStatement();
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                // iterate through the java resultset
                while (rs.next()) {
                    String ccode = rs.getString("CODE");
                    String name = rs.getString("Name");
                    String cont = rs.getString("Continent");
                    String pplo = rs.getString("Population");

                    // print the results
                    System.out.format("CODE = %s,Name = %s,Continent = %s,Population = %s\n",ccode, name,cont, pplo);
                }
                st.close();
            } catch (Exception e) {
                System.out.println("Fail to load data");
            }
        }
    }


    /**
     * Disconnect from database
     * **/
    public void disconnect(){
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
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get City Info In the world by descending of population

        String ncontinent = "Asia";
        a.continentLarge2small(ncontinent);

        // Disconnect from database
        a.disconnect();
    }
}
