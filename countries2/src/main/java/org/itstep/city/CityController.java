package org.itstep.city;

import org.itstep.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value="/cities")
    public ModelAndView showCities() {
        var cities = cityService.findAll();
        var params = new HashMap<String, Object>();
        params.put("cities", cities);
        return new ModelAndView("cities", params);
    }

    @GetMapping(value="/cities", params="state")
    public ModelAndView searchCitiesOfState(@RequestParam(name = "state") String state) {
        var cities = cityService.findCitiesOfState2(state);
        var params = new HashMap<String, Object>();
        System.out.println(state);
        params.put("state", state);
        params.put("cities", cities);
        return new ModelAndView("citiesOfState", params);
    }
}

