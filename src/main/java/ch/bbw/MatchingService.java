package ch.bbw;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MatchingService {

  private UserService userServicee;

  public MatchingService(UserService userServicee) {
    this.userServicee = userServicee;
  }

  public User getUnmatchedPerson(User user) {
    List<User> allUsers = userServicee.getAllUsers();
    if (user.getGender().equalsIgnoreCase("Mann")) {
      for (User person : allUsers) {
        if (!user.getLikedPersons().contains(person) && !user.getMatches().contains(person) && person.getGender().equalsIgnoreCase("Frau")) {
          return person;
        }
      }
    } else {
      for (User person : allUsers) {
        if (!user.getLikedPersons().contains(person) && !user.getMatches().contains(person) && person instanceof Mann) {
          return person;
        }
      }
    }
    return null;
  }
}
