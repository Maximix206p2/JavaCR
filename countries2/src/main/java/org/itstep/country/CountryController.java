package org.itstep.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(value="/countries")
    public ModelAndView showCountries() {
        var countries = countryService.findAll();
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        return new ModelAndView("countries", params);
    }

    @GetMapping(value="/countries", params="search")
    public ModelAndView search(@RequestParam(name = "search") String search) {
        var countries = countryService.search(search);
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        return new ModelAndView("countries", params);
    }

}
