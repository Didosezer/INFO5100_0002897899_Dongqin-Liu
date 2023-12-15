public class Car {
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private double mileage;
    private Integer numOFDriven;
    private double price;
    private double MGP;

    // Constructor
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = 0.0;
        this.numOFDriven = 0;
        this.price = 0.0;  // Default price
        this.MGP = 0.0;  // Default MGP

        System.out.println("A new car, " + this.brand + " " + this.model + ", created!");
    }
    // Methods
    public void drive() {System.out.println("The car is driving");}
    public void brake() {System.out.println("The car is braking.");}
    public void stop() {System.out.println("The car has stopped.");}

   // Instances
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Prius", 2019, "Gray");
        car1.drive();
        car1.brake();
        car1.stop();

        Car car2 = new Car("Lexus", "SUV", 2020, "Blue");
        Car car3 = new Car("Tesla", "Y", 2022, "Black");
    }
}
