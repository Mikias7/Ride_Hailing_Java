/**
 * @author Mikias Tadele
 * @version 10 May 2024
 * Class representing a driver. Inherits from superclass Users
 */

public class Driver extends Users {
    // Attributes
    private String car;
    private String licensePlate;
    private String carColor;
    private int roomForPeople;
    private static int totalDrivers = 1;

    /**
     * Constructor for Driver.
     *
     * @param name          The name of the driver.
     * @param age           The age of the driver.
     * @param phoneNumber   The phone number of the driver.
     * @param startLocation The starting location of the driver.
     * @param endLocation   The ending location of the driver.
     * @param car           The car of the driver.
     * @param carColor      The color of the car.
     * @param licensePlate  The license plate of the car.
     * @param roomForPeople The capacity of the car.
     */

     // Constructor
    public Driver(String name, int age, String phoneNumber, char startLocation, char endLocation, String car,
                  String carColor, String licensePlate, int roomForPeople) {
        super(name, age, phoneNumber, startLocation, endLocation);
        this.car = car;
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.roomForPeople = roomForPeople;
        totalDrivers++;
    }

	 // Default constructor
	 public Driver() {
        this("",0,"1234567890",'a','a',"","","",0);
    }

    // Getters and Setters
    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getRoomForPeople() {
        return roomForPeople;
    }

    public void setRoomForPeople(int roomForPeople) {
        this.roomForPeople = roomForPeople;
    }

    // Other methods

    // Overridden custom method
    @Override
    public int calculateCost() {
        int distance = calculateDistance();
        int gasMoney = (distance * 2) - 5;
        return gasMoney;
    }

    // Other Custom method
    public int roomForPet(){
        int petRoom = this.roomForPeople - 1;
        return petRoom;
    }

    /**
     * toString
     *
     * @return String representation.
     */

     //toString method
    @Override
    public String toString() {
        int gasMoney = calculateCost();
        int petRoom = roomForPet();
        return String.format("%s%n" + "Driver Car: %s%n" + "License Plate: %s%n" + "Room for people: %d%n"+ "Room for Pet: %d%n" + "Gas money = $%d",
                             super.toString(), car,
                            licensePlate, roomForPeople,petRoom,gasMoney);
    }
}
