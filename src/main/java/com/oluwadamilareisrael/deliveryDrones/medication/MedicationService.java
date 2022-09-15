package com.oluwadamilareisrael.deliveryDrones.medication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getMedication(){
        return medicationRepository.findAll();
    }

    public void addNewMedication(Medication medication){
        System.out.println(medication);
        System.out.println("This is the code number: "+medication.getMedCode());

        Optional<Medication> medicationByMedCode = medicationRepository.findDronesBymedCode(medication.getMedCode());
        if(medicationByMedCode.isPresent()){
            throw new IllegalStateException("Medication already exists");
        }
        medicationRepository.save(medication);
    }
}
