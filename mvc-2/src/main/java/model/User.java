package model;

public class User {
    private String userId;
    private String password;
    private String name;
    private String email;

    public User(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {}

    public String getName() {
        return name;
    }
    public void setName(String name) {}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {}

    @Override
    public String toString() {
        return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
    }
}
