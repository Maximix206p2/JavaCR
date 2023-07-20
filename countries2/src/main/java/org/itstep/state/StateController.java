package org.itstep.state;

import org.itstep.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping(value="/states")
    public ModelAndView showStates() {
        var states = stateService.findAll();
        var params = new HashMap<String, Object>();
        params.put("states", states);
        return new ModelAndView("states", params);
    }

    @GetMapping(value="/states", params="search")
    public ModelAndView search(@RequestParam(name = "search") String search) {
        var states = stateService.search(search);
        var params = new HashMap<String, Object>();
        params.put("states", states);
        return new ModelAndView("states", params);
    }

    @GetMapping(value="/states", params="country")
    public ModelAndView searchStatesOfCountry(@RequestParam(name = "country") String country) {
        var states = stateService.findStatesOfCountry(country);
        var params = new HashMap<String, Object>();
        params.put("country", country);
        params.put("states", states);
        return new ModelAndView("statesOfCountry", params);
    }
}
