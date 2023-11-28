import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScholarshipAwardWriter {

    public void writeAwardToFile(String scholarshipName, String applicantName, int applicantId, String filePath) {

        // Build output string
        String content = String.format("The %s has been awarded to %s, ID: %d.", scholarshipName, applicantName, applicantId);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Write to file
            writer.write(content);
            // New line
            writer.newLine();
        } 
        
        // Handle exception
        catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
