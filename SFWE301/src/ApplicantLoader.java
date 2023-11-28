import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ApplicantLoader {

    public Applicant loadApplicantData(String filePath) throws IOException, ParseException  {
        // Applicant fields
        String Name = "";
        String Gender = "";
        double GPA = 0.0;
        int Year_of_Study = 0;
        String Major = "";
        String Minor = "";
        boolean Transfer_Student = false;
        int Student_ID = 0;
        String Email = "";
        int units_enrolled = 0;
        boolean Citizenship = true;
        String Expected_Graduation_Date = "";
        String Personal_Statement = "";
        boolean Have_Funding = false;
        String Club = "";
        String Extracurriculars = "";
        String Academic_Achievement = "";

        try {
            // Read file
            Scanner scanner = new Scanner(new File(filePath));
            // To hold a line at a time
            String line;

            // While line is not empty
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] parts = line.split(": ");
                if (parts.length < 2) continue;

                // .trim() to remove whitespace should it exist in the scholarship info file
                switch (parts[0].trim()) {
                    case "Name":
                        Name = parts[1].trim();
                        break;

                    case "Gender":
                        Gender = parts[1].trim();
                        break;

                    case "GPA":
                        GPA = Double.parseDouble(parts[1].trim());
                        break;

                    case "Year_of_Study":
                        Year_of_Study = Integer.parseInt(parts[1].trim());
                        break;

                    case "Major":
                        Major = parts[1].trim();
                        break;

                    case "Minor":
                        Minor = parts[1].trim();
                        break;

                    case "Transfer_Student":
                        Transfer_Student = parts[1].trim().equalsIgnoreCase("Yes"); // Assuming only options are Yes/No
                        break;

                    case "Student_ID":
                        Student_ID = Integer.parseInt(parts[1].trim());
                        break;

                    case "Email":
                        Email = parts[1].trim();
                        break;

                    case "Units_Enrolled_In":
                        units_enrolled = Integer.parseInt(parts[1].trim());
                        break;

                    case "Citizenship":
                        Citizenship = parts[1].trim().equalsIgnoreCase("Yes");
                        break;

                    case "Expected_Graduation_Date":
                        Expected_Graduation_Date = parts[1].trim();
                        break;

                    case "Already_have_funding":
                        Have_Funding = parts[1].trim().equalsIgnoreCase("Yes"); // Assuming only options are Yes/No
                        break;

                    case "Personal_Statement":
                        Personal_Statement = parts[1].trim();
                        break;

                    case "Clubs":
                        Club = parts[1].trim();
                        break;

                    case "Extracurriculars":
                        Extracurriculars = parts[1].trim();
                        break;

                    case "Academic_Achievements":
                        Academic_Achievement = parts[1].trim();
                        break;
                }
            }

            scanner.close();
        } 
        
        // Handle NumberFormatException for parsing integer, double
        catch (NumberFormatException e) {
            throw new ParseException("Failed to parse numeric values in the file: " + filePath, 0);
        }

        // Creating the object given the information
        Applicant applicant = new Applicant(Name, Gender, GPA, Year_of_Study, Major, Transfer_Student, Student_ID, Email, Citizenship, Expected_Graduation_Date);
        applicant.setUnits_enrolled(units_enrolled);
        applicant.setPersonal_Statement(Personal_Statement);
        applicant.setHave_Funding(Have_Funding);

        if (!Minor.equals("-")) {
            applicant.setMinor(Minor);
        }
        if (!Club.equals("-")) {
            applicant.setClub(Club);
        }
        if (!Extracurriculars.equals("-")) {
            applicant.setExtracurriculars(Extracurriculars);
        }
        if (!Academic_Achievement.equals("-")) {
            applicant.setAcademic_Achievement(Academic_Achievement);
        }
        
        return applicant;
    }
}
