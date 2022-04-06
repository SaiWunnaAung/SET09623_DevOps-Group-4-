package com.napier.sem;

import com.napier.sem.model.CapitalCity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class is for Integration Testing
 */
public class AppIntegrationTest {
    // Define Report object
    static Report report;
    // Define DatabaseConnection object
    static DatabaseConnection db;

    /**
     * This method is to run before all integration tests
     * @throws ClassNotFoundException
     * @throws InterruptedException
     * @throws SQLException
     */
    @BeforeAll
    static void init() throws ClassNotFoundException, InterruptedException, SQLException
    {
        // Create report object
        report = new Report();
        // Create database connection Instance
        db = DatabaseConnection.Instance();
        // Connect to the database
        db.connect("localhost:33060", 0);
    }

    /**
     * This method is integration test for Capital City Report One
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportOne() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportOne();
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Seoul");
        assertEquals(capitalCities.get(0).getCountry(),"South Korea");
        assertEquals(capitalCities.get(0).getPopulation(),9981619);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }
    /**
     * This method is integration test for Capital City Report Two
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportTwo() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportTwo("Asia");
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Seoul");
        assertEquals(capitalCities.get(0).getCountry(),"South Korea");
        assertEquals(capitalCities.get(0).getPopulation(),9981619);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }
    /**
     * This method is integration test for Capital City Report Three
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportThree() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportThree("South America");
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Lima");
        assertEquals(capitalCities.get(0).getCountry(),"Peru");
        assertEquals(capitalCities.get(0).getPopulation(),6464693);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }
    /**
     * This method is integration test for Capital City Report Four
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportFour() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportFour(7);
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Seoul");
        assertEquals(capitalCities.get(0).getCountry(),"South Korea");
        assertEquals(capitalCities.get(0).getPopulation(),9981619);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }
    /**
     * This method is integration test for Capital City Report Five
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportFive() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportFive("Europe",5);
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Moscow");
        assertEquals(capitalCities.get(0).getCountry(),"Russian Federation");
        assertEquals(capitalCities.get(0).getPopulation(),8389200);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }
    /**
     * This method is integration test for Capital City Report Six
     * @throws SQLException
     */
    @Test
    void testCapitalCityReportSix() throws SQLException {
        // create array list
        ArrayList<CapitalCity> capitalCities = db.capitalCityReportSix("North America",4);
        // check array list is null
        assertNotNull(capitalCities);
        // check array list has data
        assertEquals(capitalCities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(capitalCities.get(0).getName());
        assertNotNull(capitalCities.get(0).getCountry());
        assertNotNull(capitalCities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(capitalCities.get(0).getName(),"Washington");
        assertEquals(capitalCities.get(0).getCountry(),"United States");
        assertEquals(capitalCities.get(0).getPopulation(),572059);
        // print report
        report.capitalCityReportTemplate(capitalCities);
    }


    /**
     * This method will run after all integration test
     * @throws SQLException
     */
    @AfterAll()
    static void end() throws SQLException {
        db.disconnect(); // Disconnect database connection after running all test
    }
}
