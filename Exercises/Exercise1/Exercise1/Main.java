public class Main {
    public static void main(String[] args) {
        String[] names = {
                "Ben", "Bruce", "Cathy", "David", "Eva",
                "Frank", "Nancy", "Hannah", "Ivy", "Ross",
                "Kevin", "Lily", "Henny", "Yale", "Oman",
                "Zack", "Jack", "Robbin", "Sara", "Tom"
        };
// Populate the students with 10 ptStudents and 10 ftStudents
        Student[] students = new Student[20];
        for (int i = 0; i < 10; i++) {
            PTStudent ptStudent = new PTStudent(names[i]);
            int[] dummyQuizScoresPT = PTStudent.genScores();
            ptStudent.setQuizScore(dummyQuizScoresPT);
            students[i] = ptStudent;
        }
        for (int i = 10; i < 20; i++) {
            FTStudent ftStudent = new FTStudent(names[i]);
            int[] dummyQuizScoresFT = FTStudent.genScores();
            ftStudent.setQuizScore(dummyQuizScoresFT);
            ftStudent.setExamScore1((int)((Math.random() * 50) + 50));
            ftStudent.setExamScore2((int)((Math.random() * 50) + 50));
            students[i] = ftStudent;
        }

        Session session = new Session(students);

        // Call public methods of Session
        session.averageQuizScores();
        session.printQuizScores();

        session.printPTStudentsName();
        session.printScoresOfFTStudents();
    }
}
