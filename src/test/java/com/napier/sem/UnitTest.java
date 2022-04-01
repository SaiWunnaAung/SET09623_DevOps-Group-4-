package com.napier.sem;

import com.napier.sem.model.CapitalCity;
import com.napier.sem.model.City;
import com.napier.sem.model.Country;
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
     * This method is test method for City Reports
     */
    @Test
    void uniTestCityReport()
    {
        // Create cities Array List
        ArrayList<City> cities = new ArrayList<City>();
        /* Create city Object and set data to setter methods*/
        City city = new City();
        city.setName("Tokyo");
        city.setCountry("Japan");
        city.setDistrict("Tokyo-to");
        city.setPopulation(7980230);
        // Push city object into cities array list
        cities.add(city);
        // Print city report
        report.cityReportTemplate(cities);
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