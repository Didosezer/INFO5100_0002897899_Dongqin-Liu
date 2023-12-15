import java.io.*;
public class Main {
   public static void serialize(Object obj, String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
        }
    }
    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
    }
    public static void main(String[] args) {
        // Create shape instances
        Shape triangle1 = new Triangle(10, 5);
        Shape rectangle1 = new Rectangle(10, 5);
        Shape circle1 = new Circle(8);
        Shape square1 = new Square(9);

        // Serialize the objects
        try {
            serialize(triangle1, "triangle1.ser");
            serialize(rectangle1, "rectangle1.ser");
            serialize(circle1, "circle1.ser");
            serialize(square1, "square1.ser");

            // Deserialize the objects
            Shape deserializedTriangle = (Shape) deserialize("triangle1.ser");
            Shape deserializedRectangle = (Shape) deserialize("rectangle1.ser");
            Shape deserializedCircle = (Shape) deserialize("circle1.ser");
            Shape deserializedSquare = (Shape) deserialize("square1.ser");

            System.out.println("Deserialized Triangle Area: " + deserializedTriangle.calArea());
            System.out.println("Deserialized Rectangle Area: " + deserializedRectangle.calArea());
            System.out.println("Deserialized Circle Area: " + deserializedCircle.calArea());
            System.out.println("Deserialized Square Area: " + deserializedSquare.calArea());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
