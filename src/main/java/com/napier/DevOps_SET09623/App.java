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
        // Number of cities
        String continent = "Asia";
        // Get Population
        long[] result = app.getPopulationOfContinent(continent);
        // Display results
        app.displayPopulationOfContinent(continent, result);

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
    public long[] getPopulationOfContinent(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getRegionPopulation = String.format(
                    "SELECT SUM(Population) FROM country WHERE Continent='%s';"
                    , continent);
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(getRegionPopulation);
            // Return population if valid.
            long population;
            if (!rset1.next())
            {
                return null;
            }
            else {
                population = rset1.getLong("SUM(Population)");
            }
            String getCityPopulationOfContinent = String.format(
                    "SELECT SUM(city.Population) FROM city INNER JOIN country WHERE " +
                            "city.CountryCode=country.Code AND country.Continent='%s';"
                    , continent);
            // Execute SQL statement
            ResultSet rset2 = stmt.executeQuery(getCityPopulationOfContinent);
            // Return population if valid.
            long populationOfCity = 0;
            if (!rset2.next())
            {
                return null;
            }
            else {
                populationOfCity += rset2.getLong("SUM(city.Population)");
            }
            long populationOfNotCity = population - populationOfCity;
            long[] result = new long[3];
            result[0] = population;
            result[1] = populationOfCity;
            result[2] = populationOfNotCity;
            return result;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population");
            return null;
        }
    }
    public  void displayPopulationOfContinent(String continent, long[] result)
    {
        if (result != null)
        {
            System.out.println(
                    "Continent Name: " + continent + "\n" +
                            "Population of Continent: " + result[0] + "\n" +
                            "Population in Cities: " + result[1] + "\n" +
                            "Population outside Cities: " + result[2]
            );
        }
    }
}