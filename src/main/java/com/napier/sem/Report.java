package com.napier.sem;
import com.napier.sem.model.Country;

import java.util.ArrayList;

/**
 * Declaring public class for Report
 */
public class Report {

    /**
     * Methods for countryReportTemplate with table formatted
     * @param country Arraylist
     */
    public void countryReportTemplate(ArrayList<Country> country){
        //Print report title
        System.out.format("%-9s %-9s  %-40s  %-30.25s  %-30s  %-20s  %-20s", "No", "CODE", "NAME", "CONTINENT", "REGION", "POPULATION", "CAPITAL");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from country array list as a country object
        for (Country countries:country){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-9s  %-40s  %-30.25s  %-30s  %-20s  %-20s",
                    count,
                    countries.getCode(),
                    countries.getName(),
                    countries.getContinent(),
                    countries.getRegion(),
                    countries.getPopulation(),
                    countries.getCapital()
            );
            System.out.println("\n");
        }
    }

}
