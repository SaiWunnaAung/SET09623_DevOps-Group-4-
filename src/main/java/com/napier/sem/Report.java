package com.napier.sem;
import com.napier.sem.model.Population;
import java.util.ArrayList;

/**
 * Declaring public class for Report
 */
public class Report {


    /**
     * Methods for simplePopulationReportTemplate with table formatted
     * @param population Arraylist
     */
    public void simplePopulationReportTemplate(ArrayList<Population> population){
        //Print report title
        System.out.format("%-9s %-30.25s  %-20s", "No",  "NAME", "POPULATION");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from population array list as a Population object
        for (Population populations:population){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-20s",
                    count,
                    populations.getName(),
                    populations.getPopulation()
            );
            System.out.println("\n");
        }
    }

    /**
     * Methods for advancePopulationReportTemplate with table formatted
     * @param population Arraylist
     */
    public void advancePopulationReportTemplate(ArrayList<Population> population){
        //Print report title
        System.out.format("%-9s %-30.25s  %-37.25s  %-20s", "No",  "LANGUAGE NAME", "POPULATION NUMBER", "POPULATION PERCENTAGE (%)");
        System.out.println("\n");
        // Define counter variable
        int count = 0;
        // Loop and Retrieve data from population array list as a Population object
        for (Population populations:population){
            // Increase count
            count++;
            // Print report by formatted design
            System.out.printf("%-9s %-30.25s  %-37.25s  %-20s",
                    count,
                    populations.getName(),
                    populations.getPopulation(),
                    populations.getPercentagePopulationInCities()
            );
            System.out.println("\n");
        }
    }


}
