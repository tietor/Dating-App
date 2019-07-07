package ch.bbw;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {

        users.add(new User("hallo", "hallo"));
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


}
