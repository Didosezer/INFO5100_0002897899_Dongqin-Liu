public class Triangle extends Shape{
   static {
        name = "Triangle";
    }
    public static String getName() {
        return "Triangle";
    }
    private double base;
    private double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calArea() {
         return  0.5*base* height;}
    @Override
    public double calPerimeter() {
        return 3* base;
    }
}
