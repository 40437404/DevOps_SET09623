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
    void populateCapitalCitiesInWorldTestZero()
    {
        app.populateCapitalCitiesInWorld(0);
    }

    @Test
    void populateCapitalCitiesInWorldTestMany()
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
}