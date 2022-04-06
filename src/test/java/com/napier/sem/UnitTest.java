package com.napier.sem;

import com.napier.sem.model.CapitalCity;
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
     * This method is test method for Capital City Reports
     */
    @Test
    void uniTestCapitalCityReport()
    {
        // Create capitalCities Array List
        ArrayList<CapitalCity> capitalCities = new ArrayList<CapitalCity>();
        /* Create capitalCity Object and set data to setter methods*/
        CapitalCity capitalCity = new CapitalCity();
        capitalCity.setName("Tokyo");
        capitalCity.setCountry("Japan");
        capitalCity.setPopulation(7980230);
        // Push capitalCity object into capitalCities array list
        capitalCities.add(capitalCity);
        // Print capitalCity report
        report.capitalCityReportTemplate(capitalCities);
    }


}