package ch.bbw;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MatchingService {

  private UserService userService;

  public MatchingService(UserService userService) {
    this.userService = userService;
  }

  public Frau getUnmatchedFrau(User user) {
    List<User> allUsers = userService.getAllUsers();
    if (user.getGender().equalsIgnoreCase("Mann")) {
      for (User person : allUsers) {
        if (!user.getLikedPersons().contains(person) && !user.getMatches().contains(person) && person.getGender()
            .equalsIgnoreCase("Frau")) {
          return (Frau) person;
        }
      }
    }
    return null;
  }

  public Mann getUnmatchedMann(User user) {
    List<User> allUsers = userService.getAllUsers();
    for (User person : allUsers) {
      if (!user.getLikedPersons().contains(person) && !user.getMatches().contains(person) && person.getGender()
          .equalsIgnoreCase("Mann")) {
        return (Mann) person;
      }
    }
    return null;
  }
}
