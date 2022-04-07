package com.napier.sem;

import java.sql.SQLException;
import java.sql.SQLOutput;

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
//        db.disconnect();
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
        for(int i=1; i<=32;i++){
        System.out.println("Choose Report : "+i);
        // Call chooseMenu method
        chooseMenu(i);
        }

    }

    /**
     * method for choose report items
     */
    private void chooseMenu(int num) throws SQLException {
        // Create report object
        Report report = new Report();
        //Define report title
        String reportTitle = null;
        // Choose Report item by using switch
        switch (num) {
            /*If user choose 1 the system will print all the countries in the world
            organised by largest population to smallest*/
            case 1:
                reportTitle = "All the countries in the world organised by largest population to smallest";
                System.out.println(reportTitle);
                report.printCountryReport(db.countryReportOne(),"CountryReportOne.md",reportTitle);
                report.countryReportTemplate(db.countryReportOne()); // Print report
                break;

            /*If user choose 2 the system will print all the countries in a continent
             organised by largest population to smallest*/
            case 2:
                reportTitle = "All the countries in a continent organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter continent: Asia");
                report.printCountryReport(db.countryReportTwo("Asia"),"CountryReportTwo.md",reportTitle);
                report.countryReportTemplate(db.countryReportTwo("Asia")); // Print report
                break;

            /*If user choose 3 the system will print all the countries in a region
            organised by largest population to smallest*/
            case 3:
                reportTitle= "All the countries in a region organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter region: Eastern Asia");
                report.printCountryReport(db.countryReportThree("Eastern Asia"),"CountryReportThree.md",reportTitle);
                report.countryReportTemplate(db.countryReportThree("Eastern Asia"));// Print report
                break;

            /*If user choose 4 the system will print the top N populated countries in the world*/
            case 4:
                reportTitle="The top N populated countries in the world";
                System.out.println(reportTitle);
                System.out.println("Enter number: 5");
                report.printCountryReport(db.countryReportFour(5),"CountryReportFour.md",reportTitle);
                report.countryReportTemplate(db.countryReportFour(5));// Print report
                break;

            /*If user choose 5 the system will print the top N populated countries in a continent where N is provided by the user.*/
            case 5:
                reportTitle="The top N populated countries in a continent where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter continent: Asia");
                System.out.println("Enter number: 5");
                report.printCountryReport(db.countryReportFive("Asia",5),"CountryReportFive.md",reportTitle);
                report.countryReportTemplate(db.countryReportFive("Asia",5));// Print report
                break;

            /*If user choose 6 the system will print Not available in this version*/
            case 6:
                reportTitle="The top N populated countries in a region where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter region: Eastern Asia");
                System.out.println("Enter number: 7");
                report.printCountryReport(db.countryReportSix("Eastern Asia",7),"CountryReportSix.md",reportTitle);
                report.countryReportTemplate(db.countryReportSix("Eastern Asia",7));// Print report
                break;

            /*If user choose 7 the system will print all the cities in the world
            organised by largest population to smallest*/
            case 7:
                reportTitle="All the cities in the world organised by largest population to smallest";
                System.out.println(reportTitle);
                report.printCityReport(db.cityReportOne(),"CityReportOne.md",reportTitle);
                report.cityReportTemplate(db.cityReportOne());// Print report
                break;

            /*If user choose 8 the system will print all the cities in a continent
            organised by largest population to smallest*/
            case 8:
                reportTitle="All the cities in a continent organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter Continent: Asia");
                report.printCityReport(db.cityReportTwo("Asia"),"CityReportOne.md",reportTitle);
                report.cityReportTemplate(db.cityReportTwo("Asia")); // Print report
                break;

            /*If user choose 9 the system will print all the cities in a region
            organised by largest population to smallest*/
            case 9:
                reportTitle="All the cities in a region organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter Region: Eastern Asia");
                report.printCityReport(db.cityReportThree("Eastern Asia"),"CityReportThree.md",reportTitle);
                report.cityReportTemplate(db.cityReportThree("Eastern Asia")); // Print report
                break;

            /*If user choose 10 the system will print all the cities in a country
            organised by largest population to smallest*/
            case 10:
                reportTitle="All the cities in a country organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter Country: Thailand");
                report.printCityReport(db.cityReportFour("Thailand"),"CityReportFour.md",reportTitle);
                report.cityReportTemplate(db.cityReportFour("Thailand")); // Print report
                break;

            /*If user choose 11 the system will print all the cities in a district organised by largest population to smallest.*/
            case 11:
                reportTitle="All the cities in a district organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter District: Mandalay");
                report.printCityReport(db.cityReportFive("Mandalay"),"CityReportFive.md",reportTitle);
                report.cityReportTemplate(db.cityReportFive("Mandalay")); // Print report
                break;

            /*If user choose 12 the system will print the top N populated cities in the world where N is provided by the user.*/
            case 12:
                reportTitle="The top N populated cities in the world where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter Number: 8");
                report.printCityReport(db.cityReportSix(8),"CityReportSix.md",reportTitle);
                report.cityReportTemplate(db.cityReportSix(8)); // Print report
                break;

            /*If user choose 13 the system will print the top N populated cities in a continent*/
            case 13:
                reportTitle="The top N populated cities in a continent";
                System.out.println(reportTitle);
                System.out.println("Enter continent: Asia");
                System.out.println("Enter number: 7");
                report.printCityReport(db.cityReportSeven(7,"Asia"),"CityReportSeven.md",reportTitle);
                report.cityReportTemplate(db.cityReportSeven(7,"Asia"));// Print report
                break;

            /*If user choose 14 the system will print the top N populated cities in a region where N is provided by the user*/
            case 14:
                reportTitle="The top N populated cities in a region where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter region: Asia");
                System.out.println("Enter number: 4");
                report.printCityReport(db.cityReportEight(4,"Eastern Asia"),"CityReportEight.md",reportTitle);
                report.cityReportTemplate(db.cityReportEight(4,"Eastern Asia"));// Print report
                break;

            /*If user choose 15 the system will print the top N populated cities in a country where N is provided by the user*/
            case 15:
                reportTitle="The top N populated cities in a country where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter country: china");
                System.out.println("Enter number: 6");
                report.printCityReport(db.cityReportNine(6,"China"),"CityReportNine.md",reportTitle);
                report.cityReportTemplate(db.cityReportNine(6,"China"));// Print report
                break;

            /*If user choose 16 the system will print the top N populated cities in a district where N is provided by the user*/
            case 16:
                reportTitle="the top N populated cities in a district where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter district: Hubei");
                System.out.println("Enter number: 3");
                report.printCityReport(db.cityReportten(3,"Hubei"),"CityReportTen.md",reportTitle);
                report.cityReportTemplate(db.cityReportten(3,"Hubei"));// Print report
                break;

            /*If user choose 17 the system will print all the capital cities in the world
             organised by largest population to smallest*/
            case 17:
                reportTitle="All the capital cities in the world organised by largest population to smallest";
                System.out.println(reportTitle);
                report.printCapitalCityReport(db.capitalCityReportOne(),"CapitalCityReportOne.md",reportTitle);
                report.capitalCityReportTemplate(db.capitalCityReportOne()); // Print report
                break;

            /*If user choose 18 the system will print all the capital cities in a continent organised by largest population to smallest*/
            case 18:
                reportTitle="All the capital cities in a continent organised by largest population to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter continent: Asia");
                report.printCapitalCityReport(db.capitalCityReportTwo("Asia"),"CapitalCityReportTwo.md",reportTitle);
                report.capitalCityReportTemplate(db.capitalCityReportTwo("Asia")); // Print report
                break;

            /*If user choose 19 the system will print all the capital cities in a region organised by largest to smallest*/
            case 19:
                reportTitle="All the capital cities in a region organised by largest to smallest";
                System.out.println(reportTitle);
                System.out.println("Enter region: South America");
                report.printCapitalCityReport(db.capitalCityReportThree("South America"),"CapitalCityReportThree.md",reportTitle);
                report.capitalCityReportTemplate(db.capitalCityReportThree("South America")); // Print report
                break;

            /*If user choose 20 the system will print the top N populated capital cities in the world where N is provided by the user*/
            case 20:
                reportTitle="The top N populated capital cities in the world where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter no: 7 ");
                report.printCapitalCityReport(db.capitalCityReportFour(7),"CapitalCityReportFour.md",reportTitle);
                report.capitalCityReportTemplate(db.capitalCityReportFour(7)); // Print report
                break;

            /*If user choose 21 the system will print the top N populated capital cities in a continent where N is provided by the user*/
            case 21:
                reportTitle="The top N populated capital cities in a continent where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter Continent: Europe ");
                System.out.println("Enter number: 7 ");
                report.printCapitalCityReport(db.capitalCityReportFive("Europe",5),"CapitalCityReportFive.md",reportTitle);
                report.capitalCityReportTemplate(db.capitalCityReportFive("Europe",5)); // Print report
                break;

            /*If user choose 22 the system will print the top N populated capital cities in a region where N is provided by the user*/
            case 22:
                reportTitle="The top N populated capital cities in a region where N is provided by the user";
                System.out.println(reportTitle);
                System.out.println("Enter Region: North America ");
                System.out.println("Enter number: 4 ");
                report.printCapitalCityReport(db.capitalCityReportSix("North America",4),"CapitalCityReportSix.md",reportTitle);
                report.capitalCityReportTemplate(db.capitalCityReportSix("North America",4)); // Print report
                break;

            /*If user choose 23the system will print the population of people,
            people living in cities, and people not living in cities in each continent*/
            case 23:
                reportTitle="The population of people, people living in cities, and people not living in cities in each continent";
                System.out.println(reportTitle);
                report.printPopulationReport(db.populationReportOne(),"PopulationReportOne.md",reportTitle);
                report.populationReportTemplate(db.populationReportOne()); // Print report
                break;

            /*If user choose 24 the system will print the population of people,
            people living in cities, and people not living in cities in each region*/
            case 24:
                reportTitle="The population of people, people living in cities, and people not living in cities in each region";
                System.out.println(reportTitle);
                report.printPopulationReport(db.populationReportTwo(),"PopulationReportTwo.md",reportTitle);
                report.populationReportTemplate(db.populationReportTwo()); // Print report
                break;

            /*If user choose 25 the system will print the population of people, people living in cities, and people not living in cities in each country*/
            case 25:
                reportTitle="The population of people, people living in cities, and people not living in cities in each country";
                System.out.println(reportTitle);
                report.printPopulationReport(db.populationReportThree(),"PopulationReportThree.md",reportTitle);
                report.populationReportTemplate(db.populationReportThree()); // Print report
                break;

            /*If user choose 26 the system will print the population of the world*/
            case 26:
                reportTitle="The population of the world";
                System.out.println(reportTitle);
                report.printSimplePopulationReport(db.additionalReportOne(),"AdditionalReportOne.md",reportTitle);
                report.simplePopulationReportTemplate(db.additionalReportOne()); // Print report
                break;

            /*If user choose 27 the system will the population of a continent*/
            case 27:
                reportTitle="The population of a continent";
                System.out.println(reportTitle);
                System.out.println("Enter Continent: Europe");
