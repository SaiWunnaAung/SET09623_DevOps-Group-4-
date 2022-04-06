package com.napier.sem;
import com.napier.sem.model.CapitalCity;

import java.util.ArrayList;

/**
 * Declaring public class for Report
 */
public class Report {
    
    /**
     * Methods for capitalCityReportTemplate with table formatted
     * @param capitalCity Arraylist
     */
    public void capitalCityReportTemplate(ArrayList<CapitalCity> capitalCity){
        //Print report title
        System.out.format("%-9s %-30.25s  %-30s  %-20s", "No",  "NAME", "Country","POPULATION");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from capitalCity array list as a CapitalCity object
        for (CapitalCity capitalCities:capitalCity){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-30s  %-20s",
                    count,
                    capitalCities.getName(),
                    capitalCities.getCountry(),
                    capitalCities.getPopulation()
            );
            System.out.println("\n");
        }
    }

}
