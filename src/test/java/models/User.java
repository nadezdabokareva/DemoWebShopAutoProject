package models;

import java.util.Objects;

public class User {
    private String gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public User(String gender, String firstName, String lastname, String email, String password, String passwordConfirm) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
    public User( String firstName, String lastname, String email, String password, String passwordConfirm) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getPasswordConfirm(), user.getPasswordConfirm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPassword(), getPasswordConfirm());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
