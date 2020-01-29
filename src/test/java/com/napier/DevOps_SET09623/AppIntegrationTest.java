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
            assertEquals(city.id, 1024);
            assertEquals(city.name, "Mumbai (Bombay)");
            assertEquals(city.countryName, "India");
            assertEquals(city.district, "Maharashtra");
            assertEquals(city.population, 10500000);
        }
    }
}