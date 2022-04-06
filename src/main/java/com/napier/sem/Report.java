package com.napier.sem;

import com.napier.sem.model.Population;
import java.util.ArrayList;

/**
 * Declaring public class for Report
 */
public class Report {

    /**
     * Methods for populationReportTemplate with table formatted
     * @param population Arraylist
     */
    public void populationReportTemplate(ArrayList<Population> population){
        //Print report title
        System.out.format("%-9s %-35s  %-35s  %-35s  %-35s  %-35s  %-35s", "No",  "NAME", "POPULATION", "POPULATION IN CITY", "POPULATION NOT IN CITY", "POPULATION IN CITY PERCENTAGE", "POPULATION NOT IN CITY PERCENTAGE");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from population array list as a Population object
        for (Population populations:population){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-35s  %-35s  %-35s  %-35s  %-35s  %-35s",
                    count,
                    populations.getName(),
                    populations.getPopulation(),
                    populations.getPopInCity(),
                    populations.getPopNotInCity(),
                    populations.getPercentagePopulationInCities(),
                    populations.getPercentagePopulationNotInCities()
            );
            System.out.println("\n");
        }
    }

}
