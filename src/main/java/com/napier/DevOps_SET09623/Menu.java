package com.napier.DevOps_SET09623;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private String line = new String(new char[30]).replace("\0", "=");
    private Scanner input = new Scanner(System.in);
    private String continent;
    private String region;
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
//            case 3:
//                //
//                break;
//            case 4:
//                //
//                break;
//            case 5:
//                //
//                break;
//            case 6:
//                //
//                break;
//            case 7:
//                //
//                break;
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
        System.out.println("4. Back");
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
            case "4":
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
        System.out.println("1. All Countries in the World");
        System.out.println("2. All Countries in a Continent");
        System.out.println("3. All Countries in a Region");
        System.out.println("4. Back");
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
            case "4":
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
