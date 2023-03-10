package africa.semicolon.yarnMeBlog.data.models;

import java.time.LocalDateTime;

public class User {
    public LocalDateTime getDateRegistered;
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String passWord;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
