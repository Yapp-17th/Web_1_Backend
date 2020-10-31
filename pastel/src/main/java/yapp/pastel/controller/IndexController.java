package yapp.pastel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import yapp.pastel.config.auth.SessionUser;

@RequiredArgsConstructor
@Controller
public class IndexController {
    // private final PostSevice postService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        // model.addAttribute("posts", postService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
