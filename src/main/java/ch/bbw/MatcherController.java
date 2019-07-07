package ch.bbw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatcherController {
    private MatchingService matchingService;
    private User user;

    public MatcherController(MatchingService matchingService, User user) {
        this.matchingService = matchingService;
        this.user = user;
    }

    @GetMapping("/showWomen")
    public String getWomens(Model model) {
      Frau frau = (Frau) matchingService.getUnmatchedPerson(this.user);
      System.out.println(frau.getProfilePicture());
        model.addAttribute("frau", frau);
        return "showWomen";
    }

    @GetMapping("/like")
    public String likePerson(Model model) {
//        model.addAttribute("user", new User());
        return "matcher";
    }

    @GetMapping("/dislike")
    public String dislikePerson(Model model) {
//        model.addAttribute("user", new User());
        return "matcher";
    }
}
