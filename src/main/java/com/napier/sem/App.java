package com.napier.sem;

import java.sql.SQLException;

/**
 * Declaring public class for App
 */
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

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException, SQLException {
        // Create  App object
        app = new App();
        //Add database connection
        if (args.length < 1) {
            db.connect("localhost:33060",0);
        } else {
            db.connect(args[0],Integer.parseInt(args[1]));
        }
        app.reportMenu();
        //Remove database connection
        db.disconnect();
    }

    /**
     * method for output report menu
     */
    private void reportMenu() throws SQLException {
//        Scanner input = new Scanner(System.in);
        // Define reportItem array and assign report items
        String[] reportItem={
                "0. Exit from system",
                "1. All the countries in the world organised by largest population to smallest",
                "2. All the countries in a continent organised by largest population to smallest",
                "3. All the countries in a region organised by largest population to smallest",
                "4. The top N populated countries in the world",
                "5. The top N populated continent in the world",
                "6. The top N populated countries in a region",
                "7. All the cities in the world organised by largest population to smallest",
                "8. All the cities in a continent organised by largest population to smallest",
                "9. All the cities in a region organised by largest population to smallest",
                "10. All the cities in a country organised by largest population to smallest",
                "11. All the cities in a district organised by largest population to smallest.",
                "12. The top N populated cities in the world",
                "13. The top N populated cities in a continent",
                "14. The top N populated cities in a region",
                "15. The top N populated cities in a country",
                "16. The top N populated cities in a district",
                "17. All the capital cities in the world organised by largest population to smallest",
                "18. All the capital cities in a continent organised by largest population to smallest",
                "19. All the capital cities in a region organised by largest to smallest",
                "20. The top N populated capital cities in the world",
                "21. The top N populated capital cities in a continent",
                "22. The top N populated capital cities in a region",
                "23. The population of people, people living in cities, and people not living in cities in each continent",
                "24. The population of people, people living in cities, and people not living in cities in each region",
                "25. The population of people, people living in cities, and people not living in cities in each country",
                "26. The population of the world",
                "27. The population of a continent",
                "28. The population of a region",
                "29. The population of a country",
                "30. The population of a district",
                "31. The population of a city",
                "32. The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world."
        };
        System.out.println("*******************Report Menu*******************");
        // Loop reportItem and retrieve single report item
        for(int i=0; i<reportItem.length;i++){
            System.out.println(reportItem[i]);
        }

        System.out.println("Choose Report : 23");
        // Call chooseMenu method
        chooseMenu(23);

        System.out.println("Choose Report : 24");
        // Call chooseMenu method
        chooseMenu(24);

        System.out.println("Choose Report : 25");
        // Call chooseMenu method
        chooseMenu(25);


    }

    /**
     * method for choose report items
     */
    private void chooseMenu(int num) throws SQLException {
        // Create report object
        Report report = new Report();
        // Choose Report item by using switch
        switch (num) {


            /*If user choose 23the system will print the population of people,
            people living in cities, and people not living in cities in each continent*/
            case 23:
                System.out.println("The population of people, people living in cities, and people not living in cities in each continent");
                report.populationReportTemplate(db.populationReportOne()); // Print report
                break;

            /*If user choose 24 the system will print the population of people,
            people living in cities, and people not living in cities in each region*/
            case 24:
                System.out.println("The population of people, people living in cities, and people not living in cities in each region");
                report.populationReportTemplate(db.populationReportTwo()); // Print report
                break;

            /*If user choose 25 the system will print the population of people, people living in cities, and people not living in cities in each country*/
            case 25:
                System.out.println("The population of people, people living in cities, and people not living in cities in each country");
                report.populationReportTemplate(db.populationReportTwo()); // Print report
                break;

            /*If user type invalid input the system will show error*/
            default:
                System.out.println("Invalid input error.");
                break;
        }
    }


}