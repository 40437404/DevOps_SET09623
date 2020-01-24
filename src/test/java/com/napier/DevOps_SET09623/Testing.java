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
    // Kyaw zaw lwin start
    // World Starts from here//
    // *********************************** //
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
    void populateCapitalCitiesInWorldTestNull()
    {
        app.populateCapitalCitiesInWorld(0);
    }

    @Test
    void populateCapitalCitiesInWorldTestWrong()
    {
        app.populateCapitalCitiesInWorld(999999999);
    }
    //END OF WORLD//
    //*********************************************//

    //REGION STARTS FROM HERE//
    //*********************************************//
    @Test
    void populatedCapitalCitiesInRegionTestZero()
    {
        app.populatedCapitalCitiesInRegion(null,0);
    }

    @Test
    void populatedCapitalCitiesInRegionTestMany()
    {
        app.populatedCapitalCitiesInRegion("Australia and New Zealand", 100);
    }

    @Test
    void populatedCapitalCitiesInRegionTestNull()
    {
        app.populatedCapitalCitiesInRegion(null,0);
    }

    @Test
    void populatedCapitalCitiesInRegionTestWrong()
    {
        app.populatedCapitalCitiesInRegion("aaa",999999999);
    }
    //  End of Region //
    // *********************************** //

    // Continent Starts From here //
    // *********************************** //
    @Test
    void populateCapitalCitiesInContinentTestZero()
    {
        app.populateCapitalCitiesInContinent(null,0);
    }

    @Test
    void populateCapitalCitiesInContinentTestMany()
    {
        app.populateCapitalCitiesInContinent("Australia and New Zealand", 100);
    }

    @Test
    void populateCapitalCitiesInContinentTestNull()
    {
        app.populateCapitalCitiesInContinent(null,0);
    }

    @Test
    void populateCapitalCitiesInContinentTestWrong()
    {
        app.populateCapitalCitiesInContinent("aaa",999999999);
    }
    // End Of Continent//
    // *********************************** //

    // DESC //
    // *********************************** //
    @Test
    void capitalCityInRegionDescTestZero()
    {
        app.capitalCityInRegionDesc(null);
    }

    @Test
    void capitalCityInRegionDescTestMany()
    {
        app.capitalCityInRegionDesc("Australia and New Zealand");
    }

    @Test
    void capitalCityInRegionDescTestNull()
    {
        app.capitalCityInRegionDesc(null);
    }

    @Test
    void capitalCityInRegionDescTestWrong()
    {
        app.capitalCityInRegionDesc("AAA");
    }
    // END OF DESC //
    // ******************************************* //

    // POPULATION OF REGION //
    // *********************************** //
    @Test
    void getPopulationOfRegionTestZero()
    {
        app.getPopulationOfRegion(null);
    }

    @Test
    void getPopulationOfRegionTestMany()
    {
        app.getPopulationOfRegion("Australia and New Zealand");
    }

    @Test
    void getPopulationOfRegionTestNull()
    {
        app.getPopulationOfRegion(null);
    }

    @Test
    void getPopulationOfRegionTestWrong()
    {
        app.getPopulationOfRegion("AAA");
    }
    // END OF POPULATION OF REGION //
    // ******************************************* //

    // POPULATION OF REGION //
    // *********************************** //
    @Test
    void getPopulationOfCountryTestZero()
    {
        app.getPopulationOfCountry(null);
    }

    @Test
    void getPopulationOfCountryTestMany()
    {
        app.getPopulationOfCountry("Congo, The Democratic Republic of the");
    }

    @Test
    void getPopulationOfCountryTestNull()
    {
        app.getPopulationOfCountry(null);
    }

    @Test
    void getPopulationOfCountryTestWrong()
    {
        app.getPopulationOfCountry("AAA");
    }
    // END OF POPULATION OF REGION //
    // ******************************************* //
    // kyaw zaw lwin end


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