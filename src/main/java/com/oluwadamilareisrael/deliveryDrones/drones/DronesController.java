package com.oluwadamilareisrael.deliveryDrones.drones;

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
    public void updateStudent(@PathVariable("droneId") Long droneId,
                              @RequestParam(required = false) String droneName,
                              @RequestParam(required = false) String serialNumber,
                              @RequestParam(required = false) String droneModel,
                              @RequestParam(required = false) double weight,
                              @RequestParam(required = false) int battery,
                              @RequestParam(required = false) String state){
        dronesService.updateDrone(droneId, droneName, serialNumber, droneModel, weight,battery, state);
    }
}
