package com.napier.DevOps_SET09623;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Testing {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    // 1. Get Populated Countries of the world
    @Test
    void worldCountryLargeToSmallTest() {
        app.worldCountryLargeToSmall();
    }

    // 2. Get Populated Countries of a continent
    @Test
    void continentCountryLargeToSmallTestNull() {
        app.continentCountryLargeToSmall(null);
    }
    @Test
    void continentCountryLargeToSmallTestWrong() {
        app.continentCountryLargeToSmall("AAA");
    }

    // 3. Get Populated Countries of a region
    @Test
    void regionCountryLargeToSmallTestNull() {
        app.regionCountryLargeToSmall(null);
    }

    // 4. Get Populated certain number of Countries of world
    @Test
    void populateCountriesInWorldTestNull() {
        app.populateCountriesInWorld(0);
    }
    @Test
    void populateCountriesInWorldTestWrong() {
        app.populateCountriesInWorld(999);
    }

    // 5. Get Populated certain number of Countries of a continent
    @Test
    void populatedCountriesInContinentTestWrong() {
        app.populatedCountriesInContinent("AAA", 999);
    }

    // 6. Get Populated certain number of Countries of a region
    @Test
    void populatedCountriesInRegionTestNull() {
        app.populatedCountriesInRegion(null, 0);
    }

    // 7. Get populated cities in the world
    @Test
    void cityInWorldDescTest() {
        app.cityInWorldDesc();
    }

    // 8. Get populated cities in the continent
    @Test
    void cityInContinentDescTestNull() {
        app.topNPopulatedCitiesInDistrict(null, 1);
    }
    @Test
    void cityInContinentDescTestMany() {
        app.topNPopulatedCitiesInDistrict("South America", 999);
    }
    @Test
    void cityInContinentDescTestWrong() {
        app.topNPopulatedCitiesInDistrict("Flash", 1);
    }
    @Test
    void cityInContinentDescTestZero() {
        app.topNPopulatedCitiesInDistrict("South America", 0);
    }

    // 9. Get populated cities in the region
    @Test
    void capitalCityInRegionDescTestZero() {
        app.populatedCapitalCitiesInRegion(null);
    }
    @Test
    void capitalCityInRegionDescTestWrong() {
        app.populatedCapitalCitiesInRegion("AAA");
    }

    // 10. Get populated cities in the country
    @Test
    void cityInCountryDescTestNull(){
        app.cityInCountryDesc(null);
    }
    @Test
    void cityInCountryDescTestWrong(){
        app.cityInCountryDesc("AAA");
    }

    // 11. Get populated cities in the district
    @Test
    void cityInDistrictDescTestNull(){
        app.cityInDistrictDesc(null);
    }
    @Test
    void cityInDistrictDescTestWrong(){
        app.cityInDistrictDesc("AAA");
    }

    // 12. Get top N populated cities worldwide
    @Test
    void topPopulatedCitiesTestNull() {
        app.topNPopulatedCitiesInWorld(0);
    }
    @Test
    void topPopulatedCitiesTestMany() {
        app.topNPopulatedCitiesInWorld(9999);
    }

    // 13. Get top N populated cities in a continent
    @Test
    void topNPopulatedCitiesInContinentTestNull(){
        app.topNPopulatedCitiesInContinent(null,0);
    }
    @Test
    void topNPopulatedCitiesInContinentTestWrong(){
        app.topNPopulatedCitiesInContinent("AAA", 99999);
    }

    // 14. Get top N populated cities in a region
    @Test
    void cityInRegionDescTestNull() {
        app.topNPopulatedCitiesInRegion(null, 1);
    }
    @Test
    void cityInRegionDescTestMany() {
        app.topNPopulatedCitiesInRegion("Southern and Central Asia", 999);
    }
    @Test
    void cityInRegionDescTestWrong() {
        app.topNPopulatedCitiesInRegion("Wonder Woman", 1);
    }
    @Test
    void cityInRegionDescTestZero() {
        app.topNPopulatedCitiesInRegion("Central Asia", 0);
    }

    // 15. Get top N populated cities in a country
    @Test
    void populatedCitiesInACountryTestNull() {
        app.topNPopulatedCitiesInCountry(null, 1);
    }
    @Test
    void populatedCitiesInACountryTestMany() {
        app.topNPopulatedCitiesInCountry("South Georgia and the South Sandwich Islands", 999);
    }
    @Test
    void populatedCitiesInACountryTestWrong() {
        app.topNPopulatedCitiesInCountry("Batman", 1);
    }
    @Test
    void populatedCitiesInACountryTestZero() {
        app.topNPopulatedCitiesInCountry("South Georgia", 0);
    }

    // 16. Get top N populated cities in a district
    @Test
    void populatedCitiesInDistrictTestNull() {
        app.topNPopulatedCitiesInDistrict(null, 1);
    }
    @Test
    void populatedCitiesInDistrictTestMany() {
        app.topNPopulatedCitiesInDistrict("Andorra la Vella", 999);
    }
    @Test
    void populatedCitiesInDistrictTestZero() {
        app.topNPopulatedCitiesInDistrict("Andorra la Vella", 0);
    }
    @Test
    void populatedCitiesInDistrictTestWrong() {
        app.topNPopulatedCitiesInDistrict("superman", 2);
    }

    // 17. Get populated capital cities in the world
    @Test
    void populateCapitalCitiesInWorldTest() {
        app.populateCapitalCitiesInWorld();
    }

    // 18. Get populated capital cities in a continent
    @Test
    void populateCapitalCitiesInContinentTestZero() {
        app.populateCapitalCitiesInContinent(null);
    }
    @Test
    void populateCapitalCitiesInContinentTestMany() {
        app.populateCapitalCitiesInContinent("Australia and New Zealand");
    }
    @Test
    void populateCapitalCitiesInContinentTestNull() {
        app.populateCapitalCitiesInContinent(null);
    }
    @Test
    void populateCapitalCitiesInContinentTestWrong() {
        app.populateCapitalCitiesInContinent("aaa");
    }

    // 19. Get populated capital cities in a region
    @Test
    void populatedCapitalCitiesInRegionTestZero() {
        app.populatedCapitalCitiesInRegion(null);
    }
    @Test
    void populatedCapitalCitiesInRegionTestMany() {
        app.populatedCapitalCitiesInRegion("Australia and New Zealand");
    }
    @Test
    void populatedCapitalCitiesInRegionTestNull() {
        app.populatedCapitalCitiesInRegion(null);
    }
    @Test
    void populatedCapitalCitiesInRegionTestWrong() {
        app.populatedCapitalCitiesInRegion("aaa");
    }

    // 20. Get N populated capital cities in the world
    @Test
    void topNPopulatedCapitalCityInWorldTestNull(){
        app.topNPopulatedCapitalCityInWorld(0);
    }
    @Test
    void topNPopulatedCapitalCityInWorldTestMany(){
        app.topNPopulatedCapitalCityInWorld(9999);
    }

    // 21. Get N populated capital cities in the continent
    @Test
    void topNPopulatedCapitalCityInContinentTestNull(){
        app.topNPopulatedCapitalCityInContinent(null, 0);
    }
    @Test
    void topNPopulatedCapitalCityInContinentTestWrong(){
        app.topNPopulatedCapitalCityInContinent("AAA",0);
    }
    @Test
    void topNPopulatedCapitalCityInContinentTestMany(){
        app.topNPopulatedCapitalCityInContinent("BBBB", 99999);
    }

    // 22. Get N populated capital cities in the region
    @Test
    void topNPopulatedCapitalCityInRegionTestNull(){
        app.topNPopulatedCapitalCityInRegion(null, 0);
    }
    @Test
    void topNPopulatedCapitalCityInRegionTestWrong(){
        app.topNPopulatedCapitalCityInRegion("AAA", 0);
    }
    @Test
    void topNPopulatedCapitalCityInRegionTestMany(){
        app.topNPopulatedCapitalCityInRegion("AAA", 99999);
    }

    // 23. Get Population of a continent
    @Test
    void getPopulationOfContinentTest() {
        app.getPopulationOfContinent();
    }

    // 24. Get Population of a region
    @Test
    void getPopulationOfRegionTest() {
        app.getPopulationOfRegion();
    }

    // 25. Get Population of a country
    @Test
    void getPopulationOfCountryTest() {
        app.getPopulationOfCountry();
    }

    // 26. Get population of the world
    @Test
    void populationOfTheWorldTest(){
        app.populationOfTheWorld();
    }

    // 27. Get population of the continent
    @Test
    void populationOfTheContinentTestNull(){
        app.populationOfTheContinent(null);
    }
    @Test
    void populationOfTheContinentTestWrong(){
        app.populationOfTheContinent("AAA");
    }

    // 28. Get population of the region
    @Test
    void populationOfTheRegionTestNull(){
        app.populationOfTheRegion(null);
    }
    @Test
    void populationOfTheRegionTestWrong(){
        app.populationOfTheRegion("AAAA");
    }

    // 29. Get population of the country
    @Test
    void populationOfTheCountryTestNull(){
        app.populationOfTheCountry(null);
    }
    @Test
    void populationOfTheCountryTestWrong(){
        app.populationOfTheCountry("AAA");
    }

    // 30. Get population of the district
    @Test
    void populationOfTheDistrictTestNull(){
        app.populationOfTheDistrict(null);
    }
    @Test
    void populationOfTheDistrictTestWrong(){
        app.populationOfTheDistrict("AAA");
    }

    // 31. Get population of the city
    @Test
    void populationOfTheCityTestNull(){
        app.populationOfTheCity(null);
    }
    @Test
    void populationOfTheCityTestWrong(){
        app.populationOfTheCity("AAA");
    }

    // Get Language percentage
    @Test
    void getLanguagePercentageTestNull(){app.getLanguagePercentage(null);}
    @Test
    void getLanguagePercentageTestWrong(){app.getLanguagePercentage("Burmese");}

    // Get population from each country, region, continent
    @Test
    void getPopulationTestNull(){app.getPopulation(null, null);}
    // Create test ArrayList with random values
    ArrayList<String> places = new ArrayList<>(Arrays. asList("London", "Tokyo", "New York"));
    @Test
    void getPopulationTestWrong(){app.getPopulation(places, "testing");}

    // test query string
    String testQueryNull = null;
    String testQueryCity = "SELECT * FROM city;";
    String testQueryCountry = "SELECT * FROM country;";
    // Get Countries from SQL query
    @Test
    void getCitiesFromQueryTestNull() {app.getCitiesFromQuery(testQueryNull);}
    @Test
    void getCitiesFromQueryTestWrong() {app.getCitiesFromQuery(testQueryCity);}

    // Get Countries from SQL query
    @Test
    void getCountryFromQueryTestNull() {app.getCountryFromQuery(testQueryNull);}
    @Test
    void getCountryFromQueryTestWrong() {app.getCountryFromQuery(testQueryCountry);}

    // Display Top Populated Cities
    @Test
    void displayTopPopulatedCitiesTestNull() {
        ArrayList<City> city = new ArrayList<>();
        app.displayTopPopulatedCities(city);
    }
    @Test
    void displayTopPopulatedCitiesTest() {
        ArrayList<City> city = new ArrayList<>();
        City cty = new City();
        cty.setId(1);
        cty.setName("Yangon");
        cty.setCountryName("MMR");
        cty.setDistrict("Yangon");
        cty.setPopulation(2345678);
        city.add(cty);
        app.displayTopPopulatedCities(city);
    }

    // Display Top Populated Countries
    @Test
    void displayTopPopulatedCountriesTestNull() {
        ArrayList<Country> cty = new ArrayList<>();
        app.displayTopPopulatedCountries(cty);
    }
    @Test
    void displayTopPopulatedCountriesTestDisplay() {
        ArrayList<Country> cty = new ArrayList<>();
        Country ctry = new Country();
        ctry.setCode("AA");
        ctry.setName("Yangon");
        ctry.setContinent("Asia");
        ctry.setRegion("West");
        ctry.setPopulation(43636363);
        cty.add(ctry);
        app.displayTopPopulatedCountries(cty);
    }

    // Display population
    @Test
    void displayPopulationOfPlaceTestNull() {
        ArrayList<Population> result = new ArrayList<>();
        app.displayPopulationOfPlace(null, result);
    }
    @Test
    void displayPopulationOfPlaceTestDisplay() {
        ArrayList<Population> result = new ArrayList<>();
        Population population = new Population();
        population.setName("Myanmar");
        population.setPopulation(1234567);
        population.setPopulationInCities(1234);
        population.setPopulationNotInCities(456);
        population.setPercentagePopulationInCities((float) 12.01);
        population.setPercentagePopulationNotInCities((float) 23.0);
        result.add(population);
        app.displayPopulationOfPlace("Country", result);
    }

    // Display population of world, continent, region, country, district, city
    @Test
    void displayPopulationTestNull() {app.displayPopulation(null, 0);}

    // Display sorted language with percentage
    Set<Map.Entry<Float, String>> setNull;
    @Test
    void displayLanguageSortingTestNull() {app.displayLanguageSorting(setNull);}
}