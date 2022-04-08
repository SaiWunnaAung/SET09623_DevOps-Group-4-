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
        db.countryReportOne();
        //Remove database connection

    }



    @RequestMapping("/countryReportOne")
    private String countryReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportOne());
    }

    @RequestMapping("/countryReportTwo")
    private String countryReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportTwo(continent));
    }
    @RequestMapping("/countryReportThree")
    private String countryReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportThree(region));
    }
    @RequestMapping("/countryReportFour")
    private String countryReportFour(@RequestParam(value="limit") int topNum) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportFour(topNum));
    }
    @RequestMapping("/countryReportFive")
    private String countryReportFive(@RequestParam(value="name") String continent, @RequestParam(value="num") int num) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportFive(continent, num));
    }
    @RequestMapping("/countryReportSix")
    private String countryReportSix(@RequestParam(value="name") String region, @RequestParam(value="num") int num) throws SQLException, JsonProcessingException {
        return jsonConverter.countryJSON(db.countryReportSix(region, num));
    }

    @RequestMapping("/cityReportOne")
    private String cityReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportOne());
    }

    @RequestMapping("/cityReportTwo")
    private String cityReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportTwo(continent));
    }

    @RequestMapping("/cityReportThree")
    private String cityReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportThree(region));
    }

    @RequestMapping("/cityReportFour")
    private String cityReportFour(@RequestParam(value="name") String country) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportFour(country));
    }

    @RequestMapping("/cityReportFive")
    private String cityReportFive(@RequestParam(value="name") String district) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportFive(district));
    }
    @RequestMapping("/cityReportSix")
    private String cityReportSix(@RequestParam(value="limit") int num) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportSix(num));
    }
    @RequestMapping("/cityReportSeven")
    private String cityReportSeven(@RequestParam(value="limit") int topNum, @RequestParam(value="continent") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportSeven(topNum, continent));
    }
    @RequestMapping("/cityReportEight")
    private String cityReportEight(@RequestParam(value="limit") int num, @RequestParam(value="region") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportEight(num, region));
    }
    @RequestMapping("/cityReportNine")
    private String cityReportNine(@RequestParam(value="limit") int num, @RequestParam(value="country") String country) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportNine(num, country));
    }
    @RequestMapping("/cityReportten")
    private String cityReportten(@RequestParam(value="limit") int num, @RequestParam(value="district") String district) throws SQLException, JsonProcessingException {
        return jsonConverter.cityJSON(db.cityReportten(num, district));
    }

    @RequestMapping("/capitalCityReportOne")
    private String capitalCityReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportOne());
    }

    @RequestMapping("/capitalCityReportTwo")
    private String capitalCityReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportTwo(continent));
    }

    @RequestMapping("/capitalCityReportThree")
    private String capitalCityReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportThree(region));
    }
    @RequestMapping("/capitalCityReportFour")
    private String capitalCityReportFour(@RequestParam(value="limit") int number) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportFour(number));
    }
    @RequestMapping("/capitalCityReportFive")
    private String capitalCityReportFive(@RequestParam(value="name") String continent, @RequestParam(value="number") int number ) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportFive(continent, number));
    }

    @RequestMapping("/capitalCityReportSix")
    private String capitalCityReportSix(@RequestParam(value="name") String region, @RequestParam(value="number") int number ) throws SQLException, JsonProcessingException {
        return jsonConverter.capitalCityJSON(db.capitalCityReportSix(region, number));
    }

    @RequestMapping("/populationReportOne")
    private String populationReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.populationJSON(db.populationReportOne());
    }

    @RequestMapping("/populationReportTwo")
    private String populationReportTwo() throws SQLException, JsonProcessingException {
        return jsonConverter.populationJSON(db.populationReportTwo());
    }

    @RequestMapping("/populationReportThree")
    private String populationReportThree() throws SQLException, JsonProcessingException {
        return jsonConverter.populationJSON(db.populationReportThree());
    }
    @RequestMapping("/additionalReportOne")
   private String additionalReportOne() throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportOne());
    }


    @RequestMapping("/additionalReportTwo")
   private String additionalReportTwo(@RequestParam(value="name") String continent) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportTwo(continent));
    }

    @RequestMapping("/additionalReportThree")
   private String additionalReportThree(@RequestParam(value="name") String region) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportThree(region));
    }
    @RequestMapping("/additionalReportFour")
   private String additionalReportFour(@RequestParam(value="name") String country) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportFour(country));
    }
    @RequestMapping("/additionalReportFive")
   private String additionalReportFive(@RequestParam(value="name") String district) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportFive(district));
    }

    @RequestMapping("/additionalReportSix")
   private String additionalReportSix(@RequestParam(value="name") String name) throws SQLException, JsonProcessingException {
        return jsonConverter.simplePopulationJSON(db.additionalReportSix(name));
    }
    @RequestMapping("/additionalReportSeven")
   private String additionalReportSeven() throws SQLException, JsonProcessingException {
        return jsonConverter.advancePopulationJSON(db.additionalReportSeven());
    }

}