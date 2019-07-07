package ch.bbw;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddInformationController {

  private User myUser;
  private UserService userService;

  public AddInformationController(User myUser, UserService userService) {
    this.myUser = myUser;
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
    mann = (Mann) userService.addAttributesOfUser(mann, myUser);
    mann.setProfilePicture(myUser.getProfilePicture());
    userService.add(mann);
    return "redirect:/login";
  }

  @GetMapping("/addHueftumfang")
  public String addHueftumfang(Model model) {
    model.addAttribute("frau", new Frau());
    return "hueftumfang";
  }

  @PostMapping("/addHueftumfang")
  public String addHueftumfang(@Valid Frau frau, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "hueftumfang";
    }
    frau = (Frau) userService.addAttributesOfUser(frau, myUser);
    frau.setProfilePicture(myUser.getProfilePicture());
    userService.add(frau);
    return "redirect:/login";
  }

}
