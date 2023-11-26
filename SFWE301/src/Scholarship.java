public class Scholarship {
    String scholarship_description;
    String scholarship_name;
    int position_available;

    public Scholarship(String scholarship_description, String scholarship_name, int position_available) {
        this.scholarship_description = scholarship_description;
        this.scholarship_name = scholarship_name;
        this.position_available = position_available;
    }

    public String getScholarship_description() {
        return scholarship_description;
    }

    public void setScholarship_description(String scholarship_description) {
        this.scholarship_description = scholarship_description;
    }

    public String getScholarship_name() {
        return scholarship_name;
    }

    public void setScholarship_name(String scholarship_name) {
        this.scholarship_name = scholarship_name;
    }

    public int getPosition_available() {
        return position_available;
    }

    public void setPosition_available(int position_available) {
        this.position_available = position_available;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "scholarship_description='" + scholarship_description + '\'' +
                ", scholarship_name='" + scholarship_name + '\'' +
                ", position_available=" + position_available +
                '}';
    }
}
