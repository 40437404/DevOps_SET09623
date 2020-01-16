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
        String country = "Japan";
        // Get Population
        int[] result = new int[3];
        result = app.getPopulationOfCountry(country);
        // Display results
        app.displayPopulationOfCountry(country, result);

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
    public int[] getPopulationOfCountry(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getCountryPopulation = String.format(
                    "SELECT Population FROM country WHERE Name='%s';"
                    , country);
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(getCountryPopulation);
            // Return population if valid.
            int population;
            if (rset1.next() == false)
            {
                return null;
            }
            else {
                population = rset1.getInt("Population");
            }
            String getCityPopulationOfCountry = String.format(
                    "SELECT city.Population FROM city INNER JOIN country WHERE " +
                            "city.CountryCode=country.Code AND country.Name='%s';"
                    , country);
            // Execute SQL statement
            ResultSet rset2 = stmt.executeQuery(getCityPopulationOfCountry);
            // Return population if valid.
            int populationOfCity = 0;
            if (rset2.next() == false)
            {
                return null;
            }
            else {
                do {
                    populationOfCity += rset2.getInt("Population");
                } while (rset2.next());
            }
            int populationOfNotCity = population - populationOfCity;
            int[] result = new int[3];
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
    public  void displayPopulationOfCountry(String country, int[] result)
    {
        if (result != null)
        {
            System.out.println(
                    "Country Name: " + country + "\n" +
                            "Population of Country: " + result[0] + "\n" +
                            "Population in Cities: " + result[1] + "\n" +
                            "Population outside Cities: " + result[2]
            );
        }
    }
}