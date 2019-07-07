package ch.bbw;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

  private List<User> users = new ArrayList<>();

  public UserService() {
    users.add(new User("minschitte", "Minh", "testeee", "testpassword123", new Date(1999, 10, 21), "Hello i'm minh",
        "minh.teste@gmail.com", "Frau", "upload-dir/minh/minh-profile-picture.jpeg", 19));
  }

  public List<User> getAllUsers() {
    return users;
  }

  public User getUser(User user) {
    return getAllUsers().stream()
        .filter(person -> person.getUsername().equalsIgnoreCase(user.getUsername()))
        .findFirst()
        .get();
  }

  public boolean checkUser(User value) {
    for (User user : users) {
      if (user.getPassword().equals(value.getPassword()) && user.getUsername().equals(value.getUsername())) {
        return true;
      }
    }
    return false;
  }

  public boolean add(User value) {
    users.add(value);
    return false;
  }

  public User addAttributesOfUser(User expectedObject, User valuesToAdd) {
    expectedObject.setAge(valuesToAdd.getAge());
    expectedObject.setBio(valuesToAdd.getBio());
    expectedObject.setBirthdate(valuesToAdd.getBirthdate());
    expectedObject.setEmailAddress(valuesToAdd.getEmailAddress());
    expectedObject.setFirstName(valuesToAdd.getFirstName());
    expectedObject.setGender(valuesToAdd.getGender());
    expectedObject.setLastName(valuesToAdd.getLastName());
    expectedObject.setPassword(valuesToAdd.getPassword());
    expectedObject.setUsername(valuesToAdd.getUsername());
    return expectedObject;
  }


}
