public class Smartphone {
    private String brand;
    private String model;
    private String color;
    private Double screenSize; // in inches
    private Integer storage; // in GB
    private Double price;
    private Double weight;
    private Boolean hasDualSim;

    // Constructor
    public Smartphone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.screenSize = 6.1;
        this.price = 0.00;
        this.color = "Black";
        this.storage = 64;
        this.weight = 150.0;  // Default weight in grams
        this.hasDualSim = false; // Default dual sim capability

        System.out.println("A new smartphone named '" + this.brand + " " + this.model + "'created!");
    }
    // Methods
    public void call() {
        System.out.println("Calling" );
    }
    public void surfing(String website) {System.out.println("Surfing ");}
    public void voicemail() {
        System.out.println("Checking voicemail");
    }

    // Class Camera
    public class Camera {
        private String brand; // supplier
        private Double cost; // cost of buying
        private Double resolution;  // in MP
        private String cameraType;  // "front", "back"
        private Integer numOfLenses;
        private String videoQuality;  //
        private String zoomLevel;  // e.g., "2x Zoom"
        private boolean wideAngle;
        // Constructor
        public Camera() {
            this.brand = "Generic";
            this.cost = 0.00;
            this.resolution = 12.0;
            this.cameraType = "back";
            this.numOfLenses = 1;
            this.videoQuality = "HD";
            this.zoomLevel = "1x";
            this.wideAngle = false;

            System.out.println("A new " + cameraType + " camera created!");
        }
        // Methods
        public void photograph() {
            System.out.println(cameraType + " camera is taking a photograph.");
        }
        public void record() {System.out.println(cameraType + " camera is recording.." );}
        public void video() {
            System.out.println(cameraType + " camera is taking a video.");
        }
    }
    // Class Battery
    public class Battery {
        private Integer capacity;  // in mAh
        private Boolean removable;
        private String chargeSpeed;  // e.g., "Normal", "Fast"
        private String standbyTime;  // e.g., "24hours"
        private String batteryType;  // e.g., "Li-Ion"
        private String chargePortType;
        private Double weight;
        private String healthStatus;
    // Constructor
        public Battery() {
            this.capacity = 3000;  // Default values for battery attributes
            this.removable = false;
            this.chargeSpeed = "Normal";
            this.standbyTime = "24 hours";
            this.batteryType = "Li-Ion";
            this.chargePortType = "USB-C";
            this.weight = 150.0; //gram
            this.healthStatus = "Good";

            System.out.println("A new battery for the smartphone created!");
        }
        // Methods
        public void charge() {
            System.out.println("Charging the smartphone's battery...");
        }
        public void use() {
            System.out.println("Using the smartphone's battery...");
        }
        public void stop() {
            System.out.println("Stopping the smartphone's battery use...");
        }
    }
   // Instances
    public static void main(String[] args) {
        Smartphone Apple = new Smartphone("Apple", "iPhone 13");
        Smartphone Huawei = new Smartphone("Huawei", "Pro9");
        Smartphone Xiaomi = new Smartphone("Xiaomi", "Plus12");
        Apple.call();
        Apple.surfing("www.neu.edu");
        Apple.voicemail();

        Camera Camera1000 = Apple.new Camera();
        Camera Camera2000 = Apple.new Camera();
        Camera Camera3000 = Apple.new Camera();
        Camera1000.photograph();
        Camera1000.record();

        Battery Battery1 = Apple.new Battery();
        Battery Battery2 = Apple.new Battery();
        Battery Battery3 = Apple.new Battery();
        Battery1.charge();
    }
}