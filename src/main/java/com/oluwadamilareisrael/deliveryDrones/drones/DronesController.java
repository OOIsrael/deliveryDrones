package com.oluwadamilareisrael.deliveryDrones.drones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/drones")
public class DronesController {
    private DronesService dronesService;

    @Autowired
    public DronesController(DronesService dronesService) {
        this.dronesService = dronesService;
    }

    @GetMapping("/All")
    public List<Drones> getDrones(){
        return dronesService.getDrones();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addNewDrones(@RequestBody Drones drones){
        dronesService.addNewDrones(drones);
    }
}
