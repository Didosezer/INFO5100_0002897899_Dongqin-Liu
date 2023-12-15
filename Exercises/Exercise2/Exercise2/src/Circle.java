class Circle extends Shape {
    private double radius;
        static {name = "Circle"; }
    public static String getName() {
        return "Circle";
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calPerimeter() {
        return 2 * Math.PI * radius;
    }
}
