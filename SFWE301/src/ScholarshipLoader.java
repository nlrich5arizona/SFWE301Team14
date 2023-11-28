import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
/*
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
*/
import java.util.Scanner;

public class ScholarshipLoader {

    public Scholarship loadScholarshipData(String filePath) throws IOException, ParseException {
        // Scholarship fields
        String Name = "";
        int Monetary_Amount = 0;
        int No_of_Recipient = 0;
        String Preferred_Major = "";
        double Minimum_GPA = 0.0;
        String Application_due_date = "";
        boolean Require_Essay = false;

        // Set date format
        //SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d");

        // Read file
        try {
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
                        Application_due_date = parts[1].trim();
                        break;
                    case "Require_Essay":
                        Require_Essay = parts[1].trim().equalsIgnoreCase("Yes"); // Assuming only options are Yes/No
                        break;
                }
            }

            scanner.close();
        } 
        
        // Handle NumberFormatException for parsing int, double
        catch (NumberFormatException e) {
            //throw new ParseException("Failed to parse numeric values in the file: " + filePath, 0);
            System.out.println("Failed to parse numeric values in the file: " + filePath);
        } 

        catch (IOException e) {
            System.out.println("Error with parsing " + filePath);
        }
        
        /*
        // Handle ParseException for parsing date
        catch (ParseException e) {
            throw new ParseException("Failed to parse date values in the file: " + filePath, 0);
        }
        */

        return new Scholarship(Name, Monetary_Amount, No_of_Recipient, Preferred_Major, Minimum_GPA, Application_due_date, Require_Essay, 0);
    }
}
