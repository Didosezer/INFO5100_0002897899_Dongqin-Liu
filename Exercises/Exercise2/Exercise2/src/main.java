public class main {
    public static void main(String[] args) {
        Shape triangle1 = new Triangle(10, 5);
        Shape rectangle1 = new Rectangle(10, 5);
        Shape circle1 = new Circle(8);
        Shape square1 = new Square(9);

        System.out.println(Triangle.getName());
        System.out.println(Rectangle.getName());
        System.out.println(Circle.getName());
        System.out.println(Square.getName());

        System.out.println("Area of triangle: " + triangle1.calArea());
        System.out.println("Area of rectangle: " + rectangle1.calArea());
        System.out.println("Area of circle: " + circle1.calArea());
        System.out.println("Area of square: " + square1.calArea());

        System.out.println("Perimeter of triangle: " + triangle1.calPerimeter());
        System.out.println("Perimeter of rectangle: " + rectangle1.calPerimeter());
        System.out.println("Perimeter of circle: " + circle1.calPerimeter());
        System.out.println("Perimeter of square: " + square1.calPerimeter());
    }

}