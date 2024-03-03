package cz.ncsheets.lavat.controller.mvc;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("mainpage");
    }
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("form_holder");
    }
    @GetMapping("/components")
    public ModelAndView componentsView() {

        return new ModelAndView("components");
    }
}
