package cz.ncsheets.lavat.controller.mvc;
import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.filter.AdapterForm;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import cz.ncsheets.lavat.service.AdapterService;
import cz.ncsheets.lavat.service.AssembleService;
import cz.ncsheets.lavat.service.HolderService;
import cz.ncsheets.lavat.service.HoldersizeService;
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
public class ControllerAdapter {

    AdapterService adapterService;
    @GetMapping("/adapter")
    public ModelAndView index(@PageableDefault(sort = {"name"},size = 8) Pageable pageable,
                              HttpServletRequest request) {
        String queryString = request.getQueryString();
        return new ModelAndView("adapter")
                .addObject("items", adapterService.getPageAll(pageable))
                .addObject("form",new HolderForm());
    }
    @GetMapping("/adapter/filter")
    public ModelAndView filterItems(@ModelAttribute("form") AdapterForm form,
                                     @PageableDefault(sort = {"name"},size = 8) Pageable pageable,
                                     HttpServletRequest request) {
        String basePath = request.getServletPath();
        return new ModelAndView("adapter")
                    .addObject("base",basePath)
                    .addObject("items", adapterService.findPageByAdapterForm(form,pageable));
    }

    //dodelat component ->components
    @PostMapping("/adapter/delete")
    public Object deleteItem(@RequestParam("holderId") long id,Pageable pageable){
      /*  Page<Assemble> assemble = assembleService.findComponentsWithAdapter(id,pageable);
        if (assemble.getSize() != 0) {
            return new ModelAndView("errIntegrityHolder")
                    .addObject("items",assemble);
        }*/
        adapterService.deleteComponent(id);

        return "redirect:/components/adapter";
    }

    @GetMapping("/adapter/form")
    public ModelAndView createView(){
        ModelAndView model = new ModelAndView("form_adapter");
        model.addObject("form",new Holder());
        model.addObject("form_holdersize",adapterService.getComponents());
        return model;
    }

    @PostMapping("/adapter/form")
    public String createItem(@Valid Adapter adapter, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form_adapter";
        }

         adapterService.saveComponent(adapter);
         return "redirect:/";
    }
    @GetMapping("/adapter/edit/{id}")
    public ModelAndView editItem(@PathVariable long id){
        ModelAndView model = new ModelAndView("form_adapter");
        model.addObject("form",adapterService.getComponent(id));
        return model;
    }
}
