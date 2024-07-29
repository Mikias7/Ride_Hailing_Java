/**
 * @author Mikias Tadele
 * @version May 10 2024
 * This program checks if the rider's route is a subclass of driver's route and pairs the
 * driver and rider if the condition is satisfied.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pairing {
    // Attributes
    private static Set<Character> driverRoute;
    private static Set<Character> riderRoute;

    // Composition relationship with Driver and Rider objects
    private Driver driver;
    private Rider rider;

    /**
     * Constructor for Pairing.
     *
     * @param driver The driver to pair.
     * @param rider  The rider to pair.
     */
    public Pairing(Driver driver, Rider rider) {
        this.driver = driver;
        this.rider = rider;
    }

    //default constructor 
    public Pairing() {
        this.driver = null;
        this.rider = null;
    }


    // Method to initialize driverRoute and riderRoute sets
    public void initializeRoutes() {
        // Array containing letters a-z
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        int index1 = alphabet.indexOf(driver.getStartLocation());
        int index2 = alphabet.indexOf(driver.getEndLocation());
        // Set containing Driver route
        driverRoute = new HashSet<>();
        for (int i = index1; i <= index2; i++) {
            driverRoute.add(alphabet.get(i));
        }

        int index3 = alphabet.indexOf(rider.getStartLocation());
        int index4 = alphabet.indexOf(rider.getEndLocation());
        // Set containing Rider route
        riderRoute = new HashSet<>();
        for (int i = index3; i <= index4; i++) {
            riderRoute.add(alphabet.get(i));
        }

        System.out.println("Driver route: " + driverRoute);
        System.out.println("Rider route: " + riderRoute);
    }

    // Method to match driver and rider
    public boolean match() {
        // Check if driver and rider have the same route
        if (driverRoute != null && riderRoute != null && driverRoute.containsAll(riderRoute)) {
            return true;
        } else {
            return false;
        }
    }
}


