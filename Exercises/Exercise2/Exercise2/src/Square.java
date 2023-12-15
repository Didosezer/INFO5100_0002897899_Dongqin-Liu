class Square extends Rectangle {
    static {
        name = "Square";
    }
    public static String getName() {
        return "Square";
    }
    public Square(double side) {
        super(side, side);
    }

}