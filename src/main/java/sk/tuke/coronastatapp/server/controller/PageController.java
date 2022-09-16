package sk.tuke.coronastatapp.server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String homepage(Model model) {
        model.addAttribute("ShowBanner", true);

        return "homepage";
    }
}
