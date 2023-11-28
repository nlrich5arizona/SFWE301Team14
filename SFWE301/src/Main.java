import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        User currUser = new User();
        /* CODE NO LONGER WORKS
        Scholarship scholarship;
        scholarship = new Scholarship("Private University Scholarship","Chris Scholarship",10);
        System.out.println(scholarship);
        */

        String isAdminUserSelection;
        System.out.println("Is the current user an administrator? (y/n)");
        isAdminUserSelection = scnr.next();

        if (isAdminUserSelection.equals("y")) {
            currUser.GiveAdmin();
        }

        // Criteria weights (e.g., GPA weight: 20, Major weight: 50, Year_of_Study weight: 10)
        Map<String, Double> criteriaWeights = new HashMap<>();
        criteriaWeights.put("GPA", 20.0);
        criteriaWeights.put("Major", 50.0);
        criteriaWeights.put("Year_of_Study", 10.0);

        // Creating a scholarship instance
        Scholarship scholarship = new Scholarship("Wildcat Engineer's Scholarship", 5000, 1, "Engineering", 3.0, new Date(), "No", 3, criteriaWeights);
        Applicant[] applicants = new Applicant[1];
        applicants[0] = new Applicant("John Doe", "Male", 3.5, 0, "Engineering", false, 2, "johndoe@arizona.edu", "US", new Date());

        // Calculate and display matching scores for each applicant
        List<String> matchingScores = ScholarshipMatcher.getMatchingScores(applicants, scholarship);
        System.out.println("Applicant Scores for " + scholarship.getName() + ":");
        for (String score : matchingScores) {
            System.out.println(score);
        }
        
    }
}