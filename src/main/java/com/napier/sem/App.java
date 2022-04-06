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


        System.out.println("Choose Report : 26");
        // Call chooseMenu method
        chooseMenu(26);

        System.out.println("Choose Report : 27");
        // Call chooseMenu method
        chooseMenu(27);

        System.out.println("Choose Report : 28");
        // Call chooseMenu method
        chooseMenu(28);

        System.out.println("Choose Report : 29");
        // Call chooseMenu method
        chooseMenu(29);

        System.out.println("Choose Report : 30");
        // Call chooseMenu method
        chooseMenu(30);

        System.out.println("Choose Report : 31");
        // Call chooseMenu method
        chooseMenu(31);

        System.out.println("Choose Report : 32");
        // Call chooseMenu method
        chooseMenu(32);

    }

    /**
     * method for choose report items
     */
    private void chooseMenu(int num) throws SQLException {
        // Create report object
        Report report = new Report();
        // Choose Report item by using switch
        switch (num) {

            /*If user choose 26 the system will print the population of the world*/
            case 26:
                System.out.println("The population of the world");
                report.simplePopulationReportTemplate(db.additionalReportOne()); // Print report
                break;

            /*If user choose 27 the system will the population of a continent*/
            case 27:
                System.out.println("The population of a continent");
                System.out.println("Enter Continent: Europe");
//                String contt = sc.nextLine();
                report.simplePopulationReportTemplate(db.additionalReportTwo("Europe"));// Print report
                break;

            /*If user choose 28 the system will the population of a region*/
            case 28:
                System.out.println("The population of a region");
                System.out.println("Enter Region: North America");
//                String regg = sc.nextLine();
                report.simplePopulationReportTemplate(db.additionalReportThree("North America"));// Print report
                break;

            /*If user choose 29 the system will the population of a country*/
            case 29:
                System.out.println("The population of a country");
                System.out.println("Enter Country: United Kingdom");
//                String cou = sc.nextLine();
                report.simplePopulationReportTemplate(db.additionalReportFour("United Kingdom"));// Print report
                break;

            /*If user choose 30 the system will print the population of a district*/
            case 30:
                System.out.println("The population of a district");
                System.out.println("Enter District: Hubei");
//                String cou = sc.nextLine();
                report.simplePopulationReportTemplate(db.additionalReportFive("Hubei"));// Print report
                break;

            /*If user choose 31 the system will print the population of a city*/
            case 31:
                System.out.println("The population of a city");
                System.out.println("Enter City: Boston");
//                String cou = sc.nextLine();
                report.simplePopulationReportTemplate(db.additionalReportSix("Boston"));// Print report
                break;

            /*If user choose 32 the system will print  the number of people
            who speak Chinese, English, Hindi, Spanish or Arabic in the world*/
            case 32:
                System.out.println("The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world.");
                report.advancePopulationReportTemplate(db.additionalReportSeven()); // Print report
                break;

            /*If user type invalid input the system will show error*/
            default:
                System.out.println("Invalid input error.");
                break;
        }
    }


}