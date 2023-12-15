import java.util.Date;
public class Student {
    private String studentID;
    private String name;
    private Integer age;
    private Date enrollmentDate;
    private String collegeIn;
    private Double tuition;
    private Integer numCourse;
    private Boolean isGraduated;

    public Student(String studentID, String name, Integer age, Date enrollmentDate, String collegeIn) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.enrollmentDate = enrollmentDate;
        this.collegeIn = collegeIn;
        this.tuition = 0.0; // default value
        this.numCourse = 0; // default value
        this.isGraduated = false; // default value

        System.out.println("A new student instance has been created with ID: " + studentID + " and Name: " + name);
    }

    public void enroll() {
        System.out.println(name + " has enrolled in a new course. Total courses: " + numCourse);
    }

    public void withdraw() {

        System.out.println(name + " is not enrolled in any courses and withdrew.");
    }

    public void graduate() {
        this.isGraduated = true;
        System.out.println(name + " has graduated from " + collegeIn + "!");
    }

    public static void main(String[] args) {
        // Creating instances of the Student class
        Student student1 = new Student("NEU001", "ABC", 22, new Date(), "COE");
        Student student2 = new Student("NEU002", "BCD", 23, new Date(), "COE");
        Student student3 = new Student("NEU003", "CDE", 22, new Date(), "CPS");

    }
}

