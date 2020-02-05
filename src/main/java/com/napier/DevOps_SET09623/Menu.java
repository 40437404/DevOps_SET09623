package com.napier.DevOps_SET09623;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String line = new String(new char[30]).replace("\0", "=");
    private Scanner input = new Scanner(System.in);
    private String continent;
    private String region;
    private String country;
    private String district;
    private int limit;
    App app = new App();
    public void showMenu() throws IOException {
        String selectMainMenu;
        System.out.println("Population Report");
        System.out.println(line);
        System.out.println("1. View All Countries");
        System.out.println("2. View Top Countries");
        System.out.println("3. View All Cities");
        System.out.println("4. View Top Cities");
        System.out.println("5. View All Capital Cities");
        System.out.println("6. View Top Capital Cities");
        System.out.println("7. Percentage of People Living/Not Living in Cities");
        System.out.println("8. Total Population");
        System.out.println("9. Language");
        System.out.println("0. EXIT");
        System.out.print("> ");
        selectMainMenu = input.next();
        clearScreen();
        switch (selectMainMenu) {
            case "1":
                viewAllCountriesMenu();
                break;
            case "2":
                viewTopCountriesMenu();
                break;
            case "3":
                viewAllCitiesMenu();
                break;
            case "4":
                viewTopCitiesMenu();
                break;
            case "5":
                viewAllCapitalCitiesMenu();
                break;
            case "6":
                viewTopCapitalCitiesMenu();
                break;
            case "7":
                percentageOfPeople();
                break;
            case "0":
                break;
            default:
                errorMessage();
                showMenu();
                break;
        }
        System.exit(0);
    }
    public void viewAllCountriesMenu() throws IOException {
        String selectViewAllCountries;
        System.out.println("View All Countries");
        System.out.println(line);
        System.out.println("1. All Countries in the World");
        System.out.println("2. All Countries in a Continent");
        System.out.println("3. All Countries in a Region");
        System.out.println("0. Back");
        System.out.print("> ");
        selectViewAllCountries = input.next();
        clearScreen();
        switch (selectViewAllCountries) {
            case "1":
                // 1. Get Populated Countries of the world
                ArrayList<Country> getPopulatedCountriesOfWorld;
                getPopulatedCountriesOfWorld = app.worldCountryLargeToSmall();
                // Display results
                app.displayTopPopulatedCountries(getPopulatedCountriesOfWorld);
                break;
            case "2":
                // 2. Get Populated Countries of a continent
                ArrayList<Country> getPopulatedCountriesOfContinent;
                System.out.print("Enter Continent Name: ");
                input.nextLine();
                continent = input.nextLine();
                getPopulatedCountriesOfContinent = app.continentCountryLargeToSmall(continent);
                // Display results
                app.displayTopPopulatedCountries(getPopulatedCountriesOfContinent);
                break;
            case "3":
                // 3. Get Populated Countries of a region
                ArrayList<Country> getPopulatedCountriesOfRegion;
                System.out.print("Enter Region Name: ");
                input.nextLine();
                region = input.nextLine();
                getPopulatedCountriesOfRegion = app.regionCountryLargeToSmall(region);
                // Display results
                app.displayTopPopulatedCountries(getPopulatedCountriesOfRegion);
                break;
            case "0":
                showMenu();
                break;
            default:
                errorMessage();
                viewAllCountriesMenu();
                break;
        }
        goBack();
        viewAllCountriesMenu();
    }
    public void viewTopCountriesMenu() throws IOException {
        String selectViewTopCountries;
        System.out.println("View Top Countries");
        System.out.println(line);
        System.out.println("1. Top Countries in the World");
        System.out.println("2. Top Countries in a Continent");
        System.out.println("3. Top Countries in a Region");
        System.out.println("0. Back");
        System.out.print("> ");
        selectViewTopCountries = input.next();
        clearScreen();
        switch (selectViewTopCountries){
            case "1":
                // 4. Get Populated certain number of Countries in world
                ArrayList<Country> getNPopulatedCountriesInWorld;
                System.out.print("Number of top countries to view: ");
                limit = input.nextInt();
                getNPopulatedCountriesInWorld = app.populateCountriesInWorld(limit);
                // Display results
                app.displayTopPopulatedCountries(getNPopulatedCountriesInWorld);
                break;
            case "2":
                // 5. Get Populated certain number of Countries in continent
                ArrayList<Country> getNPopulatedCountriesInContinent;
                System.out.print("Number of top countries to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Continent Name: ");
                continent = input.nextLine();
                getNPopulatedCountriesInContinent = app.populatedCountriesInContinent(continent, limit);
                // Display results
                app.displayTopPopulatedCountries(getNPopulatedCountriesInContinent);
                break;
            case "3":
                // 6. Get Populated certain number of Countries in region
                ArrayList<Country> getNPopulatedCountriesInRegion;
                System.out.print("Number of top countries to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Region Name: ");
                region = input.nextLine();
                getNPopulatedCountriesInRegion = app.populatedCountriesInRegion(region, limit);
                // Display results
                app.displayTopPopulatedCountries(getNPopulatedCountriesInRegion);
                break;
            case "0":
                showMenu();
                break;
            default:
                errorMessage();
                viewTopCountriesMenu();
                break;
        }
        goBack();
        viewTopCountriesMenu();
    }
    public void viewAllCitiesMenu() throws IOException {
        String selectViewAllCities;
        System.out.println("View All Cities");
        System.out.println(line);
        System.out.println("1. All Cities in the World");
        System.out.println("2. All Cities in a Continent");
        System.out.println("3. All Cities in a Region");
        System.out.println("4. All Cities in a Country");
        System.out.println("5. All Cities in a District");
        System.out.println("0. Back");
        System.out.print("> ");
        selectViewAllCities = input.next();
        clearScreen();
        switch (selectViewAllCities) {
            case "1":
                // 7. Get populated cities in the world
                ArrayList<City> getCitiesInWorld;
                getCitiesInWorld = app.cityInWorldDesc();
                // Display results
                app.displayTopPopulatedCities(getCitiesInWorld);
                break;
            case "2":
                // 8. Get populated cities in the continent
                ArrayList<City> getCitiesInContinent;
                input.nextLine();
                System.out.print("Enter Continent Name: ");
                continent = input.nextLine();
                getCitiesInContinent = app.cityInContinentDesc(continent);
                // Display results
                app.displayTopPopulatedCities(getCitiesInContinent);
                break;
            case "3":
                // 9. Get populated cities in the region
                ArrayList<City> getCitiesInRegion;
                input.nextLine();
                System.out.print("Enter Region Name: ");
                region = input.nextLine();
                getCitiesInRegion = app.cityInRegionDesc(region);
                // Display results
                app.displayTopPopulatedCities(getCitiesInRegion);
                break;
            case "4":
                // 10. Get populated cities in the country
                ArrayList<City> getCitiesInCountry;
                input.nextLine();
                System.out.print("Enter Counter Name: ");
                country = input.nextLine();
                getCitiesInCountry = app.cityInCountryDesc(country);
                // Display results
                app.displayTopPopulatedCities(getCitiesInCountry);
                break;
            case "5":
                // 11. Get populated cities in the district
                ArrayList<City> getCitiesInDistrict;
                input.nextLine();
                System.out.print("Enter District Name: ");
                district = input.nextLine();
                getCitiesInDistrict = app.cityInDistrictDesc(district);
                // Display results
                app.displayTopPopulatedCities(getCitiesInDistrict);
                break;
            case "0":
                showMenu();
                break;
            default:
                errorMessage();
                viewAllCitiesMenu();
                break;
        }
        goBack();
        viewAllCitiesMenu();
    }
    public void viewTopCitiesMenu() throws IOException {
        String selectViewTopCities;
        System.out.println("View Top Cities");
        System.out.println(line);
        System.out.println("1. Top Cities in the World");
        System.out.println("2. Top Cities in a Continent");
        System.out.println("3. Top Cities in a Region");
        System.out.println("4. Top Cities in a Country");
        System.out.println("5. Top Cities in a District");
        System.out.println("0. Back");
        System.out.print("> ");
        selectViewTopCities = input.next();
        clearScreen();
        switch (selectViewTopCities) {
            case "1":
                // 12. Get top N populated cities worldwide
                ArrayList<City> getTopCitiesInWorld;
                System.out.print("Number of top cities to view: ");
                limit = input.nextInt();
                getTopCitiesInWorld = app.topNPopulatedCitiesInWorld(limit);
                // Display results
                app.displayTopPopulatedCities(getTopCitiesInWorld);
                break;
            case "2":
                // 13. Get top N populated cities in a continent
                ArrayList<City> getTopCitiesInContinent;
                System.out.print("Number of top cities to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Continent Name: ");
                continent = input.nextLine();
                getTopCitiesInContinent = app.topNPopulatedCitiesInContinent(continent, limit);
                // Display results
                app.displayTopPopulatedCities(getTopCitiesInContinent);
                break;
            case "3":
                // 14. Get top N populated cities in a region
                ArrayList<City> getTopCitiesInRegion;
                System.out.print("Number of top cities to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Region Name: ");
                region = input.nextLine();
                getTopCitiesInRegion = app.topNPopulatedCitiesInRegion(region, limit);
                // Display results
                app.displayTopPopulatedCities(getTopCitiesInRegion);
                break;
            case "4":
                // 15. Get top N populated cities in a country
                ArrayList<City> getTopCitiesInCountry;
                System.out.print("Number of top cities to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Country Name: ");
                country = input.nextLine();
                getTopCitiesInCountry = app.topNPopulatedCitiesInCountry(country, limit);
                // Display results
                app.displayTopPopulatedCities(getTopCitiesInCountry);
                break;
            case "5":
                // 16. Get top N populated cities in a district
                ArrayList<City> getTopCitiesInDistrict;
                System.out.print("Number of top cities to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter District Name: ");
                district = input.nextLine();
                getTopCitiesInDistrict = app.topNPopulatedCitiesInDistrict(district, limit);
                // Display results
                app.displayTopPopulatedCities(getTopCitiesInDistrict);
                break;
            case "0":
                showMenu();
                break;
            default:
                errorMessage();
                viewTopCitiesMenu();
                break;
        }
        goBack();
        viewTopCitiesMenu();
    }
    public void viewAllCapitalCitiesMenu() throws IOException {
        String selectViewAllCapitalCities;
        System.out.println("View All Capital Cities");
        System.out.println(line);
        System.out.println("1. All Capital Cities in the World");
        System.out.println("2. All Capital Cities in a Continent");
        System.out.println("3. All Capital Cities in a Region");
        System.out.println("0. Back");
        System.out.print("> ");
        selectViewAllCapitalCities = input.next();
        clearScreen();
        switch (selectViewAllCapitalCities) {
            case "1":
                // 17. Get populated capital cities in the world
                ArrayList<City> capitalCitiesInWorld;
                capitalCitiesInWorld = app.populateCapitalCitiesInWorld();
                // Display results
                app.displayTopPopulatedCities(capitalCitiesInWorld);
                break;
            case "2":
                // 18. Get populated capital cities in a continent
                ArrayList<City> capitalCitiesInContinent;
                input.nextLine();
                System.out.print("Enter Continent Name: ");
                continent = input.nextLine();
                capitalCitiesInContinent = app.populateCapitalCitiesInContinent(continent);
                // Display results
                app.displayTopPopulatedCities(capitalCitiesInContinent);
                break;
            case "3":
                // 19. Get populated capital cities in a region
                ArrayList<City> capitalCitiesInRegion;
                input.nextLine();
                System.out.print("Enter Region Name: ");
                region = input.nextLine();
                capitalCitiesInRegion = app.populatedCapitalCitiesInRegion(region);
                // Display results
                app.displayTopPopulatedCities(capitalCitiesInRegion);
                break;
            case "0":
                showMenu();
                break;
            default:
                errorMessage();
                viewAllCapitalCitiesMenu();
                break;
        }
        goBack();
        viewAllCapitalCitiesMenu();
    }
    public void viewTopCapitalCitiesMenu() throws IOException {
        String selectViewTopCapitalCities;
        System.out.println("View Top Capital Cities");
        System.out.println(line);
        System.out.println("1. Top Capital Cities in the World");
        System.out.println("2. Top Capital Cities in a Continent");
        System.out.println("3. Top Capital Cities in a Region");
        System.out.println("0. Back");
        System.out.print("> ");
        selectViewTopCapitalCities = input.next();
        clearScreen();
        switch (selectViewTopCapitalCities) {
            case "1":
                // 20. Get N populated capital cities in the world in descending order
                ArrayList<City> capitalCitiesInWorldDesc;
                System.out.print("Number of top capital cities to view: ");
                limit = input.nextInt();
                capitalCitiesInWorldDesc = app.topNPopulatedCapitalCityInWorld(limit);
                // Display results
                app.displayTopPopulatedCities(capitalCitiesInWorldDesc);
                break;
            case "2":
                // 21. Get N populated capital cities in the continent in descending order
                ArrayList<City> capitalCitiesInContinentDesc;
                System.out.print("Number of top capital cities to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Continent Name: ");
                continent = input.nextLine();
                capitalCitiesInContinentDesc = app.topNPopulatedCapitalCityInContinent(continent, limit);
                // Display results
                app.displayTopPopulatedCities(capitalCitiesInContinentDesc);
                break;
            case "3":
                // 22. Get N populated capital cities in the region in descending order
                ArrayList<City> capitalCitiesInRegionDesc;
                System.out.print("Number of top capital cities to view: ");
                limit = input.nextInt();
                input.nextLine();
                System.out.print("Enter Region Name: ");
                region = input.nextLine();
                capitalCitiesInRegionDesc = app.topNPopulatedCapitalCityInRegion(region, limit);
                // Display results
                app.displayTopPopulatedCities(capitalCitiesInRegionDesc);
                break;
            case "0":
                showMenu();
                break;
            default:
                errorMessage();
                viewTopCapitalCitiesMenu();
                break;
        }
        goBack();
        viewTopCapitalCitiesMenu();
    }
    public void percentageOfPeople() {

    }
    public void clearScreen() {
        try {
            // Get OS Name
            String operatingSystem = System.getProperty("os.name");
            // Check OS
            if (operatingSystem.contains("Windows"))
                // clear screen for windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                //clear screen for linux and mac
                System.out.print("\033[H\033[2J");
        }
        catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
    }
    public void errorMessage() throws IOException {
        System.out.println("Wrong input!!!");
        System.out.println("Press ENTER To Try Again");
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
        input.nextLine();
        input.nextLine();
        clearScreen();
    }
    public void goBack() throws IOException {
        System.out.println("Press ENTER To Go Back");
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
        clearScreen();
    }
}
