package com.napier.sem;
import com.napier.sem.model.City;

import java.sql.*;
import java.util.ArrayList;

/**
 * Declaring public class for DatabaseConnection
 */
public class DatabaseConnection {
    /**
     * Create Database Connection object
     */
    private static Connection con = null;

    /**
     * Create Instance of database
     */
    private static DatabaseConnection instance = null;

    /**
     * Method for database singleton
     *
     * @return Instance of DatabaseConnection
     */
    public static DatabaseConnection Instance() {
        // Check instance is null
        if (instance == null){
            // If null assign new connection to instance variable
            instance = new DatabaseConnection();
        }
        // Return instance of DatabaseConnection
        return instance;
    }

    /**
     * Default constructor for DatabaseConnection
     */
    public DatabaseConnection() {
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, long delay) throws ClassNotFoundException, InterruptedException, SQLException {
        // Define class name for jdb driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Define retries variable and assign 20
        int retries = 20;
        // 20 times loop and connect database
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            // Wait a bit for db to start
            Thread.sleep(delay);
            // Connect to database
            con = DriverManager.getConnection("jdbc:mysql://"+location+"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "123group4");
            System.out.println("Successfully connected");
            break;
        }
    }


    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() throws SQLException {
        //Check con is not null and close connection
        if (con != null) {
            // Close connection
            con.close();
            System.out.println("--------------------------------------");
            System.out.println("Connection to database closed");
        }
    }


    /**
     * Methods for retrieve data for CityReportOne
     * @return cities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }

    /**
     * Methods for retrieve data for CityReportTwo
     * @param continent name
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportTwo(String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.district, city.population from city city join country country on CountryCode=code where country.continent = '"+continent+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }

    /**
     * Methods for retrieve data for CityReportThree
     * @param region name
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportThree(String region) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where country.region = '"+region+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }

    /**
     * Methods for retrieve data for CityReportFour
     * @param country name
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportFour(String country) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where country.name = '"+country+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }
    /**
     * Methods for retrieve data for CityReportFive
     * @param district
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportFive(String district) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where district = '"+district+"' order by city.population DESC";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }
    /**
     * Methods for retrieve data for CityReportSix
     * @param num
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportSix(int num) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code order by city.population DESC LIMIT "+num+"";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }
    /**
     * Methods for retrieve data for CityReportSeven
     * @param topNum
     * @param continent
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportSeven(int topNum, String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.district, city.population from city city join country country on CountryCode=code where continent = '"+continent+"' order by city.population DESC LIMIT "+topNum+" ";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }
    /**
     * Methods for retrieve data for CityReporteight
     * @param num
     * @param region
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportEight(int num, String region) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.district, city.population from city city join country country on CountryCode=code where region = '"+region+"' order by city.population DESC LIMIT "+num+"";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }
    /**
     * Methods for retrieve data for CityReportNine
     * @param num
     * @param country
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportNine(int num, String country) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where country.name = '"+country+"' order by city.population DESC LIMIT "+num+"";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }
    /**
     * Methods for retrieve data for CityReportten
     * @param num
     * @param district
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<City> cityReportten(int num, String district) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.district, city.population from city city join country country on CountryCode=code where city.district = '"+district+"' order by city.population DESC LIMIT "+num+"";
        //Create cities arraylist to store city data
        ArrayList<City> cities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create city object and set data in setter method */
            City city = new City();
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));
            city.setDistrict(resultSet.getString("district"));
            city.setPopulation(resultSet.getLong("population"));
            // Add city object in countries array list
            cities.add(city);
        }
        // Return cities array list
        return cities;
    }


}