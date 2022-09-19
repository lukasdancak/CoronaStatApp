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


    @RequestMapping("/charts/agtestsinslovakia")
    public String showTestsChart() {
        return "agtestsinslovakia";
    }

    @RequestMapping("/charts/vaccinationssk")
    public String vaccinationsSk() {
        return "vaccinationssk";
    }

    @RequestMapping("/charts/pacients")
    public String pacients() {
        return "pacients";
    }
}
