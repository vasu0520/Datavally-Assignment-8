import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentTestScore {
    private String studentName;
    private double score;

    public StudentTestScore(String studentName, double score) {
        this.studentName = studentName;
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}

class TestScoreAnalyzer {
    private List<StudentTestScore> testScores;

    public TestScoreAnalyzer() {
        this.testScores = new ArrayList<>();
    }

    public void addTestScore(StudentTestScore testScore) {
        testScores.add(testScore);
    }

    public void analyzeTestScores() {
        double sum = 0;
        int countAboveAverage = 0;
        int countAtAverage = 0;
        int countBelowAverage = 0;

        // Sort scores
        Collections.sort(testScores, (s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));

        // Calculate average score
        for (StudentTestScore score : testScores) {
            sum += score.getScore();
        }
        double averageScore = sum / testScores.size();

        // Find median score
        double medianScore;
        if (testScores.size() % 2 == 0) {
            medianScore = (testScores.get(testScores.size() / 2).getScore() + testScores.get(testScores.size() / 2 - 1).getScore()) / 2;
        } else {
            medianScore = testScores.get(testScores.size() / 2).getScore();
        }

        // Count scores above, at, and below average
        for (StudentTestScore score : testScores) {
            if (score.getScore() > averageScore) {
                countAboveAverage++;
            } else if (score.getScore() == averageScore) {
                countAtAverage++;
            } else {
                countBelowAverage++;
            }
        }

        // Output results
        System.out.println("Test Score Analysis:");
        System.out.println("Students scoring above average: " + countAboveAverage + ", Median score: " + medianScore);
        System.out.println("Students scoring at average: " + countAtAverage + ", Median score: " + medianScore);
        System.out.println("Students scoring below average: " + countBelowAverage + ", Median score: " + medianScore);
    }
}

public class Main {
    public static void main(String[] args) {
        TestScoreAnalyzer analyzer = new TestScoreAnalyzer();

        // Example test scores
        analyzer.addTestScore(new StudentTestScore("Alice", 85));
        analyzer.addTestScore(new StudentTestScore("Bob", 70));
        analyzer.addTestScore(new StudentTestScore("Charlie", 95));
        analyzer.addTestScore(new StudentTestScore("David", 60));
        analyzer.addTestScore(new StudentTestScore("Eve", 75));

        analyzer.analyzeTestScores();
    }
}
