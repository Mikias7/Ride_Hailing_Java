/**
 * @author Mikias Tadele
 * @version 10 May 2024
 * Abstract class representing Users.
 */

import java.util.ArrayList;
import java.util.regex.Pattern;


public abstract class Users {
    // Attributes
    private String name;
    private int age;
    private String phoneNumber;
    private char startLocation;
    private char endLocation;
    private final Pattern phonePattern = Pattern.compile("\\d{10}");

    /**
     * Constructor for Users.
     *
     * @param name          The name of the user.
     * @param age           The age of the user.
     * @param phoneNumber   The phone number of the user.
     * @param startLocation The starting location of the user.
     * @param endLocation   The ending location of the user.
     */
    
     // Constrcutor
    public Users(String name, int age, String phoneNumber, char startLocation, char endLocation) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100.");
        }
        if (!phonePattern.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Phone number must be a 10-digit number.");
        }
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100.");
        }
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phonePattern.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Phone number must be a 10-digit number.");
        }
        this.phoneNumber = phoneNumber;
    }

    public char getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(char startLocation) {
        this.startLocation = startLocation;
    }

    public char getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(char endLocation) {
        this.endLocation = endLocation;
    }

    // Other methods

    // Abstract method to be overridden in subclasses
    public abstract int calculateCost();

    // Custom final method
    public final void printDetails() {
        System.out.println(toString());
    }

    // Custom method to calculate distance 
    public int calculateDistance() {
         ArrayList<Character> alphabet2 = new ArrayList<>();
        for (char c2 = 'a'; c2 <= 'z'; c2++) {
            alphabet2.add(c2);
        }
        int distance = 1 + alphabet2.indexOf(endLocation) - alphabet2.indexOf(startLocation);
        return distance;
    }

    /**
     * toString
     *
     * @return String representation.
     */

     //toString method
    @Override
    public String toString() {
        int distance = calculateDistance();
        return String.format("name: %s%n" + "age: %d%n" + "phone number: %s%n" + "start: %s%n" + "end: %s%n" + "Distance: %d",
                name, age, phoneNumber, startLocation, endLocation,distance);
    }
}
