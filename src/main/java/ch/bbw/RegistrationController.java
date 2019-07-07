package ch.bbw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class RegistrationController {

  private UserService userService;
  private StorageService storageService;
  private User myUser;


  public RegistrationController(UserService userService, StorageService storageService, User myUser) {
    this.userService = userService;
    this.storageService = storageService;
    this.myUser = myUser;
  }

  @GetMapping("/registration")
  public String getUserLogin(Model model) {
    model.addAttribute("user", myUser);
    return "registration";
  }

  @PostMapping("/registration")
  public String registration(@RequestParam("file") MultipartFile multipartFile,
      @Valid @ModelAttribute(name = "user") User user,
      BindingResult bindingResult) {
    storageService.init();
    if (bindingResult.hasErrors()) {
      return "registration";
    } else {
      myUser.setProfilePicture(storageService.store(multipartFile));
      myUser = userService.addAttributesOfUser(myUser, user);
        if (user.getGender().equalsIgnoreCase("Mann")) {
          System.out.println(myUser);
          return "redirect:/addBizepsSize";
        } else  {
          return "redirect:/addHueftumfang";
        }
    }
  }
}
