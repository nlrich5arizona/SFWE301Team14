public class Applicant {
    String applicant_name;
    double applicant_gpa;

    public Applicant(String applicant_name, double applicant_gpa) {
        this.applicant_name = applicant_name;
        this.applicant_gpa = applicant_gpa;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public double getApplicant_gpa() {
        return applicant_gpa;
    }

    public void setApplicant_gpa(double applicant_gpa) {
        this.applicant_gpa = applicant_gpa;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicant_name='" + applicant_name + '\'' +
                ", applicant_gpa=" + applicant_gpa +
                '}';
    }
}
