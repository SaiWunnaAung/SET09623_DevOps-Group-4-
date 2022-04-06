package com.napier.sem;

import com.napier.sem.model.Country;
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
     * This method is test method for City Reports
     */
    @Test
    void uniTestCountryReport()
    {
        // Create countries Array List
        ArrayList<Country> countries = new ArrayList<Country>();
        /* Create Country Object and set data to setter methods*/
        Country country = new Country();
        country.setCode("CHN");
        country.setName("China");
        country.setContinent("Asia");
        country.setRegion("Eastern Asia");
        country.setPopulation(1277558000);
        country.setCapital("Peking");
        // Push country object into countries array list
        countries.add(country);
        // Print country report
        report.countryReportTemplate(countries);
    }

}