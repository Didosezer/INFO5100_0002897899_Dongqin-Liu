public class Book {
    private String ISBN;
    private String title;
    private String author;
    private Integer pages;
    private String category;
    private Integer copiesSold;
    private Boolean isBestSeller;
    private Double price;

    // Constructor
    public Book(String title, String author, String category) {
        this.ISBN = "ISBN000123";
        this.title = title;
        this.author = author;
        this.pages = 0;
        this.category = category;
        this.copiesSold = 0;
        this.isBestSeller = false;
        this.price = 0.0;
        System.out.println("A new book titled '" + title + "' by " + author + " has been added.");
    }
    // Methods
    public void sellCopy() {
        copiesSold++;
        System.out.println("A copy of " + title + " has been sold. Total copies sold: " + copiesSold);
    }

    public void BestSeller() {
        isBestSeller = true;
        System.out.println(title + " is now a bestseller!");
    }

    public void setPrice(Double price) {
        this.price = price;
        System.out.println("The price of " + title + " has been set to $" + price);
    }
    // Instances
    public static void main(String[] args) {
        // Creating three instances of the Book class
        Book book1 = new Book("The Great Tale", "John Doe", "Fiction");
        Book book2 = new Book("Learn Programming", "Jane Smith", "Educational");
        Book book3 = new Book("Mysteries of Space", "Alan Turing",  "Science");
    }
}