//                String contt = sc.nextLine();
                report.printSimplePopulationReport(db.additionalReportTwo("Europe"),"AdditionalReportTwo.md",reportTitle);
                report.simplePopulationReportTemplate(db.additionalReportTwo("Europe"));// Print report
                break;

            /*If user choose 28 the system will the population of a region*/
            case 28:
                reportTitle="The population of a region";
                System.out.println(reportTitle);
                System.out.println("Enter Region: North America");
//                String regg = sc.nextLine();
                report.printSimplePopulationReport(db.additionalReportThree("North America"),"AdditionalReportThree.md",reportTitle);
                report.simplePopulationReportTemplate(db.additionalReportThree("North America"));// Print report
                break;

            /*If user choose 29 the system will the population of a country*/
            case 29:
                reportTitle="The population of a country";
                System.out.println(reportTitle);
                System.out.println("Enter Country: United Kingdom");
//                String cou = sc.nextLine();
                report.printSimplePopulationReport(db.additionalReportFour("United Kingdom"),"AdditionalReportFour.md",reportTitle);
                report.simplePopulationReportTemplate(db.additionalReportFour("United Kingdom"));// Print report
                break;

            /*If user choose 30 the system will print the population of a district*/
            case 30:
                reportTitle="The population of a district";
                System.out.println(reportTitle);
                System.out.println("Enter District: Hubei");
