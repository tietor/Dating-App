package ch.bbw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatcherController {
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
