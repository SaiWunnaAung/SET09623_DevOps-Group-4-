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
     * This method is integration test for Additional Report One
     * @throws SQLException
     */
    @Test
    void testAdditionalReportOne() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportOne();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"World Population");
        assertEquals(populations.get(0).getPopulation(),6078749450L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }

    /**
     * This method is integration test for Additional Report Two
     * @throws SQLException
     */
    @Test
    void testAdditionalReportTwo() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportTwo("Europe");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Europe");
        assertEquals(populations.get(0).getPopulation(),730074600L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }
    /**
     * This method is integration test for Additional Report Three
     * @throws SQLException
     */
    @Test
    void testAdditionalReportThree() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportThree("North America");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"North America");
        assertEquals(populations.get(0).getPopulation(),309632000L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }

    /**
     * This method is integration test for Additional Report Four
     * @throws SQLException
     */
    @Test
    void testAdditionalReportFour() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportFour("United Kingdom");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"United Kingdom");
        assertEquals(populations.get(0).getPopulation(),59623400L);
        // print report
        report.simplePopulationReportTemplate(populations);
    }
    /**
     * This method is integration test for Additional Report Five
     * @throws SQLException
     */
    @Test
    void testAdditionalReportFive() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportFive("Hubei");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Hubei");
        assertEquals(populations.get(0).getPopulation(),8547585);
        // print report
        report.simplePopulationReportTemplate(populations);
    }
    /**
     * This method is integration test for Additional Report Six
     * @throws SQLException
     */
    @Test
    void testAdditionalReportSix() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportSix("Boston");
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Boston");
        assertEquals(populations.get(0).getPopulation(),589141);
        // print report
        report.simplePopulationReportTemplate(populations);
    }
    /**
     * This method is integration test for Additional Report Seven
     * @throws SQLException
     */
    @Test
    void testAdditionalReportSeven() throws SQLException {
        // create array list
        ArrayList<Population> populations = db.additionalReportSeven();
        // check array list is null
        assertNotNull(populations);
        // check array list has data
        assertEquals(populations.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(populations.get(0).getName());
        assertNotNull(populations.get(0).getPopulation());
        assertNotNull(populations.get(0).getPercentagePopulationInCities());
        /*Check expected data are correct or not*/
        assertEquals(populations.get(0).getName(),"Chinese");
        assertEquals(populations.get(0).getPopulation(),119184353900L);
        assertEquals(populations.get(0).getPercentagePopulationInCities(),19.606719970703125);
        // print report
        report.advancePopulationReportTemplate(populations);
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
