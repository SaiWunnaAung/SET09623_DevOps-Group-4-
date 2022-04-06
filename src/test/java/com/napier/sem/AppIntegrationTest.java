package com.napier.sem;

import com.napier.sem.model.City;
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
     * This method is integration test for City Report One
     * @throws SQLException
     */
    @Test
    void testCityReportOne() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportOne();
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Two
     * @throws SQLException
     */
    @Test
    void testCityReportTwo() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportTwo("Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Three
     * @throws SQLException
     */
    @Test
    void testCityReportThree() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportThree("Eastern Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Seoul");
        assertEquals(cities.get(0).getCountry(),"South Korea");
        assertEquals(cities.get(0).getDistrict(),"Seoul");
        assertEquals(cities.get(0).getPopulation(),9981619);
        // print report
        report.cityReportTemplate(cities);
    }

    /**
     * This method is integration test for City Report Four
     * @throws SQLException
     */
    @Test
    void testCityReportFour() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportFour("Thailand");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Bangkok");
        assertEquals(cities.get(0).getCountry(),"Thailand");
        assertEquals(cities.get(0).getDistrict(),"Bangkok");
        assertEquals(cities.get(0).getPopulation(),6320174);
        // print report
        report.cityReportTemplate(cities);
    }
    /**
     * This method is integration test for City Report five
     * @throws SQLException
     */
    @Test
    void testCityReportFive() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportFive("Mandalay");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mandalay");
        assertEquals(cities.get(0).getCountry(),"Myanmar");
        assertEquals(cities.get(0).getDistrict(),"Mandalay");
        assertEquals(cities.get(0).getPopulation(),885300);
        // print report
        report.cityReportTemplate(cities);
    }
    /**
     * This method is integration test for City Report Six
     * @throws SQLException
     */
    @Test
    void testCityReportSix() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportSix(8);
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }
    /**
     * This method is integration test for City Report Seven
     * @throws SQLException
     */
    @Test
    void testCityReportSeven() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportSeven(7,"Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(),"India");
        assertEquals(cities.get(0).getDistrict(),"Maharashtra");
        assertEquals(cities.get(0).getPopulation(),10500000);
        // print report
        report.cityReportTemplate(cities);
    }
    /**
     * This method is integration test for City Report Eight
     * @throws SQLException
     */
    @Test
    void testCityReportEight() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportEight(4,"Eastern Asia");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Seoul");
        assertEquals(cities.get(0).getCountry(),"South Korea");
        assertEquals(cities.get(0).getDistrict(),"Seoul");
        assertEquals(cities.get(0).getPopulation(),9981619);
        // print report
        report.cityReportTemplate(cities);
    }
    /**
     * This method is integration test for City Report Nine
     * @throws SQLException
     */
    @Test
    void testCityReportNine() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportNine(6,"China");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Shanghai");
        assertEquals(cities.get(0).getCountry(),"China");
        assertEquals(cities.get(0).getDistrict(),"Shanghai");
        assertEquals(cities.get(0).getPopulation(),9696300);
        // print report
        report.cityReportTemplate(cities);
    }
    /**
     * This method is integration test for City Report ten
     * @throws SQLException
     */
    @Test
    void testCityReportten() throws SQLException {
        // create array list
        ArrayList<City> cities = db.cityReportten(3,"Hubei");
        // check array list is null
        assertNotNull(cities);
        // check array list has data
        assertEquals(cities.size() > 0, true);
        /*Check data items are not null*/
        assertNotNull(cities.get(0).getName());
        assertNotNull(cities.get(0).getCountry());
        assertNotNull(cities.get(0).getDistrict());
        assertNotNull(cities.get(0).getPopulation());
        /*Check expected data are correct or not*/
        assertEquals(cities.get(0).getName(),"Wuhan");
        assertEquals(cities.get(0).getCountry(),"China");
        assertEquals(cities.get(0).getDistrict(),"Hubei");
        assertEquals(cities.get(0).getPopulation(),4344600);
        // print report
        report.cityReportTemplate(cities);
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
