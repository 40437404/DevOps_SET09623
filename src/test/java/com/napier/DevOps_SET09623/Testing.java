// 40437538@live.napier.ac.uk KYAW ZAW LWIN
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
}
// 40437538@live.napier.ac.uk KYAW ZAW LWIN