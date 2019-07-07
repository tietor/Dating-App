package ch.bbw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

  private UserService userService;
  private User user;

  public LoginController(UserService userService, User user) {
    this.userService = userService;
    this.user = user;
  }

  @GetMapping("/login")
  public String getUserLogin(Model model) {
    model.addAttribute("user", user);
    return "login";
  }

  @PostMapping("/login")
  public String login(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "login";
    } else {
      if (userService.checkUser(user)) {
        this.user = userService.getUser(user);
        System.out.println(this.user);
        if (this.user.getGender().equalsIgnoreCase("Mann")) {
          return "redirect:/showWomen";
        } else  {
          return "redirect:/shwoMen";
        }
      } else {
        return "login";
      }
    }
  }
}
