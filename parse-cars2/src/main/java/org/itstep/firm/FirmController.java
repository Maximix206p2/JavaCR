package org.itstep.firm;

import org.itstep.model.ModelCar;
import org.itstep.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class FirmController {

    @Autowired
    FirmService firmService;

    @Autowired
    ModelService modelService;

    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("firms", firmService.findAll());
        model.addAttribute("model", new ModelCar());
        return "index";
    }

    @GetMapping("/models") //models?id=1
    public ModelAndView models(@RequestParam (name="id") String id){
        Set<ModelCar> models = firmService.findModels(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("index::models");
        modelAndView.addObject("models", models);
        return modelAndView;
    }

    @GetMapping("/model") //model?id=1
    public ModelAndView model(@RequestParam (name="id") String id){
        ModelCar model = modelService.findModel(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("index::model");
        modelAndView.addObject("model", model);
        return modelAndView;
    }
}