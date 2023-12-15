
    public class Mountain {
        private String name;
        private double height;
        private String location;
        private String mountainRange;
        private String type; //Rock, volcano
        private String gradeLevel; // 'AAAAA' as highest
        private boolean feeFree;
        private double fee;

        // Constructor
        public Mountain(String name, double height, String location, String mountainRange, String type, String gradeLevel, boolean feeFree, Double fee) {
            this.name = name;
            this.height = height;
            this.location = location;
            this.mountainRange = mountainRange;
            this.type = type;
            this.gradeLevel = gradeLevel;
            this.feeFree = feeFree;
            this.fee = fee;

            System.out.println("A new mountain named '" + this.name + "' has been created!");
        }
        // Methods
        public void isDifficult() {
            System.out.println("Climbing Mountain: " + this.name + "Height" +  this.height + "is Difficult");

        }
        public boolean isHighAltitude() {
            return height > 4000;
        }
        public double getDiscountedFee() {
            if (feeFree) {
                return 0.0;  // no fee
            } else {
                return fee * 0.5;  // 50% discount
            }
        }

        // Instances
        public static void main(String[] args) {
            // Creating three instances of the Mountain class
            Mountain everest = new Mountain("Mount Everest", 8848.86, "Nepal/Tibet", "Himalayas", "Rock", "AAAAA", true, 0.00);
            Mountain huang = new Mountain("Mount Huang", 4000, "China", "Huang", "Rock", "AAAAA", false, 200.00);
            Mountain alumRock = new Mountain("Mount AlumRock", 500, "US", "Null", "Rock", "AA", true, 0.00);

            System.out.println(everest.name + " is high altitude: " + everest.isHighAltitude());
            System.out.println(huang.name + " is high altitude: " + huang.isHighAltitude());

        }
    }




