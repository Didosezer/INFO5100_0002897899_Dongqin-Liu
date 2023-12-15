public class Animal {
    private String species;
    private String habitat;
    private double weight;
    private int age;
    private boolean isEndangered;
    private String diet;  // e.g., "Herbivore", "Carnivore"
    private String region;  // e.g., "Africa"
    private double temperature;  // body temperature in Celsius

    // Constructor
    public Animal(String species, String habitat, String diet, String region) {
        this.species = species;
        this.habitat = habitat;
        this.diet = diet;
        this.weight = 0.0;
        this.age = 0;
        this.isEndangered = false;
        this.region = region;
        this.temperature = 37.0;

        System.out.println("A new animal, " + this.species + " from " + this.region + " created!");
    }
    // Methods
    public void eat(String food) {System.out.println("The " + this.species + " is eating " + food + ".");}
    public void run() {System.out.println("The " + this.species + " is running.");}
    public void sleep() {System.out.println("The " + this.species + " is sleeping.");}

    // Instances
    public static void main(String[] args) {
        Animal lion = new Animal("Lion", "Savannah", "Carnivore", "Africa");
        lion.eat("meat");
        lion.run();
        lion.sleep();

        Animal elephant = new Animal("Elephant", "Jungle", "Herbivore", "Asia");
        Animal Bird = new Animal("Bird", "Forests", "Carnivore", "Europe");
    }
}
