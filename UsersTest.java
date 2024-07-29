/**
 * @author Mikias Tadele
 * @version 10 May 2024
 * Class to test the functionality of the application.
 */

import java.util.Scanner;

public class UsersTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test Driver class
        System.out.println("Driver Registration...");
        Driver driver = createDriver(scanner);
        System.out.println("\nDriver Details:");
        System.out.println(driver);

        //uncomment to test default driver
        //System.out.println("--------------------------------");
        //Driver defaultDriver = new Driver();
        //System.out.println("default driver: " + defaultDriver);

        // Test Rider class
        System.out.println("\nRider Registration...");
        Rider rider = createRider(scanner);
        System.out.println("\nRider Details:");
        System.out.println(rider);

        //uncomment to test default rider
        //System.out.println("--------------------------------");
        //Rider defaultRider = new Rider();
        //System.out.println("default rider: " + defaultRider);

        // Test Pairing class
        System.out.println("\nInitializing Routes...");
        Pairing pairing = new Pairing(driver, rider);
        pairing.initializeRoutes();
        System.out.println("\nRoutes Initialized.");

        // Test match method from Pairing class
        System.out.println("\nChecking if Driver and Rider have the same route...");
        boolean isMatch = pairing.match();
        if (isMatch) {
            System.out.println("Driver and Rider have the same route.");
            System.out.println("------------------------");
            System.out.println("Driver found!");
            System.out.println(" ");
            System.out.printf("Name: %s%n"+ "Phone number: %s%n" + "Driver car: %s %s%n"+ "Payment due = $%d",
                            driver.getName(),
                            driver.getPhoneNumber(),
                            driver.getCarColor(),
                            driver.getCar(),
                            rider.calculateCost());
        } else {
            System.out.println("Driver and Rider don't have the same route.");
            System.out.println("No driver found :(");
        }

    }

    // Helper method to create a Driver object
    private static Driver createDriver(Scanner scanner) {
        System.out.print("Enter driver's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter driver's age (0-100): "); //Age has to be between 0-100
        int age = scanner.nextInt();
        System.out.print("Enter driver's phone number (10-digit): "); //Phone number has to be 10 digits
        String phoneNumber = scanner.next();
        scanner.nextLine();
        System.out.print("Enter driver's start location (a-z) enter 1 letter only: "); //You can't enter a letter for start location that comes after the letter for end location
        char startLocation = scanner.next().charAt(0);
        System.out.print("Enter driver's end location (a-z) enter 1 letter only: "); //End letter must always be a letter after start location letter
        char endLocation = scanner.next().charAt(0);
        scanner.nextLine(); //  newline
        System.out.print("Enter driver's car: ");
        String car = scanner.nextLine();
        System.out.print("Enter driver's car color: ");
        String carColor = scanner.nextLine();
        System.out.print("Enter driver's license plate (any string): ");
        String licensePlate = scanner.nextLine();
        System.out.print("Enter driver's room for people (any int): ");
        int roomForPeople = scanner.nextInt();
        return new Driver(name, age, phoneNumber, startLocation, endLocation, car, carColor, licensePlate, roomForPeople);
    }

    // Helper method to create a Rider object
    private static Rider createRider(Scanner scanner) {
        System.out.print("Enter rider's name: ");
        String name = scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Enter rider's age (0-100): ");
        int age = scanner.nextInt();
        System.out.print("Enter rider's phone number (10-digit): ");
        String phoneNumber = scanner.next();
        scanner.nextLine();
        System.out.print("Enter rider's ID (any int): ");
        int id = scanner.nextInt();
        System.out.print("Enter rider's passenger rating (any float): ");
        float passengerRating = scanner.nextFloat();
        scanner.nextLine(); // newline
        System.out.print("Enter rider's start location (a-z) enter 1 letter only: ");
        char startLocation = scanner.next().charAt(0);
        System.out.print("Enter rider's end location (a-z) enter 1 letter only: ");
        char endLocation = scanner.next().charAt(0);
        System.out.print("Enter number of riders (any int): ");
        int numberOfRiders = scanner.nextInt();
        scanner.nextLine(); // newline
        System.out.print("Enter rider's payment method (credit card type): "); //example chase
        String paymentMethod = scanner.nextLine();
        return new Rider(name, age, phoneNumber, startLocation, endLocation, id, passengerRating, numberOfRiders, paymentMethod);
    }

    

    
}

