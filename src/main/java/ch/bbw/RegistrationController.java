package ch.bbw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class RegistrationController {

        private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
        public String getUserLogin(Model model) {
            model.addAttribute("user", new User());
            return "registration";
        }

        @PostMapping("/registration")
        public String login(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult, Model model) {
            String username = user.getUsername();
            String password = user.getPassword();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            Date birthdate = user.getBirthdate();
            int age = user.getAge();
            String emailAddress = user.getEmailAddress();
            String bio = user.getBio();
            String gender = user.getGender();

            if (bindingResult.hasErrors()) {
                return "registration";
            } else {
                userService.add(user);
                    return "matcher";
                }
            }
    }


