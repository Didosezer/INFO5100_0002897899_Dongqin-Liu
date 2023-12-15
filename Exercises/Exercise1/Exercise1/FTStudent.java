public class FTStudent extends Student {
        private int examScore1;
        private int examScore2;
        public FTStudent(String name) {
            super(name);
        }
        public int getExamScore1() {
            return examScore1;
        }
        public void setExamScore1(int examScore1) {
            this.examScore1 = examScore1;
        }
        public double getExamScore2() {
            return examScore2;
        }
        public void setExamScore2(int examScore2) {
            this.examScore2 = examScore2;
        }
    }
