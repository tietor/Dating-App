package ch.bbw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getUserLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        if (bindingResult.hasErrors()) {
            return "login";
        } else {
            if (userService.checkUser(user)) {
                return "matcher";
            } else {
                return "login";
            }
        }
    }

//    @PostMapping("/add-producer")
////    public String add(User user, Model model) {
////        producers.addProducer(user);
//////        model.addAttribute("producerLischte", producers.getAllPrducers());
////        return "producerlischte";
//////    }
//////



}
