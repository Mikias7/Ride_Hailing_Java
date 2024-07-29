/**
 * @author Mikias Tadele
 * @version 10 May 2024
 * Class representing a rider. Inherits from superclass Users.
 */

public class Rider extends Users {
    // Attributes
    private int numberOfRiders;
    private String paymentMethod;
    private int id;
    private float passengerRating;

    /**
     * Constructor for Rider.
     *
     * @param name            The name of the rider.
     * @param age             The age of the rider.
     * @param phoneNumber     The phone number of the rider.
     * @param id              The ID of the rider.
     * @param passengerRating The passenger rating of the rider.
     * @param startLocation   The starting location of the rider.
     * @param endLocation     The ending location of the rider.
     * @param numberOfRiders  The number of riders.
     * @param paymentMethod   The payment method of the rider.
     */

     // Constructor
    public Rider(String name, int age, String phoneNumber,char startLocation,char endLocation, int id, float passengerRating, 
                 int numberOfRiders, String paymentMethod) {
        super(name, age, phoneNumber, startLocation, endLocation);
        this.id = id;
        this.passengerRating = passengerRating;
        this.numberOfRiders = numberOfRiders;
        this.paymentMethod = paymentMethod;
    }

    // Default constructor
     public Rider() {
        this("",0,"1234567890",'a','a',0,0.0f,0,"");
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPassengerRating() {
        return passengerRating;
    }

    public void setPassengerRating(float passengerRating) {
        this.passengerRating = passengerRating;
    }

    public int getNumberOfRiders() {
        return numberOfRiders;
    }

    public void setNumberOfRiders(int numberOfRiders) {
        this.numberOfRiders = numberOfRiders;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Other methods

    // Overridden custom method
    @Override
    public int calculateCost() {
        // Custom implementation for Rider
        int distance = calculateDistance();
        int cost = distance * 2;
        return cost;
    }

    // Other custom method
    public boolean optInText(){
        return true;
    }

    /**
     * toString
     *
     * @return String representation.
     */

     // toString method
    @Override
    public String toString() {
        int cost = calculateCost();
        boolean optInText = optInText();
        return String.format("%s%n" + "Number of Riders: %d%n" + "opt in text: %b%n" + "Payment Method: %s%n" + "Price: $%d", super.toString(), 
                        numberOfRiders,optInText,
                        paymentMethod,cost);
    }
}
