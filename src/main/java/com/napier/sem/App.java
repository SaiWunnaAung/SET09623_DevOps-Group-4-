package com.napier.sem;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Declaring public class for App
 */
@SpringBootApplication
@RestController
public class App
{
    /**
     * Create Instance of database
     */
    private final static DatabaseConnection db = DatabaseConnection.Instance();

    /**
     * Create Instance of APP
     */
    private static App app;

    private JsonConverter jsonConverter = new JsonConverter();

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, SQLException {
        // Create  App object
        app = new App();
        //Add database connection
        if (args.length < 1) {
            db.connect("localhost:33060",0);
        } else {
            db.connect(args[0],Integer.parseInt(args[1]));
        }
        SpringApplication.run(App.class, args);


    }

    /**
     * This function is for countryReportOne API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/countryReportOne")
    private String countryReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportOne());
    }

    /**
     * This function is for countryReportTwo API.
     * @param continent
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/countryReportTwo")
    private String countryReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportTwo(continent));
    }

    /**
     * This function is for countryReportThree API.
     * @param region
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/countryReportThree")
    private String countryReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportThree(region));
    }

    /**
     * This function is for countryreportFour API.
     * @param topNum
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/countryReportFour")
    private String countryReportFour(@RequestParam(value="limit") int topNum) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportFour(topNum));
    }

    /**
     * This function is for countryreportFive API.
     * @param continent
     * @param num
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/countryReportFive")
    private String countryReportFive(@RequestParam(value="name") String continent, @RequestParam(value="num") int num) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportFive(continent, num));
    }

    /**
     * This function is for countryreportSix API.
     * @param region
     * @param num
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/countryReportSix")
    private String countryReportSix(@RequestParam(value="name") String region, @RequestParam(value="num") int num) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportSix(region, num));
    }

    /**
     * This function is for cityreportOne API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportOne")
    private String cityReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportOne());
    }

    /**
     * This function is for cityreportTwo API.
     * @param continent
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportTwo")
    private String cityReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportTwo(continent));
    }

    /**
     * This function is for cityreportThree API.
     * @param region
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportThree")
    private String cityReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportThree(region));
    }

    /**
     * This function is for cityreportFour API.
     * @param country
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportFour")
    private String cityReportFour(@RequestParam(value="name") String country) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportFour(country));
    }

    /**
     * This function is for cityreportFive API.
     * @param district
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportFive")
    private String cityReportFive(@RequestParam(value="name") String district) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportFive(district));
    }

    /**
     * This function is for cityreportSix API.
     * @param num
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportSix")
    private String cityReportSix(@RequestParam(value="limit") int num) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportSix(num));
    }

    /**
     * This function is for cityreportSeven API.
     * @param topNum
     * @param continent
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportSeven")
    private String cityReportSeven(@RequestParam(value="limit") int topNum, @RequestParam(value="continent") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportSeven(topNum, continent));
    }

    /**
     * This function is for cityreportEight API.
     * @param num
     * @param region
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportEight")
    private String cityReportEight(@RequestParam(value="limit") int num, @RequestParam(value="region") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportEight(num, region));
    }

    /**
     * This function is for cityreportNine API.
     * @param num
     * @param country
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportNine")
    private String cityReportNine(@RequestParam(value="limit") int num, @RequestParam(value="country") String country) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportNine(num, country));
    }

    /**
     * This function is for cityreportten API.
     * @param num
     * @param district
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/cityReportten")
    private String cityReportten(@RequestParam(value="limit") int num, @RequestParam(value="district") String district) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportten(num, district));
    }

    /**
     * This function is for capitalCityReportOne API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/capitalCityReportOne")
    private String capitalCityReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportOne());
    }

    /**
     * This function is for capitalCityReportTwo API.
     * @param continent
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/capitalCityReportTwo")
    private String capitalCityReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportTwo(continent));
    }

    /**
     * This function is for capitalCityReportThree API.
     * @param region
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/capitalCityReportThree")
    private String capitalCityReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportThree(region));
    }

    /**
     * This function is for capitalCityReportFour API.
     * @param number
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/capitalCityReportFour")
    private String capitalCityReportFour(@RequestParam(value="limit") int number) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportFour(number));
    }

    /**
     * This function is for capitalCityReportFive API.
     * @param continent
     * @param number
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/capitalCityReportFive")
    private String capitalCityReportFive(@RequestParam(value="name") String continent, @RequestParam(value="number") int number ) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportFive(continent, number));
    }

    /**
     * This function is for capitalCityReportSix API.
     * @param region
     * @param number
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/capitalCityReportSix")
    private String capitalCityReportSix(@RequestParam(value="name") String region, @RequestParam(value="number") int number ) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportSix(region, number));
    }

    /**
     * This function is for populationReportOne API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/populationReportOne")
    private String populationReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.populationJSON(db.populationReportOne());
    }

    /**
     * This function is for populationReportTwo API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/populationReportTwo")
    private String populationReportTwo() throws SQLException, JsonProcessingException {
        return jsonConverter.populationJSON(db.populationReportTwo());
    }

    /**
     * This function is for populationReportThree API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/populationReportThree")
    private String populationReportThree() throws SQLException, JsonProcessingException {
        return jsonConverter.populationJSON(db.populationReportThree());
    }

    /**
     * This function is for additionalReportOne API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportOne")
    private String additionalReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportOne());
    }


    /**
     * This function is for additionalReportTwo API.
     * @param continent
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportTwo")
    private String additionalReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportTwo(continent));
    }

    /**
     * This function is for additionalReportThree API.
     * @param region
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportThree")
    private String additionalReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportThree(region));
    }

    /**
     * This function is for additionalReportFour API.
     * @param country
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportFour")
    private String additionalReportFour(@RequestParam(value="name") String country) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportFour(country));
    }

    /**
     * This function is for additionalReportFive API.
     * @param district
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportFive")
    private String additionalReportFive(@RequestParam(value="name") String district) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportFive(district));
    }

    /**
     * This function is for additionalReportSix API.
     * @param name
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportSix")
    private String additionalReportSix(@RequestParam(value="name") String name) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportSix(name));
    }

    /**
     * This function is for additionalReportSeven API.
     * @return JSON
     * @throws SQLException
     * @throws JsonProcessingException
     */
    @RequestMapping("/additionalReportSeven")
    private String additionalReportSeven() throws SQLException, JsonProcessingException {
        return jsonConverter.advancePopulationJSON(db.additionalReportSeven());
    }

}