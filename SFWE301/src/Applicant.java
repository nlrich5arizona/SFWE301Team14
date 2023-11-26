import java.util.Date;

public class Applicant {
    String Name;
    String Gender;
    double GPA;
    int Year_of_Study;
    String Major;
    String Minor;
    boolean Transfer_Student;
    int Student_ID;
    String Email;
    int units_enrolled;
    String Citizenship;
    Date Expected_Graduation_Date;
    String Personal_Statement;
    boolean Have_Funding;
    String Club;
    String Extracurriculars;
    String Academic_Achievement;
    String Easy_Responses;

    public Applicant(String name, String gender, double GPA, int year_of_Study, String major, boolean transfer_Student, int student_ID, String email, String citizenship, Date expected_Graduation_Date) {
        Name = name;
        Gender = gender;
        this.GPA = GPA;
        Year_of_Study = year_of_Study;
        Major = major;
        Transfer_Student = transfer_Student;
        Student_ID = student_ID;
        Email = email;
        Citizenship = citizenship;
        Expected_Graduation_Date = expected_Graduation_Date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getYear_of_Study() {
        return Year_of_Study;
    }

    public void setYear_of_Study(int year_of_Study) {
        Year_of_Study = year_of_Study;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getMinor() {
        return Minor;
    }

    public void setMinor(String minor) {
        Minor = minor;
    }

    public boolean isTransfer_Student() {
        return Transfer_Student;
    }

    public void setTransfer_Student(boolean transfer_Student) {
        Transfer_Student = transfer_Student;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int student_ID) {
        Student_ID = student_ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getUnits_enrolled() {
        return units_enrolled;
    }

    public void setUnits_enrolled(int units_enrolled) {
        this.units_enrolled = units_enrolled;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public void setCitizenship(String citizenship) {
        Citizenship = citizenship;
    }

    public Date getExpected_Graduation_Date() {
        return Expected_Graduation_Date;
    }

    public void setExpected_Graduation_Date(Date expected_Graduation_Date) {
        Expected_Graduation_Date = expected_Graduation_Date;
    }

    public String getPersonal_Statement() {
        return Personal_Statement;
    }

    public void setPersonal_Statement(String personal_Statement) {
        Personal_Statement = personal_Statement;
    }

    public boolean isHave_Funding() {
        return Have_Funding;
    }

    public void setHave_Funding(boolean have_Funding) {
        Have_Funding = have_Funding;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String club) {
        Club = club;
    }

    public String getExtracurriculars() {
        return Extracurriculars;
    }

    public void setExtracurriculars(String extracurriculars) {
        Extracurriculars = extracurriculars;
    }

    public String getAcademic_Achievement() {
        return Academic_Achievement;
    }

    public void setAcademic_Achievement(String academic_Achievement) {
        Academic_Achievement = academic_Achievement;
    }

    public String getEasy_Responses() {
        return Easy_Responses;
    }

    public void setEasy_Responses(String easy_Responses) {
        Easy_Responses = easy_Responses;
    }
}
