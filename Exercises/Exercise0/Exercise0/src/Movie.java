public class Movie {
    private String title;
    private String director;
    private Integer duration; // in minutes
    private String category;
    private Integer yearOfRelease;
    private Double sales; // sales of tickets
    private Boolean onShow;
    private Integer rating;

    // Constructor
    public Movie(String title, String director, String category, Integer yearOfRelease) {
        this.title = title;
        this.director = director;
        this.duration = 120;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.sales = 0.0; //
        this.onShow = false;
        this.rating = 0;

        System.out.println("A new movie titled '" + this.title + "' directed by " + this.director + " created!");
    }

    // Methods
    public void playMovie() {
        System.out.println("Playing the movie: " + this.title + "...");
    }

    public void reviewMovie(int newRating) {
        this.rating = newRating;
        System.out.println("The movie '" + this.title + "' now has a rating of: " + this.rating + "/10");
    }
    public void OnShow() {System.out.println("The movie '" + this.title + "' is now on show!");}

    public static void main(String[] args) {
        // Create instances of the Movie class as needed
        Movie inception = new Movie("Inception", "Christopher Nolan",  "Sci-Fi", 2010);
        inception.playMovie();
        inception.reviewMovie(9);
        inception.OnShow();

        Movie Hero = new Movie("Hero", "Zhang yimou",  "Action", 2010);
        Movie Zootopia= new Movie("Zootopia", "Byron Howard",  "Comic", 2016);

    }
}

