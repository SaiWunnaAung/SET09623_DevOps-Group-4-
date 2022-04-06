package com.napier.sem;

import com.napier.sem.model.Population;
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
     * This method is integration test for Population Report one
     * @throws SQLException
     */
    @Test
    void testPopulationReportOne() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.populationReportOne();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPopInCity());
        assertNotNull(populations.get(0).getPopNotInCity());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        assertNotNull(populations.get(0).getPercentagePopulationNotInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"North America");
        assertEquals(populations.get(0).getPopulation(),482993000);
        assertEquals(populations.get(0).getPopInCity(),168250381);
        assertEquals(populations.get(0).getPopNotInCity(),314742619);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),34.834999084472656);
        assertEquals(populations.get(0).getPercentagePopulationNotInCities(),65.16500091552734);
        // print report
        report.populationReportTemplate(populations);
    }

    /**
     * This method is integration test for Population Report Two
     * @throws SQLException
     */
    @Test
    void testPopulationReportTwo() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.populationReportTwo();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPopInCity());
        assertNotNull(populations.get(0).getPopNotInCity());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        assertNotNull(populations.get(0).getPercentagePopulationNotInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Caribbean");
        assertEquals(populations.get(0).getPopulation(),38140000);
        assertEquals(populations.get(0).getPopInCity(),11067550);
        assertEquals(populations.get(0).getPopNotInCity(),27072450);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),29.018199920654297);
        assertEquals(populations.get(0).getPercentagePopulationNotInCities(),70.98179626464844);
        // print report
        report.populationReportTemplate(populations);
    }
    /**
     * This method is integration test for Population Report Three
     * @throws SQLException
     */
    @Test
    void testPopulationReportThree() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.populationReportThree();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPopInCity());
        assertNotNull(populations.get(0).getPopNotInCity());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        assertNotNull(populations.get(0).getPercentagePopulationNotInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Afghanistan");
        assertEquals(populations.get(0).getPopulation(),22720000);
        assertEquals(populations.get(0).getPopInCity(),2332100);
        assertEquals(populations.get(0).getPopNotInCity(),20387900);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),10.26449966430664);
        assertEquals(populations.get(0).getPercentagePopulationNotInCities(),89.7354965209961);
        // print report
        report.populationReportTemplate(populations);
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
