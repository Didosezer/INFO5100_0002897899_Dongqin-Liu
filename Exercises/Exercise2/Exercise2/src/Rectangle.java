class Rectangle extends Shape {
    private double length;
    private double width;
    static {
        name = "Rectangle";
    }
    public static String getName() {
        return "Rectangle";
    }
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double calArea() {
        return length * width;
    }
    @Override
    public double calPerimeter() {
        return 2 * (length + width);
    }

}
