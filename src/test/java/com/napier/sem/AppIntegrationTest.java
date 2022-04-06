package com.napier.sem;

import com.napier.sem.model.Country;
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
     * This method is integration test for Country Report One
     * @throws SQLException
     */
    @Test
    void testCountryReportOne() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportOne();
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for Country Report Two
     * @throws SQLException
     */
    @Test
    void testCountryReportTwo() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportTwo("Asia");
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for Country Report Three
     * @throws SQLException
     */
    @Test
    void testCountryReportThree() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportThree("Eastern Asia");// create array list
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }

    /**
     * This method is integration test for Country Report Four
     * @throws SQLException
     */
    @Test
    void testCountryReportFour() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportFour(5);
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }
    /**
     * This method is integration test for Country Report Five
     * @throws SQLException
     */
    @Test
    void testCountryReportFive() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportFive("Asia",5);
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
    }
    /**
     * This method is integration test for Country Report Six
     * @throws SQLException
     */
    @Test
    void testCountryReportSix() throws SQLException {
        // create array list
        ArrayList<Country> countries = db.countryReportSix("Eastern Asia",7 );
        // check array list is null
        assertNotNull(countries);
        // check array list has data
        assertEquals(countries.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(countries.get(0).getCode());
        assertNotNull(countries.get(0).getName());
        assertNotNull(countries.get(0).getContinent());
        assertNotNull(countries.get(0).getRegion());
        assertNotNull(countries.get(0).getPopulation());
        assertNotNull(countries.get(0).getCapital());
        /*Check expected data are correct or not*/
        assertEquals(countries.get(0).getCode(),"CHN");
        assertEquals(countries.get(0).getName(),"China");
        assertEquals(countries.get(0).getContinent(),"Asia");
        assertEquals(countries.get(0).getRegion(),"Eastern Asia");
        assertEquals(countries.get(0).getPopulation(),1277558000);
        assertEquals(countries.get(0).getCapital(),"Peking");
        // print report
        report.countryReportTemplate(countries);
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
