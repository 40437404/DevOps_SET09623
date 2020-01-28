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
        app.populateCapitalCitiesInWorld();
    }

    @Test
    void populateCapitalCitiesInWorldTestMany()
    {
        app.topNPopulatedCitiesInWorld(9999);
    }

    @Test
    void populateCapitalCitiesInWorldTestNull()
    {
        app.populateCapitalCitiesInWorld();
    }

    @Test
    void populateCapitalCitiesInWorldTestWrong()
    {
        app.populateCapitalCitiesInWorld();
    }
    //END OF WORLD//
    //*********************************************//

    //REGION STARTS FROM HERE//
    //*********************************************//
    @Test
    void populatedCapitalCitiesInRegionTestZero()
    {
        app.populatedCapitalCitiesInRegion(null);
    }

    @Test
    void populatedCapitalCitiesInRegionTestMany()
    {
        app.populatedCapitalCitiesInRegion("Australia and New Zealand");
    }

    @Test
    void populatedCapitalCitiesInRegionTestNull()
    {
        app.populatedCapitalCitiesInRegion(null);
    }

    @Test
    void populatedCapitalCitiesInRegionTestWrong()
    {
        app.populatedCapitalCitiesInRegion("aaa");
    }
    //  End of Region //
    // *********************************** //

    // Continent Starts From here //
    // *********************************** //
    @Test
    void populateCapitalCitiesInContinentTestZero()
    {
        app.populateCapitalCitiesInContinent(null);
    }

    @Test
    void populateCapitalCitiesInContinentTestMany()
    {
        app.populateCapitalCitiesInContinent("Australia and New Zealand");
    }

    @Test
    void populateCapitalCitiesInContinentTestNull()
    {
        app.populateCapitalCitiesInContinent(null);
    }

    @Test
    void populateCapitalCitiesInContinentTestWrong()
    {
        app.populateCapitalCitiesInContinent("aaa");
    }
    // End Of Continent//
    // *********************************** //

    // DESC //
    // *********************************** //
    @Test
    void capitalCityInRegionDescTestZero()
    {
        app.populatedCapitalCitiesInRegion(null);
    }


    @Test
    void capitalCityInRegionDescTestWrong()
    {
        app.populatedCapitalCitiesInRegion("AAA");
    }
    // END OF DESC //
    // ******************************************* //

    // POPULATION OF REGION //
    // *********************************** //
    @Test
    void getPopulationOfRegionTestZero()
    {
        app.getPopulationOfRegion();
    }

    @Test
    void getPopulationOfRegionTestMany()
    {
        app.getPopulationOfRegion();
    }

    @Test
    void getPopulationOfRegionTestNull()
    {
        app.getPopulationOfRegion();
    }

    @Test
    void getPopulationOfRegionTestWrong()
    {
        app.getPopulationOfRegion();
    }
    // END OF POPULATION OF REGION //
    // ******************************************* //

    // POPULATION OF REGION //
    // *********************************** //
    @Test
    void getPopulationOfCountryTestZero()
    {
        app.getPopulationOfCountry();
    }

    @Test
    void getPopulationOfCountryTestMany()
    {
        app.getPopulationOfCountry();
    }

    @Test
    void getPopulationOfCountryTestNull()
    {
        app.getPopulationOfCountry();
    }

    @Test
    void getPopulationOfCountryTestWrong()
    {
        app.getPopulationOfCountry();
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
        app.getPopulationOfContinent();
    }

    @Test
    void getPopulationOfContinentTestWrong()
    {
        app.getPopulationOfContinent();
    }

    @Test
    void displayPopulationOfPlaceTestNull()
    {
        app.displayPopulationOfPlace(null,null);
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
        app.topNPopulatedCitiesInWorld(0);
    }
    @Test
    void topPopulatedCitiesTestMany()
    {
        app.topNPopulatedCitiesInWorld(9999);
    }
    @Test
    void topPopulatedCitiesTestZero()
    {
        app.topNPopulatedCitiesInWorld(0);
    }
    @Test
    void topPopulatedCitiesTestWrong()
    {
        app.topNPopulatedCitiesInWorld(999999999);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In worldwide________________________




    //__________________________BOBOTUNZAW Top Populated Cities In district______________________
    @Test
    void populatedCitiesInDistrictTestNull()
    {
        app.topNPopulatedCitiesInDistrict(null,1);
    }
    @Test
    void populatedCitiesInDistrictTestMany()
    {
        app.topNPopulatedCitiesInDistrict("Andorra la Vella", 999);
    }
    @Test
    void populatedCitiesInDistrictTestZero()
    {
        app.topNPopulatedCitiesInDistrict("Andorra la Vella", 0);
    }
    @Test
    void populatedCitiesInDistrictTestWrong()
    {
        app.topNPopulatedCitiesInDistrict("superman",2);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In district______________________




    //__________________________BOBOTUNZAW Top Populated Cities In Country______________________
    @Test
    void populatedCitiesInACountryTestNull()
    {
        app.topNPopulatedCitiesInCountry(null,1);
    }
    @Test
    void populatedCitiesInACountryTestMany()
    {
        app.topNPopulatedCitiesInCountry("South Georgia and the South Sandwich Islands", 999);
    }
    @Test
    void populatedCitiesInACountryTestWrong()
    {
        app.topNPopulatedCitiesInCountry("Batman", 1);
    }
    @Test
    void populatedCitiesInACountryTestZero()
    {
        app.topNPopulatedCitiesInCountry("South Georgia", 0);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In Country______________________




    //__________________________BOBOTUNZAW Top Populated Cities In Region______________________
    @Test
    void cityInRegionDescTestNull()
    {
        app.topNPopulatedCitiesInRegion(null, 1);
    }
    @Test
    void cityInRegionDescTestMany()
    {
        app.topNPopulatedCitiesInRegion("Southern and Central Asia", 999);
    }
    @Test
    void cityInRegionDescTestWrong()
    {
        app.topNPopulatedCitiesInRegion("Wonder Woman", 1);
    }
    @Test
    void cityInRegionDescTestZero()
    {
        app.topNPopulatedCitiesInRegion("Central Asia", 0);
    }
    //__________________________BOBOTUNZAW Top Populated Cities In Region______________________




    //__________________________BOBOTUNZAW Top Populated Cities In Continent______________________
    @Test
    void cityInContinentDescTestNull()
    {
        app.topNPopulatedCitiesInDistrict(null, 1);
    }
    @Test
    void cityInContinentDescTestMany()
    {
        app.topNPopulatedCitiesInDistrict("South America", 999);
    }
    @Test
    void cityInContinentDescTestWrong()
    {
        app.topNPopulatedCitiesInDistrict("Flash", 1);
    }
    @Test
    void cityInContinentDescTestZero()
    {
        app.topNPopulatedCitiesInDistrict("South America", 0);
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