package ch.bbw;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddInformationController {

  private User user;
  private UserService userService;

  public AddInformationController(User user, UserService userService) {
    this.user = user;
    this.userService = userService;
  }

  @GetMapping("/addBizepsSize")
  public String shwoBizepsSize(Model model) {
    model.addAttribute("mann", new Mann());
    return "bizeps";
  }

  @PostMapping("/addBizepsSize")
  public String addBizepsSize(@Valid Mann mann, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "bizeps";
    }
    mann.setAge(user.getAge());
    mann.setBio(user.getBio());
    mann.setBirthdate(user.getBirthdate());
    mann.setEmailAddress(user.getEmailAddress());
    mann.setFirstName(user.getFirstName());
    mann.setGender(user.getGender());
    mann.setLastName(user.getLastName());
    mann.setPassword(user.getPassword());
    mann.setProfilePicture(user.getProfilePicture());
    mann.setUsername(user.getUsername());
    userService.add(mann);
    return "redirect:/login";
  }

}
