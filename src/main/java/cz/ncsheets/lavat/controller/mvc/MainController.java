package cz.ncsheets.lavat.controller.mvc;

import cz.ncsheets.lavat.entity.Assemble;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import cz.ncsheets.lavat.service.AssembleService;
import cz.ncsheets.lavat.service.HolderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class MainController {

    HolderService holderService;
    AssembleService assembleService;

    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("mainpage");}
    @GetMapping("/components")
    public ModelAndView componentsView() {
        return new ModelAndView("components");
    }

    @GetMapping("/components/holder")
    public ModelAndView index(@PageableDefault(sort = {"name"},size = 8) Pageable pageable) {
        return new ModelAndView("holder")
                .addObject("items", holderService.getPageAll(pageable)).addObject("form",new HolderForm());
    }
    @GetMapping("/components/holder/filter")
    public ModelAndView filterHolder(@ModelAttribute("form") HolderForm form, @PageableDefault(sort = {"name"}) Pageable pageable) {
        return new ModelAndView("holder")
                .addObject("items", holderService.findPageByHolderForm(form,pageable));
    }
    @PostMapping("/component/holder/delete")
    public Object deleteHolder(@RequestParam("holderId") long id,Pageable pageable){
        Page<Assemble> assemble = assembleService.findComponentsWithAdapter(id,pageable);
        if (assemble.getSize() != 0) {
            return new ModelAndView("errIntegrityHolder")
                    .addObject("items",assemble);
        }
        holderService.deleteComponent(id);

        return "redirect:/components/holder";
    }

}
