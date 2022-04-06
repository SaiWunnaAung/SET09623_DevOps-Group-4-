package com.napier.sem;
import com.napier.sem.model.City;

import java.util.ArrayList;

/**
 * Declaring public class for Report
 */
public class Report {


    /**
     * Methods for cityReportTemplate with table formatted
     * @param city Arraylist
     */
    public void cityReportTemplate(ArrayList<City> city){
        //Print report title
        System.out.format("%-9s %-30.25s  %-30s  %-20s  %-20s", "No",  "NAME", "CONTINENT", "DISTRICT", "POPULATION");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from city array list as a city object
        for (City cities:city){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-30s  %-20s  %-20s",
                    count,
                    cities.getName(),
                    cities.getCountry(),
                    cities.getDistrict(),
                    cities.getPopulation()
            );
            System.out.println("\n");
        }
    }


}
