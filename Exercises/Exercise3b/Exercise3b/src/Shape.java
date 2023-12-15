import java.io.Serializable;
import java.io.Serial;

abstract class Shape implements Serializable {
    public static String name = "Shape";
    public abstract double calArea();
    public abstract double calPerimeter();
    public static String getName() { return name; }
}

class Triangle extends Shape {
    private double base;
    private double height;
    static String name = "Triangle";

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calArea() {
        return 0.5 * base * height;
    }
    @Override
    public double calPerimeter() {
        return 3 * base; // Presuming an equilateral triangle
    }

    public static String getName() {
        return name;
    }
}

class Square extends Shape {
    private double side;
    static String name = "Square";

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calArea() {
        return side * side;
    }

    @Override
    public double calPerimeter() {
        return 4 * side;
    }

    public static String getName() {
        return name;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    static String name = "Rectangle";
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
    public static String getName() {
        return name;
    }
}
// Class Circle
class Circle extends Shape {
    private double radius;
    static String name = "Circle";
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
    public static String getName() {
        return name;
    }
}
