package cz.ncsheets.lavat.controller.mvc;
import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.Tool;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import cz.ncsheets.lavat.entity.filter.ToolForm;
import cz.ncsheets.lavat.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping("/components")
public class ControllerTool {

    ToolService toolService;
    TooltypeService tooltypeService;


    @GetMapping("/tool")
    public ModelAndView index(@PageableDefault(sort = {"name"},size = 8) Pageable pageable,
                              HttpServletRequest request) {
        String queryString = request.getQueryString();
        return new ModelAndView("tool")
                .addObject("items", toolService.getPageAll(pageable))
                .addObject("form",new ToolForm());
    }
    @GetMapping("/tool/filter")
    public ModelAndView filter(@ModelAttribute("form") ToolForm form,
                                     @PageableDefault(sort = {"name"},size = 8) Pageable pageable,
                                     HttpServletRequest request) {
        String basePath = request.getServletPath();
        return new ModelAndView("tool")
                    .addObject("base",basePath)
                    .addObject("items", toolService.findPageByToolForm(form,pageable));
    }

    //dodelat component ->components
    @PostMapping("/tool/delete")
    public Object deleteItem(@RequestParam("toolId") long id,Pageable pageable){
      /*  Page<Assemble> assemble = assembleService.findComponentsWithAdapter(id,pageable);
        if (assemble.getSize() != 0) {
            return new ModelAndView("errIntegrityHolder")
                    .addObject("items",assemble);
        }*/
        toolService.deleteComponent(id);

        return "redirect:/components/tool";
    }

    @GetMapping("/tool/form")
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("form_tool");
        model.addObject("form",new Tool());
        model.addObject("form_tooltype",toolService.getComponents());
        return model;
    }

    @PostMapping("/tool/form")
    public String createItem(@Valid Tool tool, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form_tool";
        }

        toolService.saveComponent(tool);
         return "redirect:/";
    }
    @GetMapping("/tool/edit/{id}")
    public ModelAndView editItem(@PathVariable long id){
        ModelAndView model = new ModelAndView("form_tool");
        model.addObject("form",toolService.getComponent(id));
        model.addObject("form_tooltype",tooltypeService.getComponents());
        return model;
    }
}
