package cz.ncsheets.lavat.controller.mvc;

import cz.ncsheets.lavat.service.rest.HolderServiceREST;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class MainController {

    HolderServiceREST holderServiceREST;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("mainpage");}
    @GetMapping("/components")
    public ModelAndView componentsView() {
        return new ModelAndView("components");}

    @GetMapping("/components/holder")
    public ModelAndView index(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return new ModelAndView("holder")
                .addObject("holders", holderServiceREST.getPageAll(pageable));
    }
}
