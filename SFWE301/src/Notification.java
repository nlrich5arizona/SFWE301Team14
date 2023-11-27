import java.util.Objects;

public class Notification {
    String Scholarship_name;
    String Recipient_name;
    // True mean accept the notification and false means decline the scholarship
    boolean action;

    public Notification(String scholarship_name, String recipient_name, boolean action) {
        Scholarship_name = scholarship_name;
        Recipient_name = recipient_name;
        this.action = action;
    }

    public Notification(String scholarship_name, String recipient_name) {
        Scholarship_name = scholarship_name;
        Recipient_name = recipient_name;
    }

    public Notification(boolean action) {
        this.action = action;
    }

    public String getScholarship_name() {
        return Scholarship_name;
    }

    public void setScholarship_name(String scholarship_name) {
        Scholarship_name = scholarship_name;
    }

    public String getRecipient_name() {
        return Recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        Recipient_name = recipient_name;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "Scholarship_name='" + Scholarship_name + '\'' +
                ", Recipient_name='" + Recipient_name + '\'' +
                ", action=" + action +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return action == that.action && Objects.equals(Scholarship_name, that.Scholarship_name) && Objects.equals(Recipient_name, that.Recipient_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Scholarship_name, Recipient_name, action);
    }
}
