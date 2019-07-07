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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

  private List<User> likes = new ArrayList<>();

  private List<User> likedPersons = new ArrayList<>();

  private List<User> matches = new ArrayList<>();


  public User(String username,
      String firstName,
      String lastName,
      String password,
      Date birthdate,
      String bio,
      @Email String emailAddress,
      String gender,
      String profilePicture,
      int age) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.birthdate = birthdate;
    this.bio = bio;
    this.emailAddress = emailAddress;
    this.gender = gender;
    this.profilePicture = profilePicture;
    this.age = age;
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

  public List<User> getLikes() {
    return likes;
  }

  public void setLikes(List<User> likes) {
    this.likes = likes;
  }

  public List<User> getLikedPersons() {
    return likedPersons;
  }

  public void setLikedPersons(List<User> likedPersons) {
    this.likedPersons = likedPersons;
  }

  public List<User> getMatches() {
    return matches;
  }

  public void setMatches(List<User> matches) {
    this.matches = matches;
  }
}

