package org.itstep.firm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirmRestController {

    @Autowired
    private  FirmService firmService;

    @GetMapping("/save")
    public void save() { firmService.saveFirms();
    }

    @GetMapping("/firms")
    public List<Firm> findAll() {
        return firmService.findAll();
    }
}