//                String cou = sc.nextLine();
                report.printSimplePopulationReport(db.additionalReportFive("Hubei"),"AdditionalReportFive.md",reportTitle);
                report.simplePopulationReportTemplate(db.additionalReportFive("Hubei"));// Print report
                break;

            /*If user choose 31 the system will print the population of a city*/
            case 31:
                reportTitle="The population of a city";
                System.out.println(reportTitle);
                System.out.println("Enter City: Boston");
//                String cou = sc.nextLine();
                report.printSimplePopulationReport(db.additionalReportSix("Boston"),"AdditionalReportSix.md",reportTitle);
                report.simplePopulationReportTemplate(db.additionalReportSix("Boston"));// Print report
                break;

            /*If user choose 32 the system will print  the number of people
            who speak Chinese, English, Hindi, Spanish or Arabic in the world*/
            case 32:
                reportTitle="The number of people who speak Chinese, English, Hindi, Spanish or Arabic in the world.";
                System.out.println(reportTitle);
                report.printAdvancePopulationReport(db.additionalReportSeven(),"AdditionalReportSeven.md",reportTitle);
                report.advancePopulationReportTemplate(db.additionalReportSeven()); // Print report
                break;

            /*If user type invalid input the system will show error*/
            default:
                System.out.println("Invalid input error.");
                break;
        }
    }


}