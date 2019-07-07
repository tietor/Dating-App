package ch.bbw;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    private String bio;

    @Email
    private String emailAddress;

    private String gender;

    private String profilePicture;

    private int age;


    public User(String username, String firstName, String lastName, String password, Date birthdate, String bio, @Email String emailAddress, String gender) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;



        this.birthdate = birthdate;
        this.bio = bio;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}

