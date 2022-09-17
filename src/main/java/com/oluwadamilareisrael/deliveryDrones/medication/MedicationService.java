package com.oluwadamilareisrael.deliveryDrones.medication;

import com.oluwadamilareisrael.deliveryDrones.drones.Drones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void deleteMedication(Long medicationId) {
        boolean exits = medicationRepository.existsById(medicationId);
        if (!exits){
            throw new IllegalStateException("The Medication with Id "+medicationId+" does not exist");
        }
        medicationRepository.deleteById(medicationId);
    }

    public void updateMedication(Long medicationId, String medName, double medWeight, String medCode) {
        Medication medication = medicationRepository.findById(medicationId).orElseThrow(() -> new IllegalStateException("The Medication with Id "+medicationId+" does not exist"));
        if (medName != null && medName.length() > 0 && !Objects.equals(medication.getMedName(), medName)){
            medication.setMedName(medName);
        }
        if (medCode != null && medCode.length() > 0 && !Objects.equals(medication.getMedCode(), medCode)){
            Optional<Medication> medicationOptional = medicationRepository.findDronesBymedCode(medCode);
            if (medicationOptional.isPresent()){
                throw new IllegalStateException("Medication Code already present");
            }
            medication.setMedCode(medCode);
        }
    }
}
