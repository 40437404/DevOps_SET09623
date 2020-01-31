package com.napier.DevOps_SET09623;

/**
 * Represents the population of continent/country/region
 */
public class Population {
    private String name;

    private long population;

    private long populationInCities;

    private long populationNotInCities;

    private float percentagePopulationInCities;

    private float percentagePopulationNotInCities;

    /**
     * Name of continent/country/region
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Total population
     */
    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Population of people living in the cities
     */
    public long getPopulationInCities() {
        return populationInCities;
    }

    public void setPopulationInCities(long populationInCities) {
        this.populationInCities = populationInCities;
    }

    /**
     * Population of people living outside the cities
     */
    public long getPopulationNotInCities() {
        return populationNotInCities;
    }

    public void setPopulationNotInCities(long populationNotInCities) {
        this.populationNotInCities = populationNotInCities;
    }

    /**
     * Population percentage of people living in the cities
     */
    public float getPercentagePopulationInCities() {
        return percentagePopulationInCities;
    }

    public void setPercentagePopulationInCities(float percentagePopulationInCities) {
        this.percentagePopulationInCities = percentagePopulationInCities;
    }

    /**
     * Population percentage of people living outside the cities
     */
    public float getPercentagePopulationNotInCities() {
        return percentagePopulationNotInCities;
    }

    public void setPercentagePopulationNotInCities(float percentagePopulationNotInCities) {
        this.percentagePopulationNotInCities = percentagePopulationNotInCities;
    }
}
