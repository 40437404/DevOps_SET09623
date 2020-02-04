package com.napier.DevOps_SET09623;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testTopPopulatedCities()
    {
        ArrayList<City> getTopCities;
        getTopCities = app.topNPopulatedCitiesInWorld(1);
        for (City city: getTopCities)
        {
            assertEquals(city.getId(), 1024, "City ID");
            assertEquals(city.getName(), "Mumbai (Bombay)", "City Name");
            assertEquals(city.getCountryName(), "India", "Country Name");
            assertEquals(city.getDistrict(), "Maharashtra", "District Name");
            assertEquals(city.getPopulation(), 10500000, "Population");
        }
    }
}