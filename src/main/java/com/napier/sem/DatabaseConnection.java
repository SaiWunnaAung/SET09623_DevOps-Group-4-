package com.napier.sem;
import com.napier.sem.model.CapitalCity;

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
     * Methods for retrieve data for CapitalCityReportOne
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name As country, city.population from city city join country country on id=capital order by city.population DESC";
        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create capitalCity object and set data in setter method */
            CapitalCity capitalCity = new CapitalCity();
            capitalCity.setName(resultSet.getString("name"));
            capitalCity.setCountry(resultSet.getString("country"));
            capitalCity.setPopulation(resultSet.getLong("population"));
            // Add capitalCity object in capitalCities array list
            capitalCities.add(capitalCity);
        }
        // Return capitalCities array list
        return capitalCities;
    }
    /**
     * Methods for retrieve data for CapitalCityReportTwo
     * @param continent
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportTwo(String continent) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.population from city city join country country on id=capital where continent = '"+continent+"' order by city.population DESC";

        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create capitalCity object and set data in setter method */
            CapitalCity capitalCity = new CapitalCity();
            capitalCity.setName(resultSet.getString("name"));
            capitalCity.setCountry(resultSet.getString("country"));
            capitalCity.setPopulation(resultSet.getLong("population"));
            // Add capitalCity object in capitalCities array list
            capitalCities.add(capitalCity);
        }
        // Return capitalCities array list
        return capitalCities;
    }
    /**
     * Methods for retrieve data for CapitalCityReportThree
     * @param region
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportThree(String region) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.population from city city join country on id=capital where region = '"+region+"' order by city.population DESC";

        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create capitalCity object and set data in setter method */
            CapitalCity capitalCity = new CapitalCity();
            capitalCity.setName(resultSet.getString("name"));
            capitalCity.setCountry(resultSet.getString("country"));
            capitalCity.setPopulation(resultSet.getLong("population"));
            // Add capitalCity object in capitalCities array list
            capitalCities.add(capitalCity);
        }
        // Return capitalCities array list
        return capitalCities;
    }
    /**
     * Methods for retrieve data for CapitalCityReportFour
     * @param number
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportFour(int number) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.population from city city join country country on id=capital order by city.population DESC LIMIT "+number+"";
        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create capitalCity object and set data in setter method */
            CapitalCity capitalCity = new CapitalCity();
            capitalCity.setName(resultSet.getString("name"));
            capitalCity.setCountry(resultSet.getString("country"));
            capitalCity.setPopulation(resultSet.getLong("population"));
            // Add capitalCity object in capitalCities array list
            capitalCities.add(capitalCity);
        }
        // Return capitalCities array list
        return capitalCities;
    }
    /**
     * Methods for retrieve data for CapitalCityReportFive
     * @param number
     * @param continent
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportFive(String continent, int number) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.population from city city join country country on id=capital where continent= '"+continent+"' order by city.population DESC LIMIT "+number+"";
        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create capitalCity object and set data in setter method */
            CapitalCity capitalCity = new CapitalCity();
            capitalCity.setName(resultSet.getString("name"));
            capitalCity.setCountry(resultSet.getString("country"));
            capitalCity.setPopulation(resultSet.getLong("population"));
            // Add capitalCity object in capitalCities array list
            capitalCities.add(capitalCity);
        }
        // Return capitalCities array list
        return capitalCities;
    }
    /**
     * Methods for retrieve data for CapitalCityReportSix
     * @param number
     * @param region
     * @return capitalCities ArrayList
     * @throws SQLException
     */
    public ArrayList<CapitalCity> capitalCityReportSix(String region, int number) throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select city.name, country.name AS country, city.population from city city join country country on id=capital where region= '"+region+"' order by city.population DESC LIMIT "+number+"";
        //Create capitalCities arraylist to store capital city data
        ArrayList<CapitalCity> capitalCities = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create capitalCity object and set data in setter method */
            CapitalCity capitalCity = new CapitalCity();
            capitalCity.setName(resultSet.getString("name"));
            capitalCity.setCountry(resultSet.getString("country"));
            capitalCity.setPopulation(resultSet.getLong("population"));
            // Add capitalCity object in capitalCities array list
            capitalCities.add(capitalCity);
        }
        // Return capitalCities array list
        return capitalCities;
    }


}