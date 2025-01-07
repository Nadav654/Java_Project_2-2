import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Global variable for managing real estate properties
    static RealEstateManager realEstateManager;

    public static void main(String[] args) {
        // Initialize the RealEstateManager with a name and load properties from DataManager
        realEstateManager = new RealEstateManager("Anthony Noto");
        realEstateManager.setProperties(DataManager.inputData());

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Infinite loop for displaying the menu and handling user choices
        while (true) {
            printMenu(); // Display the menu options
            choice = scanner.nextInt(); // Get the user's choice
            switch (choice) {
                case 1:
                    propertiesList(scanner); // Search properties by price
                    break;
                case 2:
                    financialReport(); // Display a financial report
                    break;
                case 3:
                    commercialYield(); // Calculate total commercial yield
                    break;
                case 4:
                    propertiesByCity(scanner); // Search properties by city
                    break;
                case 5:
                    numberOfCities(); // Count and display unique cities
                    break;
                case -1:
                    // Exit the program
                    System.out.println("Exiting Program...");
                    scanner.close();
                    return;
                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Displays the menu to the user
    public static void printMenu() {
        System.out.println("\n--- Real Estate Manager ---");
        System.out.println("1   >   Search Properties");
        System.out.println("2   >   Financial Report");
        System.out.println("3   >   Commercial Yield");
        System.out.println("4   >   Properties by City");
        System.out.println("5   >   Count Cities");
        System.out.println("-1  >   Exit");
        System.out.print("Enter your choice: ");
    }

    // Handles property search by maximum price
    public static void propertiesList(Scanner scanner) {
        System.out.println("Enter max price: ");
        double maxPrice = scanner.nextDouble(); // Get max price input from the user
        try {
            // Check if the price is valid
            if (maxPrice < 0) {
                throw new PriceException("Price cannot be negative");
            }

            // Get and display properties within the max price range
            ArrayList<Property> sortedProperties = realEstateManager.getPropertiesByPrice(maxPrice);
            for (Property property : sortedProperties) {
                System.out.println(property);
            }
        } catch (PriceException e) {
            // Handle invalid price input
            System.out.println("Error " + e.getMessage());
        }
    }

    // Generates and displays a financial report for all properties
    public static void financialReport() {
        for (Property property : realEstateManager.getProperties()) {
            System.out.print(property.getAddress() + ", ");
            property.taxIt(); // Call taxIt() for each property
        }
    }

    // Calculates and displays the total yield for all commercial properties
    public static void commercialYield() {
        double totalYield = 0;
        for (Property property : realEstateManager.getProperties()) {
            if (property instanceof Commercial) {
                totalYield += ((Commercial) property).getYield();
            }
        }
        System.out.println("Total yield for all Commercials: " + totalYield);
    }

    // Searches and displays properties in a specified city
    public static void propertiesByCity(Scanner scanner) {
        System.out.println("Enter city name: ");
        String cityName = scanner.nextLine(); // Get city name input

        // Normalize the city name for case-insensitive search
        cityName = cityName.replace("-", " ").toLowerCase();
        for (Property property : realEstateManager.getProperties()) {
            if (property.getAddress().toLowerCase().contains(cityName)) {
                System.out.println(property);
            }
        }
    }

    // Counts and displays the number of unique cities
    public static void numberOfCities() {
        int totalUniqueCities = 0;
        HashMap<Integer, String> uniqueCitiesMap = new HashMap<>(); // Using HashMap for unique cities
        for (Property property : realEstateManager.getProperties()) {
            if (!uniqueCitiesMap.containsValue(property.getAddress())) {
                totalUniqueCities++;
                uniqueCitiesMap.put(totalUniqueCities, property.getAddress());
            }
        }
        System.out.println("Number of unique cities: " + totalUniqueCities);
    }
}
