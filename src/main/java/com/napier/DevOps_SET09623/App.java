package com.napier.DevOps_SET09623;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Main function of the program
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args)
    {
        // Create new Application
        App app = new App();

        // Connect to database
        app.connect();

        // Number of cities
        int nCity = 10;
        // District name
        String district = "Zuid-Holland";
        // Country name
        String country = "Japan";
        //
        String region = "Caribbean";

        // Get top populated cities worldwide
        ArrayList<City> getTopCities;
        getTopCities = app.topPopulatedCities(nCity);
        // Display results
        app.displayTopPopulatedCities(getTopCities);

        // Get top populated cities in a district
        ArrayList<City> getTopCitiesInDistrict;
        getTopCitiesInDistrict = app.PopulatedCitiesInDistrict(district);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInDistrict);

        // Get top populated cities in a country
        ArrayList<City> getTopCitiesInCountry;
        getTopCitiesInCountry = app.populatedCitiesInACountry(country);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInCountry);

        // Get populated capital cities in a region
        ArrayList<City> capitalCitiesInRegion;
        capitalCitiesInRegion = app.populatedCapitalCitiesInRegion(region, nCity);
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInRegion);

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
                System.out.println("Failed to connect to database attempt " + i);
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

    /**
     * Get top populated cities around the world
     * @param limit number of countries
     * @return get an ArrayList of top populated cities
     */
    public ArrayList<City> topPopulatedCities(int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT * FROM city order by Population DESC LIMIT %d"
                    , limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCitiesFromQuery(rset);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities");
            return null;
        }
    }

    /**
     * Get top populated cities in a district
     * @param district name of the district
     * @return return an ArrayList of top populated cities in that district
     */
    public ArrayList<City> PopulatedCitiesInDistrict(String district)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT * from city where District='%s' ORDER BY Population DESC;"
                    , district);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCitiesFromQuery(rset);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities");
            return null;
        }
    }

    /**
     * Get top populated cities in a country
     * @param country name of the country
     * @return return an ArrayList of top populated cities in that country
     */
    public ArrayList<City> populatedCitiesInACountry(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT city.Id, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country where city.CountryCode = country.Code " +
                            "AND country.Name = '%s' ORDER BY city.Population DESC"
                    , country);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCitiesFromQuery(rset);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities");
            return null;
        }
    }

    /**
     * Get top populated capital cities in a region
     * @param region region name
     * @param nCity number of cities
     * @return return an ArrayList of top populated cities in that country
     */
    public ArrayList<City> populatedCapitalCitiesInRegion(String region, int nCity)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM " +
                            "country INNER JOIN city WHERE country.Capital=city.ID AND Region='%s' " +
                            "ORDER BY city.Population DESC LIMIT %d;"
                    , region, nCity);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCitiesFromQuery(rset);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities");
            return null;
        }
    }

    /**
     * Get Cities from SQL query
     * @param rset SQL query result
     * @return return an ArrayList containing cities
     * @throws SQLException throws an instance of SQLException
     */
    public ArrayList<City> getCitiesFromQuery(ResultSet rset) throws SQLException {
        // Return new city if valid.
        ArrayList<City> cty = new ArrayList<>();
        if (!rset.next())
            return null;
        else {
            do {
                City city = new City();
                city.id = rset.getInt("ID");
                city.name = rset.getString("Name");
                city.countryCode = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cty.add(city);
            } while (rset.next());
            return cty;
        }
    }

    /**
     * Display top populated cities around the world
     * @param cty ArrayList containing top populated cities
     */
    public void displayTopPopulatedCities(ArrayList<City> cty)
    {
        if (cty != null)
        {
            int i = 1;
            for (City city: cty)
            {
                System.out.println(
                        "No: " + i + "\n" +
                                "ID: " + city.id + "\n" +
                                "Name: " + city.name + "\n" +
                                "Country Code: " + city.countryCode + "\n" +
                                "District: " + city.district + "\n" +
                                "Population: " + city.population
                );
                i++;
            }
        }
    }
}