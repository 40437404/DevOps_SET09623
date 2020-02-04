package com.napier.DevOps_SET09623;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static String line = new String(new char[30]).replace("\0", "=");
    private static Scanner input = new Scanner(System.in);
    private boolean check = false;
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
//            case 2:
//                //
//                break;
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
        do {
            System.out.println("View All Countries");
            System.out.println(line);
            System.out.println("1. All Countries in the World");
            System.out.println("2. All Countries in a Continent");
            System.out.println("3. All Countries in a Region");
            System.out.println("4. Back");
            selectViewAllCountries = input.next();
            check = checkInt(selectViewAllCountries);
        } while (!check);
        clearScreen();
        switch (selectViewAllCountries) {
            case "1":
                // 1. Get Populated Countries of the world
                ArrayList<Country> getPopulatedCountriesOfWorld;
                getPopulatedCountriesOfWorld = app.worldCountryLargeToSmall();
                // Display results
                app.displayTopPopulatedCountries(getPopulatedCountriesOfWorld);
                break;
//            case 2:
//                //
//                break;
//            case 3:
//                //
//                break;
            case "4":
                showMenu();
                break;
            default:
                errorMessage();
                viewAllCountriesMenu();
                break;
        }
        System.out.println("Press ENTER To Go Back");
        pressEnter();
        viewAllCountriesMenu();
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
    public boolean checkInt(String input) throws IOException {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (Exception e) {
            clearScreen();
            errorMessage();
            return false;
        }
    }
    public void errorMessage() throws IOException {
        System.out.println("Wrong input!!!");
        System.out.println("Press ENTER To Try Again");
        pressEnter();
    }
    public void pressEnter() throws IOException {
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
        clearScreen();
    }
}
