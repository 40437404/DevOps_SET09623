package com.napier.DevOps_SET09623;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        getTopCities = app.topPopulatedCities(1);
        for (City city: getTopCities)
        {
            assertEquals(city.id, 1024);
            assertEquals(city.name, "Mumbai (Bombay)");
            assertEquals(city.countryCode, "IND");
            assertEquals(city.district, "Maharashtra");
            assertEquals(city.population, 10500000);
        }
    }
}