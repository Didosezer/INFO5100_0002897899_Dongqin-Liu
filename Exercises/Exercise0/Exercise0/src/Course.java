public class Course {
    private String courseID;
    private String courseName;
    private String instructor;
    private Integer credits;
    private Integer capacity; // number of students can be held
    private Integer currentEnrollment;
    private Boolean required;
    private Double courseFee;

    // Constructor
    public Course(String courseID, String courseName, String instructor, Integer credits, Integer capacity) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.capacity = capacity;
        this.currentEnrollment = 0; // default value
        this.required = false; // default value
        this.courseFee = 0.0; // default value
        System.out.println("A new course has been created with ID: " + courseID + " and Name: " + courseName);
    }
    // Methods
    public void enrollStudent() {
            System.out.println("A student has been enrolled in " + courseName + ". Current enrollment: " + currentEnrollment);
        }
    public void dropStudent() {
            System.out.println("A student has dropped from " + courseName + ". Current enrollment: " + currentEnrollment);
        }

    public void setMandatory() {
        this.required = true;
        System.out.println(courseName + " has been set as a required course.");
    }

    public static void main(String[] args) {
        // Creating three instances of the Course class
        Course course1 = new Course("C101", "Data", "Dr. guru", 3, 40);
        Course course2 = new Course("C102", "Python", "Dr. prof", 4, 35);
        Course course3 = new Course("C103", "Java", "Dr. Will", 3, 30);
    }

}

