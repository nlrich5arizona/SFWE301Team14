import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScholarshipMatcher {

    public static List<String> getMatchingScores(Applicant[] applicants, Scholarship scholarship, Map<String, Double> inputWeights) {
        List<String> scores = new ArrayList<>();

        for (Applicant applicant : applicants) {
            double score = 0;
            Map<String, Double> criteriaWeights = inputWeights;
            
            // GPA Criteria
            if (criteriaWeights.containsKey("GPA")) {
                score += calculateGpaScore(applicant.getGPA(), criteriaWeights.get("GPA"));
            }

            // Major Criteria
            if (criteriaWeights.containsKey("Major") && applicant.getMajor().equals(scholarship.getPreferred_Major())) {
                score += criteriaWeights.get("Major");
            }

            // Year of Study Criteria
            if (criteriaWeights.containsKey("Year_of_Study")) {
                score += calculateYearScore(applicant.getYear_of_Study(), criteriaWeights.get("Year_of_Study"));
            }

            // Normalize or adjust the score as necessary
            scores.add(applicant.getName() + ", " + Math.round(score)); // Rounding off the score for simplicity
        }

        return scores;
    }

    private static double calculateGpaScore(double gpa, double weight) {
        // Example: GPA score calculation could be a direct multiplication
        return gpa * weight;
    }

    private static double calculateYearScore(int year, double weight) {
        // Example: Year score calculation, could be different based on the scholarship's preference
        return year * weight;
    }
}
