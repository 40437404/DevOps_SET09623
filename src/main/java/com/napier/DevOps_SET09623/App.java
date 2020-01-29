package com.napier.DevOps_SET09623;

import java.sql.*;
import java.util.*;

import static java.lang.String.format;
import static java.util.Map.*;

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
        if (args.length < 1)
        {
            app.connect("localhost:33060");
        }
        else
        {
            app.connect(args[0]);
        }

        // Number of cities
        int limit = 10;
        // District name
        String district = "Zuid-Holland";
        // Country name
        String country = "Japan";
        // Region name
        String region = "Caribbean";
        // Continent name
        String continent = "Asia";
        // City name
        String city = "Tokyo";
        // Store type of place
        String type;

        // 1. Get Populated Countries of the world
        ArrayList<Country> getPopulatedCountriesOfWorld;
        getPopulatedCountriesOfWorld = app.worldCountryLargeToSmall();
        // Display results
        app.displayTopPopulatedCountries(getPopulatedCountriesOfWorld);

        // 2. Get Populated Countries of a continent
        ArrayList<Country> getPopulatedCountriesOfContinent;
        getPopulatedCountriesOfContinent = app.continentCountryLargeToSmall(continent);
        // Display results
        app.displayTopPopulatedCountries(getPopulatedCountriesOfContinent);

        // 3. Get Populated Countries of a region
        ArrayList<Country> getPopulatedCountriesOfRegion;
        getPopulatedCountriesOfRegion = app.regionCountryLargeToSmall(region);
        // Display results
        app.displayTopPopulatedCountries(getPopulatedCountriesOfRegion);

        // 4. Get Populated certain number of Countries in world
        ArrayList<Country> getNPopulatedCountriesInWorld;
        getNPopulatedCountriesInWorld = app.populateCountriesInWorld(limit);
        // Display results
        app.displayTopPopulatedCountries(getNPopulatedCountriesInWorld);

        // 5. Get Populated certain number of Countries in continent
        ArrayList<Country> getNPopulatedCountriesInContinent;
        getNPopulatedCountriesInContinent = app.populatedCountriesInContinent(continent, limit);
        // Display results
        app.displayTopPopulatedCountries(getNPopulatedCountriesInContinent);

        // 6. Get Populated certain number of Countries in region
        ArrayList<Country> getNPopulatedCountriesInRegion;
        getNPopulatedCountriesInRegion = app.populatedCountriesInRegion(region, limit);
        // Display results
        app.displayTopPopulatedCountries(getNPopulatedCountriesInRegion);

        // 7. Get populated cities in the world
        ArrayList<City> getCitiesInWorld;
        getCitiesInWorld = app.cityInWorldDesc();
        // Display results
        app.displayTopPopulatedCities(getCitiesInWorld);

        // 8. Get populated cities in the continent
        ArrayList<City> getCitiesInContinent;
        getCitiesInContinent = app.cityInContinentDesc(continent);
        // Display results
        app.displayTopPopulatedCities(getCitiesInContinent);

        // 9. Get populated cities in the region
        ArrayList<City> getCitiesInRegion;
        getCitiesInRegion = app.cityInRegionDesc(region);
        // Display results
        app.displayTopPopulatedCities(getCitiesInRegion);

        // 10. Get populated cities in the country
        ArrayList<City> getCitiesInCountry;
        getCitiesInCountry = app.cityInCountryDesc(country);
        // Display results
        app.displayTopPopulatedCities(getCitiesInCountry);

        // 11. Get populated cities in the district
        ArrayList<City> getCitiesInDistrict;
        getCitiesInDistrict = app.cityInDistrictDesc(district);
        // Display results
        app.displayTopPopulatedCities(getCitiesInDistrict);

        // 12. Get top N populated cities worldwide
        ArrayList<City> getTopCitiesInWorld;
        getTopCitiesInWorld = app.topNPopulatedCitiesInWorld(limit);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInWorld);

        // 13. Get top N populated cities in a continent
        ArrayList<City> getTopCitiesInContinent;
        getTopCitiesInContinent = app.topNPopulatedCitiesInContinent(continent, limit);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInContinent);

        // 14. Get top N populated cities in a region
        ArrayList<City> getTopCitiesInRegion;
        getTopCitiesInRegion = app.topNPopulatedCitiesInRegion(region, limit);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInRegion);

        // 15. Get top N populated cities in a country
        ArrayList<City> getTopCitiesInCountry;
        getTopCitiesInCountry = app.topNPopulatedCitiesInCountry(country, limit);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInCountry);

        // 16. Get top N populated cities in a district
        ArrayList<City> getTopCitiesInDistrict;
        getTopCitiesInDistrict = app.topNPopulatedCitiesInDistrict(district, limit);
        // Display results
        app.displayTopPopulatedCities(getTopCitiesInDistrict);

        // 17. Get populated capital cities in the world
        ArrayList<City> capitalCitiesInWorld;
        capitalCitiesInWorld = app.populateCapitalCitiesInWorld();
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInWorld);

        // 18. Get populated capital cities in a continent
        ArrayList<City> capitalCitiesInContinent;
        capitalCitiesInContinent = app.populateCapitalCitiesInContinent(continent);
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInContinent);

        // 19. Get populated capital cities in a region
        ArrayList<City> capitalCitiesInRegion;
        capitalCitiesInRegion = app.populatedCapitalCitiesInRegion(region);
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInRegion);

        // 20. Get N populated capital cities in the world in descending order
        ArrayList<City> capitalCitiesInWorldDesc;
        capitalCitiesInWorldDesc = app.topNPopulatedCapitalCityInWorld(limit);
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInWorldDesc);

        // 21. Get N populated capital cities in the continent in descending order
        ArrayList<City> capitalCitiesInContinentDesc;
        capitalCitiesInContinentDesc = app.topNPopulatedCapitalCityInContinent(continent, limit);
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInContinentDesc);

        // 22. Get N populated capital cities in the region in descending order
        ArrayList<City> capitalCitiesInRegionDesc;
        capitalCitiesInRegionDesc = app.topNPopulatedCapitalCityInRegion(region, limit);
        // Display results
        app.displayTopPopulatedCities(capitalCitiesInRegionDesc);

        // 23. Get Population of a continent
        ArrayList<Population> populationOfContinent = app.getPopulationOfContinent();
        // Display results
        type = "Continent";
        app.displayPopulationOfPlace(type, populationOfContinent);

        // 24. Get Population of a region
        ArrayList<Population> populationOfRegion = app.getPopulationOfRegion();
        // Display results
        type = "Region";
        app.displayPopulationOfPlace(type, populationOfRegion);

        // 25. Get Population of a country
        ArrayList<Population> populationOfCountry = app.getPopulationOfCountry();
        // Display results
        type = "Country";
        app.displayPopulationOfPlace(type, populationOfCountry);

        // 26. Get population of the world
        long totalWorld = app.populationOfTheWorld();
        app.displayPopulation("World", totalWorld);

        // 27. Get population of the continent
        long totalContinent = app.populationOfTheContinent(continent);
        app.displayPopulation(continent, totalContinent);

        // 28. Get population of the region
        long totalRegion = app.populationOfTheRegion(region);
        app.displayPopulation(region, totalRegion);

        // 29. Get population of the country
        long totalCountry = app.populationOfTheCountry(country);
        app.displayPopulation(country, totalCountry);

        // 30. Get population of the district
        long totalDistrict = app.populationOfTheDistrict(district);
        app.displayPopulation(district, totalDistrict);

        // 31. Get population of the city
        long totalCity = app.populationOfTheCity(city);
        app.displayPopulation(city, totalCity);

        //32. Sort language by percentage
        Set<Entry<Float, String>> set = app.sortLanguageByPercentage();
        app.displayLanguageSorting(set);

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
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?" +
                        "allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
     * 1. Get top populated countries of the world by large to small
     * @return return an ArrayList of top populated countries in the world
     */
    public ArrayList<Country> worldCountryLargeToSmall()
    {
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital FROM " +
                    "country ORDER BY Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get countries from query
            ArrayList<Country> countries = getCountryFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the world");
            return null;
        }
    }

    /**
     * 2. Get top populated countries of a continent large to small
     * @param continent continent name
     * @return return an ArrayList of top populated countries in that continent
     */
    public ArrayList<Country> continentCountryLargeToSmall(String continent)
    {
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = format(
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE " +
                            "Continent='%s' ORDER BY Population DESC;"
                    , continent);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get countries from query
            ArrayList<Country> countries = getCountryFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries of the continent");
            return null;
        }
    }

    /**
     * 3. Get top populated countries of a region large to small
     * @param region region name
     * @return return an ArrayList of top populated countries in that region
     */
    public ArrayList<Country> regionCountryLargeToSmall(String region)
    {
        try
        {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = format(
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE " +
                            "Region='%s' ORDER BY Population DESC;"
                    , region);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get countries from query
            ArrayList<Country> countries = getCountryFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries of the region");
            return null;
        }
    }

    /**
     * 4. Get certain number of populated countries in the world
     * @param limit number of countries
     * @return return an ArrayList of top populated countries in the world
     */
    public ArrayList<Country> populateCountriesInWorld(int limit){
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = String.format(
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country " +
                            "ORDER BY Population DESC limit %d;"
                    , limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get countries from query
            ArrayList<Country> countries = getCountryFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the continent");
            return null;
        }
    }

    /**
     * 5. Get certain number of populated countries in a continent
     * @param continent continent name
     * @param limit number of countries
     * @return return an ArrayList of top populated countries in the continent
     */
    public ArrayList<Country> populatedCountriesInContinent(String continent, int limit){
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = String.format(
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country " +
                            "WHERE Continent='%s' ORDER BY Population DESC limit %d;"
                    , continent, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get countries from query
            ArrayList<Country> countries = getCountryFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the continent");
            return null;
        }
    }

    /**
     * 6. Get certain number of populated countries in a region
     * @param region region name
     * @param limit number of countries
     * @return return an ArrayList of top populated countries in the region
     */
    public ArrayList<Country> populatedCountriesInRegion(String region, int limit)
    {
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = String.format(
                    "SELECT Code, Name, Continent, Region, Population, Capital FROM country " +
                            "WHERE Region='%s' ORDER BY Population DESC LIMIT %d;"
                    , region, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get countries from query
            ArrayList<Country> countries = getCountryFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the region");
            return null;
        }
    }

    /**
     * 7. Get populated cities in the world in descending order
     * @return return an ArrayList of populated cities in the world
     */
    public ArrayList<City> cityInWorldDesc(){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT * FROM city ORDER by Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the world");
            return null;
        }
    }

    /**
     * 8. Get populated cities in the continent in descending order
     * @param continent name of continent
     * @return return an ArrayList of populated cities in a continent
     */
    public ArrayList<City> cityInContinentDesc(String continent){
        try {
            // sql query
            String getCitiesInContinent = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city INNER JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent='"+ continent +"' ORDER BY city.Population DESC";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(getCitiesInContinent);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the continent");
            return null;
        }
    }

    /**
     * 9. Get populated cities in the region in descending order
     * @param region name of region
     * @return return an ArrayList of populated cities in a region
     */
    public ArrayList<City> cityInRegionDesc(String region){
        try {
            // sql query
            String getCitiesInRegion = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city INNER JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region = '"+ region +"' ORDER BY city.Population DESC;";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(getCitiesInRegion);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the region");
            return null;
        }
    }

    /**
     * 10. Get populated cities in the country in descending order
     * @param country name of country
     * @return return an ArrayList of populated cities in a country
     */
    public ArrayList<City> cityInCountryDesc(String country){
        try {
            // sql query
            String getCitiesInCountry = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city INNER JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Code = '"+ country +"' ORDER BY city.Population DESC;";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(getCitiesInCountry);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the country");
            return null;
        }
    }

    /**
     * 11. Get populated cities in the district in descending order
     * @param district name of district
     * @return return an ArrayList of populated cities in a district
     */
    public ArrayList<City> cityInDistrictDesc(String district){
        try { //To Catch Error
            String getCitiesInDistrict = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city WHERE District= '"+ district +"' ORDER BY Population DESC;";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(getCitiesInDistrict);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the district");
            return null;
        }
    }

    /**
     * 12. Get top populated cities in the world
     * @param limit number of countries
     * @return get an ArrayList of top populated cities
     */
    public ArrayList<City> topNPopulatedCitiesInWorld(int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = format(
                    "SELECT * FROM city order by Population DESC LIMIT %d;"
                    , limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities");
            return null;
        }
    }

    /**
     * 13. Get populated cities in continent
     * @param continent continent name
     * @return return an ArrayList of populated cities in continent
     */
    public ArrayList<City> topNPopulatedCitiesInContinent(String continent, int limit){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country on city.CountryCode = country.Code " +
                            "WHERE country.Continent = '%s' " +
                            "ORDER BY city.Population DESC LIMIT %d;"
                    , continent, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the continent");
            return null;
        }
    }

    /**
     * 14. Get populated cities in region
     * @param region region name
     * @return return an ArrayList of populated cities in region
     */
    public ArrayList<City> topNPopulatedCitiesInRegion(String region, int limit){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country ON city.CountryCode = country.Code " +
                            "WHERE country.Region = '%s' " +
                            "ORDER BY city.Population DESC LIMIT %d;"
                    , region, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated cities of the region");
            return null;
        }
    }

    /**
     * 15. Get top populated cities in a country
     * @param country name of the country
     * @return return an ArrayList of top populated cities in that country
     */
    public ArrayList<City> topNPopulatedCitiesInCountry(String country, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = format(
                    "SELECT city.Id, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country where city.CountryCode = country.Code " +
                            "AND country.Name = '%s' ORDER BY city.Population DESC LIMIT %d;"
                    , country, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities of the country");
            return null;
        }
    }

    /**
     * 16. Get top populated cities in a district
     * @param district name of the district
     * @return return an ArrayList of top populated cities in that district
     */
    public ArrayList<City> topNPopulatedCitiesInDistrict(String district, int limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = format(
                    "SELECT * from city where District='%s' ORDER BY Population DESC LIMIT %d;"
                    , district, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities of the district");
            return null;
        }
    }

    /**
     * 17. Get populated capital cities in the world
     * @return return an ArrayList of top populated capital cities in the world
     */
    public ArrayList<City> populateCapitalCitiesInWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city INNER JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities of the world");
            return null;
        }
    }

    /**
     * 18. Get top populated capital cities in a continent
     * @param continent continent name
     * @return return an ArrayList of top populated capital cities in that continent
     */
    public ArrayList<City> populateCapitalCitiesInContinent(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = String.format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country ON city.ID = country.Capital " +
                            "WHERE country.Continent = '%s' " +
                            "ORDER BY city.Population DESC;"
                    , continent);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities of the continent");
            return null;
        }
    }

    /**
     * 19. Get top populated capital cities in a region
     * @param region region name
     * @return return an ArrayList of top populated capital cities in that country
     */
    public ArrayList<City> populatedCapitalCitiesInRegion(String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM " +
                            "country INNER JOIN city WHERE country.Capital=city.ID AND Region='%s' " +
                            "ORDER BY city.Population DESC;"
                    , region);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities of the region");
            return null;
        }
    }

    /**
     * 20. Get top populated capital cities in world
     * @param limit limit given by user
     * @return return an ArrayList of populated cities in world
     */
    public ArrayList<City> topNPopulatedCapitalCityInWorld(int limit){
        try { //To Catch Error
            // create the java statement
            Statement stmt = con.createStatement();
            String strSelect = "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                    "FROM city INNER JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC LIMIT "+ limit +";";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated capital cities in the world");
            return null;
        }
    }

    /**
     * 21. Get top populated capital cities in continent
     * @param continent continent name
     * @param limit limit given by user
     * @return return an ArrayList of populated cities in a continent
     */
    public ArrayList<City> topNPopulatedCapitalCityInContinent(String continent, int limit){
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = String.format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country ON city.ID = country.Capital " +
                            "WHERE country.Continent = '%s' " +
                            "ORDER BY city.Population DESC LIMIT %d;"
                    , continent, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated capital cities in the continent");
            return null;
        }
    }

    /**
     * 22. Get top populated capital cities in region
     * @param region region name
     * @param limit limit given by user
     * @return return an ArrayList of populated cities in a region
     */
    public ArrayList<City> topNPopulatedCapitalCityInRegion(String region, int limit){
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = String.format(
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country ON city.ID = country.Capital " +
                            "WHERE country.Region = '%s' " +
                            "ORDER BY city.Population DESC LIMIT %d;"
            , region, limit);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            ArrayList<City> cities = getCitiesFromQuery(rset);
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get populated capital cities in the region");
            return null;
        }
    }

    /**
     * 23. Get population of a continent
     * @return return the array of population
     */
    public ArrayList<Population> getPopulationOfContinent()
    {
        ArrayList<String> continentList = new ArrayList<>();
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getContinent = "SELECT DISTINCT continent FROM country;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(getContinent);
            if (!rset.next())
                return null;
            else
            {
                do {
                    continentList.add(rset.getString("continent"));
                } while (rset.next());
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return getPopulation(continentList, "Continent");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population");
            return null;
        }
    }

    /**
     * 24. Get population of region
     * @return return the array of population
     */
    public ArrayList<Population> getPopulationOfRegion()
    {
        ArrayList<String> regionList = new ArrayList<>();
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getRegion = "SELECT DISTINCT region FROM country;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(getRegion);
            if (!rset.next())
                return null;
            else
            {
                do {
                    regionList.add(rset.getString("region"));
                } while (rset.next());
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return getPopulation(regionList, "Region");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population");
            return null;
        }
    }

    /**
     * 25. Get population of a country
     * @return return the array of population
     */
    public ArrayList<Population> getPopulationOfCountry()
    {
        ArrayList<String> countryList = new ArrayList<>();
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getCountry = "SELECT DISTINCT name FROM country;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(getCountry);
            if (!rset.next())
                return null;
            else
            {
                do {
                    countryList.add(rset.getString("name"));
                } while (rset.next());
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return getPopulation(countryList, "Name");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population");
            return null;
        }
    }

    /**
     * 26. Get population of the world
     * @return return population
     */
    public Long populationOfTheWorld(){
        try {
            // sql query
            String query = "SELECT SUM(Population) FROM country;";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(query);
            // iterate through the java ResultSet
            long total = 0;
            while(rset.next()) {
                total = rset.getLong("SUM(Population)");
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error Calculating World Population");
            return null;
        }
    }

    /**
     * 27. Get population of the continent
     * @param continent continent name
     * @return return population
     */
    public Long populationOfTheContinent(String continent) {
        try {
            // sql query
            String query = "SELECT SUM(Population) FROM  country WHERE Continent = '" + continent + "';";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(query);
            // iterate through the java ResultSet
            long total = 0;
            while (rset.next()) {
                total = rset.getLong("SUM(Population)");
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error Calculating Continent Population");
            return null;
        }
    }

    /**
     * 28. Get population of the region
     * @param region region name
     * @return return population
     */
    public Long populationOfTheRegion(String region){
        try { //To Catch Error
            String execute = "SELECT SUM(Population) FROM country WHERE Region= '"+ region +"';";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(execute); //Mysql Command Execution
            long total = 0;
            while (rset.next()) {
                total = rset.getLong("SUM(Population)");
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error Calculating Region Population");
            return null;
        }
    }

    /**
     * 29. Get population of the country
     * @param country country name
     * @return return population
     */
    public Long populationOfTheCountry(String country){
        try { //To Catch Error
            String execute = "SELECT SUM(Population) FROM country WHERE Name= '"+ country +"';";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(execute); //Mysql Command Execution
            long total = 0;
            while (rset.next()) {
                total = rset.getLong("SUM(Population)");
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error Calculating Country Population");
            return null;
        }
    }

    /**
     * 30. Get population of the district
     * @param district district name
     * @return return population
     */
    public Long populationOfTheDistrict(String district){
        try {
            // sql query
            String execute = "SELECT SUM(Population) FROM city where District='"+ district +"';";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(execute); //Mysql Command Execution
            long total = 0;
            while (rset.next()) {
                total = rset.getLong("SUM(Population)");
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error Calculating District Population");
            return null;
        }
    }

    /**
     * 31. Get population of the city
     * @param city city name
     * @return return population
     */
    public Long populationOfTheCity(String city){
        try {
            // sql query
            String execute = "SELECT SUM(Population) FROM city WHERE Name='"+ city +"';";
            // create the java statement
            Statement stmt = con.createStatement();
            // execute the query, and get a java ResultSet
            ResultSet rset = stmt.executeQuery(execute); //Mysql Command Execution
            long total = 0;
            while (rset.next()) {
                total = rset.getLong("SUM(Population)");
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset, stmt);
            // return
            return total;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error Calculating City Population");
            return null;
        }
    }

    /**
     * 32. Sort language by percentage
     * @return return Set
     */
    public Set<Entry<Float, String>> sortLanguageByPercentage()
    {
        String[] languages = new String[]{"Chinese","English", "Hindi", "Spanish", "Arabic"};
        Float[] percentage = new Float[5];
        int i = 0;
        for (String language: languages)
        {
            percentage[i] = getLanguagePercentage(language);
            i++;
        }
        Map<Float, String> languagePercentage = new TreeMap<>(Collections.reverseOrder());
        int j = 0;
        while (j < languages.length)
        {
            languagePercentage.put(percentage[j], languages[j]);
            j++;
        }
        // return
        return languagePercentage.entrySet();
    }

    /**
     * Get Language percentage
     * @param language languages
     * @return return speaking percentage
     */
    public Float getLanguagePercentage(String language)
    {
        try
        {
            long languagePopulation = 0;
            long worldPopulation;
            // Create an SQL statement
            Statement stmt1 = con.createStatement();
            // Create string for SQL statement
            String getPopulation = format(
                    "SELECT country.population, countrylanguage.percentage FROM countrylanguage " +
                            "INNER JOIN country ON country.code=countrylanguage.countrycode " +
                            "WHERE countrylanguage.language='%s';"
                    , language);
            // Execute SQL statement
            ResultSet rset1 = stmt1.executeQuery(getPopulation);
            // Get population
            if (!rset1.next())
                return null;
            else
            {
                long population;
                double percentage;
                long countryPopulation;
                ArrayList<Long> countryPopulationArray = new ArrayList<>();
                do {
                    population = rset1.getLong("population");
                    percentage = rset1.getDouble("percentage");
                    countryPopulation = (long) ((percentage/100)*population);
                    countryPopulationArray.add(countryPopulation);
                } while(rset1.next());
                for (long popul: countryPopulationArray)
                    languagePopulation += popul;
            }
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset1, stmt1);
            // Create an SQL statement
            Statement stmt2 = con.createStatement();
            String getWorldPopulation = "SELECT SUM(Population) FROM country;";
            ResultSet rset2 = stmt2.executeQuery(getWorldPopulation);
            if (!rset2.next())
                return null;
            else
                worldPopulation = rset2.getLong("SUM(Population)");
            // Close ResultSet and Statement
            closeResultSetAndStatement(rset2, stmt2);
            // return
            return ((float) languagePopulation/(float) worldPopulation) * 100;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population");
            return null;
        }
    }

    /**
     * Get population from each country, region, continent
     * @param places list of country, region, continent
     * @param column_name column name such as Name, Region, Continent
     * @return return the array of population
     */
    public ArrayList<Population> getPopulation(ArrayList<String> places, String column_name)
    {
        try
        {
            ArrayList<Population> populationOfPlace = new ArrayList<>();
            // Create an SQL statement
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            for (String place: places)
            {
                // Create string for SQL statement
                String getPopulation = format(
                        "SELECT SUM(Population) FROM country WHERE %s='%s';"
                        , column_name, place);
                // Execute SQL statement
                ResultSet rset1 = stmt1.executeQuery(getPopulation);
                // Return population if valid.
                long population;
                if (!rset1.next())
                    return null;
                else {
                    population = rset1.getLong("SUM(Population)");
                }
                // Close ResultSet and Statement
                closeResultSetAndStatement(rset1, stmt1);
                // Create string for SQL statement
                String getCityPopulation = format(
                        "SELECT SUM(city.Population) FROM city INNER JOIN country WHERE " +
                                "city.CountryCode=country.Code AND country.%s='%s';"
                        , column_name, place);
                // Execute SQL statement
                ResultSet rset2 = stmt2.executeQuery(getCityPopulation);
                // Return population if valid.
                long populationOfCity;
                if (!rset2.next())
                    return null;
                else {
                    populationOfCity = rset2.getLong("SUM(city.Population)");
                }
                // Close ResultSet and Statement
                closeResultSetAndStatement(rset2, stmt2);
                long populationOfNotCity = population - populationOfCity;
                float percentagePopulationInCity = ((float) populationOfCity / (float) population) * 100;
                float percentagePopulationNotInCity = ((float) populationOfNotCity / (float) population) * 100;
                Population pop = new Population();
                pop.name = place;
                pop.population = population;
                pop.populationInCities = populationOfCity;
                pop.populationNotInCities = populationOfNotCity;
                pop.percentagePopulationInCities = percentagePopulationInCity;
                pop.percentagePopulationNotInCities = percentagePopulationNotInCity;
                populationOfPlace.add(pop);
            }
            return populationOfPlace;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population");
            return null;
        }
    }

    /**
     * Get Cities from SQL query
     * @param rset SQL query result
     * @return return an ArrayList containing cities
     * @throws SQLException throws an instance of SQLException
     */
    public ArrayList<City> getCitiesFromQuery(ResultSet rset) throws SQLException
    {
        // Return new city if valid.
        ArrayList<City> cty = new ArrayList<>();
        if (!rset.next())
            return null;
        else
            {
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
     * Get Countries from SQL query
     * @param rset SQL query result
     * @return return an ArrayList containing countries
     * @throws SQLException throws an instance of SQLException
     */
    public ArrayList<Country> getCountryFromQuery(ResultSet rset) throws SQLException
    {
        // Return new country if valid
        ArrayList<Country> country = new ArrayList<>();
        if (!rset.next())
            return  null;
        else {
            do {
                Country ctry = new Country();
                ctry.code = rset.getString("Code");
                ctry.name = rset.getString("Name");
                ctry.continent = rset.getString("Continent");
                ctry.region = rset.getString("Region");
                ctry.population = rset.getLong("Population");
                ctry.capital = rset.getString("Capital");
                country.add(ctry);
            } while (rset.next());
            return country;
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

    /**
     * Display top populated countries
     * @param country ArrayList containing top populated countries
     */
    public void displayTopPopulatedCountries(ArrayList<Country> country)
    {
        if (country != null)
        {
            int i = 1;
            for (Country ctry: country)
            {
                System.out.println(
                        "No: " + i + "\n" +
                                "Code: " + ctry.code + "\n" +
                                "Name: " + ctry.name + "\n" +
                                "Continent: " + ctry.continent + "\n" +
                                "Region: " + ctry.region + "\n" +
                                "Population: " + ctry.population
                );
                i++;
            }
        }
    }

    /**
     * Display population
     * @param type type of place (region, country or continent)
     * @param result array of population
     */
    public  void displayPopulationOfPlace(String type, ArrayList<Population> result)
    {
        if (result != null)
        {
            for (Population population: result)
            {
                System.out.println(
                        type + " Name: " + population.name + "\n" +
                                "Population of "+ type +": " + population.population + "\n" +
                                "Population in Cities: " + population.populationInCities + "\n" +
                                "Percentage Population in Cities: " + population.percentagePopulationInCities + "%\n" +
                                "Population outside Cities: " + population.populationNotInCities + "\n" +
                                "Percentage Population outside Cities: " + population.percentagePopulationNotInCities + "%"
                        );
            }
        }
    }

    /**
     * Display population of world, continent, region, country, district, city
     * @param name world or name of continent, region, country, district, city
     * @param total total population
     */
    public void displayPopulation(String name, long total)
    {
        System.out.format("Total Population of the %s = %s\n", name, total);
    }

    /**
     * Display sorted language with percentage
     * @param set Set containing language and its percentage
     */
    public void displayLanguageSorting(Set<Entry<Float, String>> set)
    {
        for (Object o : set) {
            @SuppressWarnings("unchecked")
            Entry<Float, String> me = (Entry<Float, String>) o;
            System.out.println("Language: " + me.getValue() + "\tPercentage: " + me.getKey() + "%");
        }
    }

    /**
     * Close ResultSet and Statement
     * @param rset ResultSet
     * @param stmt Statement
     * @throws SQLException throws an instance of SQLException
     */
    public void closeResultSetAndStatement(ResultSet rset, Statement stmt) throws SQLException {
        // Close ResultSet and Statement
        rset.close();
        stmt.close();
    }
}