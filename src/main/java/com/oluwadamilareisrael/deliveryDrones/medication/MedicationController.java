package com.oluwadamilareisrael.deliveryDrones.medication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/medication")
public class MedicationController {
    private MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/All")
    public List<Medication> getMedication(){
        return medicationService.getMedication();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addNewDrones(@RequestBody Medication medication){
        medicationService.addNewMedication(medication);
    }

    @DeleteMapping(path = "{medicationId}")
    public void deleteMedication(@PathVariable("medicationId") Long medicationId){
        medicationService.deleteMedication(medicationId);
    }
    @PutMapping(path = "{medicationId}")
    public void updateStudent(@PathVariable("medicationId") Long medicationId,
                              @RequestParam(required = false) String medName,
                              @RequestParam(required = false) double medWeight,
                              @RequestParam(required = false) String medCode){
        medicationService.updateMedication(medicationId, medName, medWeight, medCode);
    }
}
