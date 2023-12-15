import java.util.Arrays;
public class Session {
    Student[] students;
    public Session(Student[] students) {
        this.students = students;
    }
    // Method to calculate average quiz scores per student for the whole class
    public void averageQuizScores() {
        for (int i = 0; i < 20; i++) {
            int[] scores = students[i].getQuizScore();
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            int average = sum / scores.length;
            System.out.println(students[i].getName() + "'s average score: " + average);
        }
    }
    // Method to print the list of quiz scores in ascending order for one session
    public void printQuizScores() {
        double[] allScores = new double[20 * 15];
        int index = 0;
        for (int i = 0; i < 20; i++) {
            for (double score : students[i].getQuizScore()) {
                allScores[index++] = score;
            }
        }
        Arrays.sort(allScores);
        System.out.println("Session has "+ allScores.length + " scores:");
        System.out.println(Arrays.toString(allScores));
    }
    // Method to print names of part-time students
    public void printPTStudentsName() {
        System.out.println("Part-time students names");
        for (int i = 0; i < 20; i++) {
            if (students[i] instanceof PTStudent) {
                System.out.println(students[i].getName());
            }
        }
    }
    // Method to print exam scores of full-time students
    public void printScoresOfFTStudents() {
        System.out.println("Full-time students examScores:");
        for (int i = 0; i < 20; i++) {
            if (students[i] instanceof FTStudent ftStudent) {
                System.out.println(ftStudent.getName() +"'s Exam Scores are " + ftStudent.getExamScore1() + " and " + ftStudent.getExamScore2());
            }

        }
    }

}