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
     * This method is test method for Additional Reports
     */
    @Test
    void uniTestAdditionalReport()
    {
        // Create populations Array List
        ArrayList<Population> populations = new ArrayList<Population>();
        /* Create population Object and set data to setter methods*/
        Population population = new Population();
        population.setName("World Population");
        population.setPopulation(6078749450L);
        // Push population object into populations array list
        populations.add(population);
        // Print population report
        report.simplePopulationReportTemplate(populations);
    }

    /**
     * This method is test method for Language Reports
     */
    @Test
    void uniTestLanguageReport()
    {
        // Create populations Array List
        ArrayList<Population> populations = new ArrayList<Population>();
        /* Create population Object and set data to setter methods*/
        Population population = new Population();
        population.setName("Chinese");
        population.setPopulation(119184353922L);
        population.setPercentagePopulationInCities(19.60);
        // Push population object into populations array list
        populations.add(population);
        // Print population report
        report.advancePopulationReportTemplate(populations);
    }


}