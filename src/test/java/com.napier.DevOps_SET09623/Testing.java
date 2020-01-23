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



    //____________BOBOTUNZAW Top Populated cities in worldwide________________________
    @Test
    void topPopulatedCitiesTestNull()
    {
       app.topPopulatedCities(0);
    }
    @Test
    void topPopulatedCitiesTestMany()
    {
        app.topPopulatedCities(9999);
    }
    @Test
    void topPopulatedCitiesTestZero()
    {
        app.topPopulatedCities(0);
    }
    @Test
    void topPopulatedCitiesTestWrong()
    {
        app.topPopulatedCities(999999999);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In worldwide________________________




    //__________________________BOBOTUNZAW Top Populated Cities In district______________________
    @Test
    void populatedCitiesInDistrictTestNull()
    {
        app.populatedCitiesInDistrict(null);
    }
    @Test
    void populatedCitiesInDistrictTestMany()
    {
        app.populatedCitiesInDistrict("Andorra la Vella");
    }
    @Test
    void populatedCitiesInDistrictTestZero()
    {
        app.populatedCitiesInDistrict(null);
    }
    @Test
    void populatedCitiesInDistrictTestWrong()
    {
        app.populatedCitiesInDistrict("superman");
    }
    //__________________________BOBOTUNZAW Top Populated Cities In district______________________




    //__________________________BOBOTUNZAW Top Populated Cities In Country______________________
    @Test
    void populatedCitiesInACountryTestNull()
    {
        app.populatedCitiesInACountry(null);
    }
    @Test
    void populatedCitiesInACountryTestMany()
    {
        app.populatedCitiesInACountry("South Georgia and the South Sandwich Islands");
    }
    @Test
    void populatedCitiesInACountryTestWrong()
    {
        app.populatedCitiesInACountry("Batman");
    }
    @Test
    void populatedCitiesInACountryTestZero()
    {
        app.populatedCitiesInACountry(null);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In Country______________________




    //__________________________BOBOTUNZAW Top Populated Cities In Region______________________
    @Test
    void cityInRegionDescTestNull()
    {
        app.cityInRegionDesc(null);
    }
    @Test
    void cityInRegionDescTestMany()
    {
        app.cityInRegionDesc("Southern and Central Asia");
    }
    @Test
    void cityInRegionDescTestWrong()
    {
        app.cityInRegionDesc("Wonder Woman");
    }
    @Test
    void cityInRegionDescTestZero()
    {
        app.cityInRegionDesc(null);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In Region______________________




    //__________________________BOBOTUNZAW Top Populated Cities In Continent______________________
    @Test
    void cityInContinentDescTestNull()
    {
        app.cityInContinentDesc(null);
    }
    @Test
    void cityInContinentDescTestMany()
    {
        app.cityInContinentDesc("South America");
    }
    @Test
    void cityInContinentDescTestWrong()
    {
        app.cityInContinentDesc("Flash");
    }
    @Test
    void cityInContinentDescTestZero()
    {
        app.cityInContinentDesc(null);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In Continent______________________




    //__________________________BOBOTUNZAW Top Populated Cities In World______________________
    @Test
    void cityInWorldDescTestNull()
    {
        app.cityInWorldDesc();
    }
    @Test
    void cityInWorldDescTestMany()
    {
        app.cityInWorldDesc();
    }
    @Test
    void cityInWorldDescTestWrong()
    {
        app.cityInWorldDesc();
    }
    @Test
    void cityInWorldDescTestZero()
    {
        app.cityInWorldDesc();
    }


    //__________________________BOBOTUNZAW Top Populated Cities In World______________________
}
