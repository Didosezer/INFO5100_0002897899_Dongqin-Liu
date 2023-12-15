import java.util.Arrays;
import java.lang.Math.*;
public class Student {
    private String name;
    private int[] quizScores;
    public Student(String name) {
        this.name = name;
        this.quizScores = new int[15];
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public void setQuizScore(int[] scores) {
        this.quizScores = scores;
    }
    public int[] getQuizScore() {return quizScores;}

    // get scores
    public static int[] genScores() {
        int[] scores = new int[15];
        for (int i = 0; i < 15; i++) {
            scores[i]=(int)((Math.random() * 50) + 50);   // random scores between 50-100
        }
        return scores;
    }
}



