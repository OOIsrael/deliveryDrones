package com.oluwadamilareisrael.deliveryDrones.medication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.oluwadamilareisrael.deliveryDrones.exceptionHandler.ExceptionHandlers;

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

    public boolean addNewMedication(Medication medication){
        System.out.println(medication);
        System.out.println("This is the code number: "+medication.getMedCode());

        Optional<Medication> medicationByMedCode = medicationRepository.findDronesBymedCode(medication.getMedCode());
        if(medicationByMedCode.isPresent()){
            //throw new IllegalStateException("Medication already exists");
            throw new ExceptionHandlers.valueNotFound();
        }
        medicationRepository.save(medication);

        return true;
    }

    public boolean deleteMedication(Long medicationId) {
        boolean exits = medicationRepository.existsById(medicationId);
        if (!exits){
            throw new IllegalStateException("The Medication with Id "+medicationId+" does not exist");
        }
        medicationRepository.deleteById(medicationId);

        return true;
    }

    //public boolean updateMedication(Long medicationId, String medName, double medWeight, String medCode) {
    public boolean updateMedication(Medication medication) {
        Medication medication1 = medicationRepository.findById (medication.getId()).orElseThrow(() -> new IllegalStateException("The Medication with Id "+medication.getId()+" does not exist"));
        if (medication.getMedName() != null && medication.getMedName().length() > 0 && !Objects.equals(medication1.getMedName(), medication.getMedName())){
            medication.setMedName(medication.getMedName());
        }
        if (medication.getMedCode() != null && medication.getMedCode().length() > 0 && !Objects.equals(medication1.getMedCode(), medication.getMedCode())){
            Optional<Medication> medicationByMedCode = medicationRepository.findDronesBymedCode(medication.getMedCode());
            if (medicationByMedCode.isPresent()){
                throw new IllegalStateException("Medication Code already present");
            }
            medication.setMedCode(medication.getMedCode());
        }
        if (medication.getMedWeight() != 0 && medication.getMedWeight() > 0){
            medication.setMedCode(medication.getMedCode());
        }else{
            throw new IllegalStateException("Medication weight must be greater than Zero (0)");
        }
        return true;
    }
}
