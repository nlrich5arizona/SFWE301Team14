public class Scholarship {
    String Name;
    int Monetary_Amount;
    int No_of_Recipient;
    String Preferred_Major;
    double Minimum_GPA;
    String Application_due_date;
    boolean Require_Essay;
    int Preferred_Year_of_Study;

    public Scholarship(String name, int monetary_Amount, int no_of_Recipient, String preferred_Major, double minimum_GPA, String application_due_date, boolean require_Essay, int preferred_year_of_study) {
        Name = name;
        Monetary_Amount = monetary_Amount;
        No_of_Recipient = no_of_Recipient;
        Preferred_Major = preferred_Major;
        Minimum_GPA = minimum_GPA;
        Application_due_date = application_due_date;
        Require_Essay = require_Essay;
        Preferred_Year_of_Study = preferred_year_of_study;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMonetary_Amount() {
        return Monetary_Amount;
    }

    public void setMonetary_Amount(int monetary_Amount) {
        Monetary_Amount = monetary_Amount;
    }

    public int getNo_of_Recipient() {
        return No_of_Recipient;
    }

    public void setNo_of_Recipient(int no_of_Recipient) {
        No_of_Recipient = no_of_Recipient;
    }

    public String getPreferred_Major() {
        return Preferred_Major;
    }

    public void setPreferred_Major(String preferred_Major) {
        Preferred_Major = preferred_Major;
    }

    public double getMinimum_GPA() {
        return Minimum_GPA;
    }

    public void setMinimum_GPA(double minimum_GPA) {
        Minimum_GPA = minimum_GPA;
    }

    public String getApplication_due_date() {
        return Application_due_date;
    }

    public void setApplication_due_date(String application_due_date) {
        Application_due_date = application_due_date;
    }

    public boolean getRequire_Essay() {
        return Require_Essay;
    }

    public void setRequire_Essay(boolean require_Essay) {
        Require_Essay = require_Essay;
    }

    public void setPreferred_year_of_study(int year_of_study) {
        Preferred_Year_of_Study = year_of_study;
    }

    public int getPreferrer_year_of_study() {
        return Preferred_Year_of_Study;
    }
}
