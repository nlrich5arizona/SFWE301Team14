public class User {
    boolean isAdmin;

    public User() {
        isAdmin = false;
    }

    public void GiveAdmin() {
        this.isAdmin = true;
    }

    public void RevokeAdmin() {
        this.isAdmin = false;
    }

    public boolean getAdmin() {
        return this.isAdmin;
    }
}
