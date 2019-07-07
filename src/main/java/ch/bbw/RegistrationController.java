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
    model.addAttribute("user", new User());
    return "registration";
  }

  @PostMapping("/registration")
  public String registration(@RequestParam("file") MultipartFile multipartFile,
      @Valid @ModelAttribute(name = "user") User user,
      BindingResult bindingResult,
      Model model) {
    storageService.init();
    if (bindingResult.hasErrors()) {
      return "registration";
    } else {
      user.setProfilePicture(storageService.store(multipartFile));
        if (user.getGender().equalsIgnoreCase("Mann")) {
          return "redirect:/addBizepsSize";
        } else  {

        }
      return "redirect:/login";
    }
  }
}
