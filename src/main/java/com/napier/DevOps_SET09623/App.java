package com.napier.DevOps_SET09623;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App app = new App();

        // Connect to database
        app.connect();
        // Get Employee
        City cty = app.topPopulatedCities(10);
        // Display results
        app.displayTopPopulatedCities(cty);

        // Disconnect from database
        app.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
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

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    public City topPopulatedCities(int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city order by Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City cty = new City();
                cty.id = rset.getInt("ID");
                cty.name = rset.getString("Name");
                cty.countrycode = rset.getString("CountryCode");
                cty.district = rset.getString("District");
                cty.population = rset.getInt("Population");
                return cty;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities");
            return null;
        }
    }
    public void displayTopPopulatedCities(City cty)
    {
        if (cty != null)
        {
            System.out.println(
                    "ID: " + cty.id + "\n" +
                            "Name: " + cty.name + "\n" +
                            "Country Code: " + cty.countrycode + "\n" +
                            "District: " + cty.district + "\n" +
                            "Population: " + cty.population
            );
        }
    }
}