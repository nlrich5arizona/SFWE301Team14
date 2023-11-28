import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Creating variables for use in all of main()
        Scanner scnr = new Scanner(System.in);
        User currUser = new User();
        ApplicantLoader applicantLoader = new ApplicantLoader();
        ScholarshipLoader scholarshipLoader = new ScholarshipLoader();
        ScholarshipAwardWriter logWriter = new ScholarshipAwardWriter();
        String userInput = "";
        
        // Load test data
        Scholarship[] scholarships = new Scholarship[5];
        Applicant[] applicants = new Applicant[5];

        for (int i = 1; i < 6; ++i) {
            try {
                scholarships[i-1] = scholarshipLoader.loadScholarshipData("test data/scholarship" + i + ".txt");
                applicants[i-1] = applicantLoader.loadApplicantData("test data/applicant" + i + ".txt");
            }
            catch (Exception e) {
                System.out.println("Error parsing on count " + i);
            }
        }
        
        String isAdminUserSelection;
        int scholarshipResponsibleFor = 0;
        int applicantSelected = 0;
        int userApplicant = 0;
        Scholarship currScholarship = scholarships[0];

        while (!userInput.equals("quit")) {
            // Ask user for information (login process)
            System.out.println("Is the current user an administrator? (y/n)");
            isAdminUserSelection = scnr.next();

            // Gives the user administrative access based on the previous question
            if (isAdminUserSelection.equals("y")) {
                currUser.GiveAdmin();
            }
            else {
                currUser.RevokeAdmin();
            }

            // Split paths based on whether the user is an applicant or an administrator
            if (currUser.getAdmin()) {
                // Lists all available scholarships
                System.out.println("Available Scholarships:");
                for (int i = 0; i < 5; ++i) {
                    System.out.println((i+1) + ". " + scholarships[i].getName());
                }

                // User selects which scholarship they are responsible for
                System.out.println();
                System.out.println("For which scholarship are you responsible?");

                scholarshipResponsibleFor = scnr.nextInt();
                currScholarship = scholarships[scholarshipResponsibleFor - 1];

                // Criteria weights (e.g., GPA weight: 20, Major weight: 50, Year_of_Study weight: 10)
                Map<String, Double> criteriaWeights = new HashMap<>();
                criteriaWeights.put("GPA", 20.0);
                criteriaWeights.put("Major", 50.0);
                criteriaWeights.put("Year_of_Study", 10.0);

                String awardScholarship = "n";
                Applicant selectedApplicant = applicants[0];

                while (awardScholarship.equals("n")) {
                    // Calculate and display matching scores for each applicant
                    int count = 1;
                    List<String> matchingScores = ScholarshipMatcher.getMatchingScores(applicants, currScholarship, criteriaWeights);
                    System.out.println("Applicant Scores for " + currScholarship.getName() + ":");
                    for (String score : matchingScores) {
                        System.out.print(count + ". ");
                        System.out.println(score);
                        count++;
                    }
                    
                    //Selection process
                    if (currUser.getAdmin()) {
                        System.out.println("Select the number of the applicant you wish to award the scholarship to:");
                        applicantSelected = scnr.nextInt();
                    }
                    selectedApplicant = applicants[applicantSelected - 1];

                    System.out.println();
                    System.out.println("Award scholarship to " + selectedApplicant.getName() + "? (y/n)");
                    awardScholarship = scnr.next();
                }
                
                // Awarding the scholarship
                System.out.println();
                System.out.println("Scholarship awarded to " + selectedApplicant.getName());

                // Creating the notification for the applicant
                applicants[applicantSelected - 1].setHasNotification(true);
                Notification scholarshipAwardedNotif = new Notification(currScholarship.getName(), applicants[applicantSelected - 1].getName());
                applicants[applicantSelected - 1].setNotification(scholarshipAwardedNotif);

                // Waits for the user to log out
                while (!userInput.equals("logout") && !userInput.equals("Logout") && !userInput.equals("quit")) {
                    userInput = scnr.next();
                }
            }
            else {
                userInput = "";
                String acceptScholarship = "";

                // Lists all applicants
                System.out.println("Loaded Applicants:");
                for (int i = 0; i < 5; ++i) {
                    System.out.println((i+1) + ". " + applicants[i].getName());
                }

                // Asks applicant to identify themselves
                System.out.println();
                System.out.println("Which applicant are you?");

                userApplicant = scnr.nextInt();

                // Checks for notification
                if (applicants[userApplicant - 1].getHasNotification()) {
                    System.out.println(applicants[userApplicant - 1].getNotification().toString());     // Prints notification
                    System.out.println("Do you accept this scholarship? (y/n)");                      // Prompts applicant to accept the notification
                    acceptScholarship = scnr.next();

                    // If applicant accepts, the system writes this to a log
                    if (acceptScholarship.equals("y")) {
                        logWriter.writeAwardToFile(currScholarship.getName(), applicants[userApplicant - 1].getName(), applicants[userApplicant - 1].getStudent_ID(), "log.txt");
                    }
                }
                
                // Waits for user to log out
                while (!userInput.equals("logout") && !userInput.equals("Logout") && !userInput.equals("quit")) {
                    userInput = scnr.next();
                }
            }
        }
        
        scnr.close();
    }
}