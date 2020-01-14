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
    public void cityInWorldDesc(){
        if (con != null)
        {
            try {
                // sql query
                String query = "SELECT * FROM city ORDER by Population DESC";
                // create the java statement
                Statement st = con.createStatement();
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                // iterate through the java resultset
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    String ccode = rs.getString("CountryCode");
                    String district = rs.getString("District");
                    int pop = rs.getInt("Population");

                    // print the results
                    System.out.format("ID = %s,Name = %s,CountryCode = %s,District = %s,Population = %s\n", id, name, ccode, district, pop);
                }
                st.close();
            } catch (Exception e) {
                System.out.println("Error Getting City Data");
            }
        }
    }
    public void cityInRegionDesc(String region){
        if(con != null){
            try{
                // sql query
                String query = ("SELECT city.ID,city.Name,city.CountryCode,city.Population,country.Region FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Region = '"+ region +"' ORDER BY city.Population DESC;");
                // create the java statement
                Statement st = con.createStatement();
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                // iterate through the java resultset
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    String ccode = rs.getString("CountryCode");
                    int pop = rs.getInt("Population");
                    String reg = rs.getString("Region");

                    // print the results
                    System.out.format("ID = %s,Name = %s,CountryCode = %s,Population = %s,Region = %s\n", id, name, ccode, pop,reg);
                }
                st.close();
            }catch (Exception e){
                System.out.println("Error Getting City Data from region");
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
        a.cityInWorldDesc();

        // Get City Info in the region by descending of population
        String regio = "Caribbean";
        a.cityInRegionDesc(regio);

        // Disconnect from database
        a.disconnect();
    }
}
