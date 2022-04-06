package com.napier.sem;
import com.napier.sem.model.Population;

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
     * Methods for retrieve data for PopulationReportOne
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> populationReportOne() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "Select country.continent, SUM(country.population) as TotalPopulation, SUM((select SUM(population) from city where countrycode = country.code)) AS popInCity, (SUM((select SUM(population) from city where countrycode = country.code)) / SUM(country.population))*100 as percentInCities , (sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) as popNotInCity, ((sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) / SUM(country.population))*100 as percentNotInCities from country GROUP BY country.continent";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
            Population population = new Population();
            population.setName(resultSet.getString("continent"));
            population.setPopulation(resultSet.getLong("TotalPopulation"));
            population.setPopInCity(resultSet.getLong("popInCity"));
            population.setPopNotInCity(resultSet.getLong("popNotInCity"));
            population.setPercentagePopulationInCities(resultSet.getFloat("percentInCities"));
            population.setPercentagePopulationNotInCities(resultSet.getFloat("percentNotInCities"));
            // Add population object in populations array list
            populations.add(population);
        }
        // Return populations array list
        return populations;
    }

    /**
     * Methods for retrieve data for PopulationReportTwo
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> populationReportTwo() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "Select country.region, SUM(country.population) as TotalPopulation, SUM((select SUM(population) from city where countrycode = country.code)) AS popInCity, (SUM((select SUM(population) from city where countrycode = country.code)) / SUM(country.population))*100 as percentInCities , (sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) as popNotInCity, ((sum(country.population)-SUM((select SUM(population) from city where countrycode = country.code))) / SUM(country.population))*100 as percentNotInCities from country GROUP BY country.region";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
            Population population = new Population();
            population.setName(resultSet.getString("region"));
            population.setPopulation(resultSet.getLong("TotalPopulation"));
            population.setPopInCity(resultSet.getLong("popInCity"));
            population.setPopNotInCity(resultSet.getLong("popNotInCity"));
            population.setPercentagePopulationInCities(resultSet.getFloat("percentInCities"));
            population.setPercentagePopulationNotInCities(resultSet.getFloat("percentNotInCities"));
            // Add population object in populations array list
            populations.add(population);
        }
        // Return populations array list
        return populations;
    }
    /**
     * Methods for retrieve data for PopulationReportThree
     * @return populations ArrayList
     * @throws SQLException
     */
    public ArrayList<Population> populationReportThree() throws SQLException {
        // Define statement variable
        Statement statement;
        // Define resultSet  variable
        ResultSet resultSet;
        //Write sql retrieve query for report
        String query = "select country.name AS country, country.population, country.population-sum(city.population) as 'popNotInCity', ((country.population-sum(city.population))/country.population)*100 as 'percentNotInCities', country.population - (country.population-sum(city.population)) as 'popInCity', ((country.population - (country.population-sum(city.population)))/country.population)*100 as 'percentInCities' from country country join city city on country.code = city.countrycode where city.countrycode = country.code GROUP BY country.name, country.population ORDER BY country.name";
        //Create populations arraylist to store population data
        ArrayList<Population> populations = new ArrayList<>();
        //Assign connection object to statement variable
        statement = con.createStatement();
        // Run sql retrieve query and assign result to resultSet variable
        resultSet = statement.executeQuery(query);
        // Retrieve data from resultSet by using while loop
        while (resultSet.next()) {
            /* Create population object and set data in setter method */
            Population population = new Population();
            population.setName(resultSet.getString("country"));
            population.setPopulation(resultSet.getLong("population"));
            population.setPopInCity(resultSet.getLong("popInCity"));
            population.setPopNotInCity(resultSet.getLong("popNotInCity"));
            population.setPercentagePopulationInCities(resultSet.getFloat("percentInCities"));
            population.setPercentagePopulationNotInCities(resultSet.getFloat("percentNotInCities"));
            // Add population object in populations array list
            populations.add(population);
        }
        // Return populations array list
        return populations;
    }

}