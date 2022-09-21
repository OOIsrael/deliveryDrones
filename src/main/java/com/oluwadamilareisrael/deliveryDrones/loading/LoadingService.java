package com.oluwadamilareisrael.deliveryDrones.loading;

import com.oluwadamilareisrael.deliveryDrones.drones.Drones;
import com.oluwadamilareisrael.deliveryDrones.drones.DronesRepository;
import com.oluwadamilareisrael.deliveryDrones.exceptionHandler.ExceptionHandlers;
import com.oluwadamilareisrael.deliveryDrones.medication.Medication;
import com.oluwadamilareisrael.deliveryDrones.medication.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadingService {

    private DronesRepository dronesRepository;
    private MedicationRepository medicationRepository;

    @Autowired
    public void DronesService(DronesRepository dronesRepository) {
        this.dronesRepository = dronesRepository;
    }

    @Autowired
    public void MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }
    
    public boolean loadMedication(Loading loading){
        //validate medCode
        Optional<Medication> loadingByMedCode = medicationRepository.findDronesBymedCode(loading.getMedCode());
        if(loadingByMedCode.isPresent()){
            throw new ExceptionHandlers.valueNotFound();
        }
        //validate medName
        Optional<Medication> loadingByMedName = medicationRepository.findDronesBymedName(loading.getMedName());
        if(loadingByMedName.isPresent()){
            throw new ExceptionHandlers.valueNotFound();
        }
        //get available drones for loading
        Optional<Drones> availableDrone = dronesRepository.findDronesByState("IDLE");
        if(!availableDrone.isPresent()){
            //Change state of the drone
            Drones drones = null;
            drones.setState("LOADING");
        }

        return true;
    }
}
