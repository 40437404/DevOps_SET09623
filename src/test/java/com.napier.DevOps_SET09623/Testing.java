package com.napier.DevOps_SET09623;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Testing
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void topPopulatedCitiesTestZero()
    {
        app.topPopulatedCities(0);
    }

    @Test
    void topPopulatedCitiesTestMany()
    {
        app.topPopulatedCities(9999);
    }

    @Test
    void populatedCapitalCitiesInRegionTestNull()
    {
        app.populatedCapitalCitiesInRegion(null, 0);
    }

    @Test
    void populatedCapitalCitiesInRegionTestWrong()
    {
        app.populatedCapitalCitiesInRegion("AAA", 0);
    }



    @Test
    void displayTopPopulatedCitiesTestNull()
    {
        ArrayList<City> city = new ArrayList<>();
        app.displayTopPopulatedCities(city);
    }

    @Test
    void displayTopPopulatedCitiesTest()
    {
        ArrayList<City> city = new ArrayList<>();
        City cty = new City();
        cty.id = 1;
        cty.name = "Yangon";
        cty.countryCode = "MMR";
        cty.district = "Yangon";
        cty.population = 2345678;
        city.add(cty);
        app.displayTopPopulatedCities(city);
    }

    // Zabu Kyaw Start
    @Test
    void getPopulationOfContinentTestNull()
    {
        app.getPopulationOfContinent(null);
    }

    @Test
    void getPopulationOfContinentTestWrong()
    {
        app.getPopulationOfContinent("AAA");
    }

    @Test
    void displayPopulationOfPlaceTestNull()
    {
        app.displayPopulationOfPlace(null,null,null);
    }

    @Test
    void regionCountryLargeToSmallTestNull()
    {
        app.regionCountryLargeToSmall(null);
    }

    @Test
    void displayTopPopulatedCountriesTestDisplay()
    {
        ArrayList<Country> cty = new ArrayList<>();
        Country ctry = new Country();
        ctry.code = "AA";
        ctry.name = "Yangon";
        ctry.continent = "Asia";
        ctry.region = "West";
        ctry.population = 43636363;
        cty.add(ctry);
        app.displayTopPopulatedCountries(cty);
    }

    @Test
    void continentCountryLargeToSmallTestNull()
    {
        app.continentCountryLargeToSmall(null);
    }

    @Test
    void continentCountryLargeToSmallTestWrong()
    {
        app.continentCountryLargeToSmall("AAA");
    }

    @Test
    void worldCountryLargeToSmallTestNull()
    {
        app.worldCountryLargeToSmall();
    }

    @Test
    void populatedCountriesInRegionTestNull()
    {
        app.populatedCountriesInRegion(null,0);
    }

   @Test
    void populatedCountriesInContinentTestWrong()
   {
       app.populatedCountriesInContinent("AAA",999);
   }

   @Test
    void populateCountriesInWorldTestNull()
   {
       app.populateCountriesInWorld(0);
   }

   @Test
    void populateCountriesInWorldTestWrong()
   {
       app.populateCountriesInWorld(999);
   }

    // Zabu Kyaw End
}