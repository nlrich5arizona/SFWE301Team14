import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScholarshipLoader {

    public static Scholarship loadScholarshipData(String filePath) throws IOException, ParseException {
        // Scholarship fields
        String Name = "";
        int Monetary_Amount = 0;
        int No_of_Recipient = 0;
        String Preferred_Major = "";
        double Minimum_GPA = 0.0;
        Date Application_due_date = null;
        boolean Require_Essay = false;

        // Set date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d");

        // Read file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // To hold a line at a time
            String line;

            // While line is not empty
            while ((line = reader.readLine()) != null) {
                // Keep consistent format (": "), skip lines that don't match
                String[] parts = line.split(": ");
                if (parts.length < 2) continue;

                // .trim() to remove whitespace should it exist in the scholarship info file
                switch (parts[0].trim()) {
                    case "Name":
                        Name = parts[1].trim();
                        break;
                    case "Monetary_Amount":
                        Monetary_Amount = Integer.parseInt(parts[1].trim());
                        break;
                    case "Number_of_recipients":
                        No_of_Recipient = Integer.parseInt(parts[1].trim());
                        break;
                    case "Preferred_majors":
                        Preferred_Major = parts[1].trim();
                        break;
                    case "Minimum_GPA":
                        Minimum_GPA = Double.parseDouble(parts[1].trim());
                        break;
                    case "Application_due_date":
                        Application_due_date = dateFormat.parse(parts[1].trim()); // Using date format from above
                        break;
                    case "Require_Essay":
                        Require_Essay = parts[1].trim().equalsIgnoreCase("Yes"); // Assuming only options are Yes/No
                        break;
                }
            }
        } 
        
        // Handle NumberFormatException for parsing int, double
        catch (NumberFormatException e) {
            throw new ParseException("Failed to parse numeric values in the file: " + filePath, 0);
        } 
        
        // Handle ParseException for parsing date
        catch (ParseException e) {
            throw new ParseException("Failed to parse date values in the file: " + filePath, 0);
        }

        return new Scholarship(Name, Monetary_Amount, No_of_Recipient, Preferred_Major, Minimum_GPA, Application_due_date, Require_Essay);
    }
}
