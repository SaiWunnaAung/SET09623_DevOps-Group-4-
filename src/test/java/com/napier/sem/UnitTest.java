package com.napier.sem;

import com.napier.sem.model.Population;
import org.junit.jupiter.api.*;

import java.util.ArrayList;


/**
 * This class is for Unit Testing
 */
class UnitTest
{
    // Define report object
    static Report report;

    /**
     *  This method is to run before all test
     */
    @BeforeAll
    static void init()
    {
        // Create report object
        report = new Report();
    }

    /**
     * This method is test method for Population Reports
     */
    @Test
    void uniTestPopulationReport()
    {
        // Create populations Array List
        ArrayList<Population> populations = new ArrayList<Population>();
        /* Create population Object and set data to setter methods*/
        Population population = new Population();
        population.setName("Caribbean");
        population.setPopulation(38140000);
        population.setPopInCity(11067550);
        population.setPopNotInCity(27072450);
        population.setPercentagePopulationInCities(29.01);
        population.setPercentagePopulationNotInCities(70.98);
        // Push population object into populations array list
        populations.add(population);
        // Print population report
        report.populationReportTemplate(populations);
    }

}