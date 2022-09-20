package com.oluwadamilareisrael.deliveryDrones.deliveryControllers;

import com.oluwadamilareisrael.deliveryDrones.drones.Drones;
import com.oluwadamilareisrael.deliveryDrones.drones.DronesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public void addNewDrones(@RequestBody Drones drones){dronesService.addNewDrones(drones);}

    @DeleteMapping(path = "{droneId}")
    public void deleteDrone(@PathVariable("droneId") Long studentId){
        dronesService.deleteDrone(studentId);
    }
    @PutMapping(path = "{droneId}")
    public void updateDrones(@PathVariable("droneId")
                             Drones drones){
        dronesService.updateDrone(drones);
    }
}
