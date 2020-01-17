package com.napier.DevOps_SET09623;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.String.format;

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
        // Region name
        String region = "Caribbean";
        // Continent name
        String continent = "Asia";
        // Array of results
        long[] result;
        // Store type of place
        String type;
        // Store name of country, continent or region
        String name;

        // Get top populated cities worldwide
        ArrayList<City> getTopCities;
        getTopCities = app.topPopulatedCities(nCity);
        // Display results
        app.displayTopPopulatedCities(getTopCities);

        // Get top populated cities in a district
        ArrayList<City> getTopCitiesInDistrict;
        getTopCitiesInDistrict = app.populatedCitiesInDistrict(district);
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

        // Get Population of a region
        result = app.getPopulationOfRegion(region);
        // Display results
        type = "Region";
        name = region;
        app.displayPopulationOfPlace(type, name, result);

        // Get Population of a country
        result = app.getPopulationOfCountry(country);
        // Display results
        type = "Country";
        name = country;
        app.displayPopulationOfPlace(type, name, result);

        // Get Population of a continent
        result = app.getPopulationOfContinent(continent);
        // Display results
        type = "Continent";
        name = continent;
        app.displayPopulationOfPlace(type, name, result);

        // Get Populated Countries of a region
        ArrayList<Country> getPopulatedCountriesOfRegion;
        getPopulatedCountriesOfRegion = app.regionCountryLargeToSmall(region);
        // Display results
        app.displayTopPopulatedCountries(getPopulatedCountriesOfRegion);

        // Get Populated Countries of a continent
        ArrayList<Country> getPopulatedCountriesOfContinent;
        getPopulatedCountriesOfContinent = app.continentCountryLargeToSmall(continent);
        // Display results
        app.displayTopPopulatedCountries(getPopulatedCountriesOfContinent);

        // Get Populated Countries of a continent
        ArrayList<Country> getPopulatedCountriesOfWorld;
        getPopulatedCountriesOfWorld = app.worldCountryLargeToSmall();
        // Display results
        app.displayTopPopulatedCountries(getPopulatedCountriesOfWorld);

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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false",
                        "root", "root123!@#");
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
            String strSelect = format(
                    "SELECT * FROM city order by Population DESC LIMIT %d;"
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
    public ArrayList<City> populatedCitiesInDistrict(String district)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = format(
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
            System.out.println("Failed to get top populated cities of the district");
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
            String strSelect = format(
                    "SELECT city.Id, city.Name, city.CountryCode, city.District, city.Population " +
                            "FROM city INNER JOIN country where city.CountryCode = country.Code " +
                            "AND country.Name = '%s' ORDER BY city.Population DESC;"
                    , country);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCitiesFromQuery(rset);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities of the country");
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
            String strSelect = format(
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
            System.out.println("Failed to get top populated cities of the region");
            return null;
        }
    }

    /**
     * Get top populated countries of a region
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
                    "SELECT Code, Name, Continent, Region, Population FROM country WHERE " +
                            "Region='%s' ORDER BY Population DESC;"
                    , region);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCountryFromQuery(rset);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries of the region");
            return null;
        }
    }

    /**
     * Get top populated countries of a continent
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
                    "SELECT Code, Name, Continent, Region, Population FROM country WHERE " +
                            "Continent='%s' ORDER BY Population DESC;"
            , continent);
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCountryFromQuery(rset);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries of the continent");
            return null;
        }
    }

    /**
     * Get top populated countries of the world
     * @return return an ArrayList of top populated countries in the world
     */
    public ArrayList<Country> worldCountryLargeToSmall()
    {
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // sql query
            String strSelect = "SELECT Code, Name, Continent, Region, Population FROM " +
                    "country ORDER BY Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Get cities from query
            return getCountryFromQuery(rset);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the world");
            return null;
        }
    }

    /**
     * Get population of region
     * @param region name of region
     * @return return the array of population
     */
    public long[] getPopulationOfRegion(String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getRegionPopulation = format(
                    "SELECT SUM(Population) FROM country WHERE Region='%s';"
                    , region);
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(getRegionPopulation);
            // Return population if valid.
            long population;
            if (!rset1.next())
                return null;
            else {
                population = rset1.getLong("SUM(Population)");
            }
            // Create string for SQL statement
            String getCityPopulationOfRegion = format(
                    "SELECT SUM(city.Population) FROM city INNER JOIN country WHERE " +
                            "city.CountryCode=country.Code AND country.Region='%s';"
                    , region);
            // Execute SQL statement
            ResultSet rset2 = stmt.executeQuery(getCityPopulationOfRegion);
            // Return population if valid.
            long populationOfCity;
            if (!rset2.next())
                return null;
            else {
                populationOfCity = rset2.getInt("SUM(city.Population)");
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

    /**
     * Get population of a country
     * @param country country name
     * @return return the array of population
     */
    public long[] getPopulationOfCountry(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getCountryPopulation = format(
                    "SELECT Population FROM country WHERE Name='%s';"
                    , country);
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(getCountryPopulation);
            // Return population if valid.
            long population;
            if (!rset1.next())
                return null;
            else {
                population = rset1.getLong("Population");
            }
            // Create string for SQL statement
            String getCityPopulationOfCountry = format(
                    "SELECT SUM(city.Population) FROM city INNER JOIN country WHERE " +
                            "city.CountryCode=country.Code AND country.Name='%s';"
                    , country);
            // Execute SQL statement
            ResultSet rset2 = stmt.executeQuery(getCityPopulationOfCountry);
            // Return population if valid.
            long populationOfCity;
            if (!rset2.next())
                return null;
            else {
                populationOfCity = rset2.getLong("SUM(city.Population)");
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

    /**
     * Get population of a continent
     * @param continent continent name
     * @return return the array of population
     */
    public long[] getPopulationOfContinent(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String getRegionPopulation = format(
                    "SELECT SUM(Population) FROM country WHERE Continent='%s';"
                    , continent);
            // Execute SQL statement
            ResultSet rset1 = stmt.executeQuery(getRegionPopulation);
            // Return population if valid.
            long population;
            if (!rset1.next())
                return null;
            else {
                population = rset1.getLong("SUM(Population)");
            }
            // Create string for SQL statement
            String getCityPopulationOfContinent = format(
                    "SELECT SUM(city.Population) FROM city INNER JOIN country WHERE " +
                            "city.CountryCode=country.Code AND country.Continent='%s';"
                    , continent);
            // Execute SQL statement
            ResultSet rset2 = stmt.executeQuery(getCityPopulationOfContinent);
            // Return population if valid.
            long populationOfCity = 0;
            if (!rset2.next())
                return null;
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
    public void nPopulateCountriesInTheRegion(String Region,int Limit){
        if (con != null)
        {
            try { //To Catch Error
                String execute = "SELECT * FROM country where Region= '"+ Region +"' ORDER BY Population DESC limit "+ Limit +";";
                //Preparing mysql command as a string
                Statement st = con.createStatement(); //Statement Creation
                ResultSet rs = st.executeQuery(execute); //Mysql Command Execution
                while (rs.next()) { //Preparing Output
                    String Code = rs.getString("Code"); //Creating Variable For Country Code
                    String name = rs.getString("Name"); //Creating Variable For Country Name
                    int populationnumber = rs.getInt("Population"); //Creating Variable For Population
                    String region = rs.getString("Region"); //Creating Variable For Continent
                    System.out.format("Code = %s, Name = %s,Population = %s, Region = %s\n", Code, name, populationnumber,region); //Output Statement
                }
                st.close(); //Closing Statement
            } catch (Exception e) {
                e.printStackTrace(); // To Print Out System Error Messages
            }
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
     * @param name name of place
     * @param result array of population
     */
    public  void displayPopulationOfPlace(String type, String name, long[] result)
    {
        if (result != null)
        {
            System.out.println(format(
                    "%s Name: " + name + "\n" +
                            "Population of %s: " + result[0] + "\n" +
                            "Population in Cities: " + result[1] + "\n" +
                            "Population outside Cities: " + result[2]
                    , type, type)
            );
        }
    }
}