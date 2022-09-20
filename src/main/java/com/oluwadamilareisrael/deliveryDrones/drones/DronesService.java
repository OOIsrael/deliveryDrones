package com.oluwadamilareisrael.deliveryDrones.drones;

import com.oluwadamilareisrael.deliveryDrones.exceptionHandler.ExceptionHandlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DronesService {
    private final DronesRepository dronesRepository;

    @Autowired
    public DronesService(DronesRepository dronesRepository) {
        this.dronesRepository = dronesRepository;
    }

    public List<Drones> getDrones(){
        return dronesRepository.findAll();
    }

    public void addNewDrones(Drones drones){
        System.out.println(drones);
        System.out.println("This is the serial number: "+drones.getSerialNumber());

        Optional<Drones> dronesBySerialNumber = dronesRepository.findDronesBySerialNumber(drones.getSerialNumber());
        if(dronesBySerialNumber.isPresent()){
            //throw new IllegalStateException("Drone already exists");
            throw new ExceptionHandlers.valueNotFound();
        }
        dronesRepository.save(drones);
    }

    public void deleteDrone(Long droneId) {
        boolean exits = dronesRepository.existsById(droneId);
        if (!exits){
            throw new IllegalStateException("The Drone with Id "+droneId+" does not exist");
        }
        dronesRepository.deleteById(droneId);
    }

    //public void updateDrone(Long droneId, String droneName, String serialNumber, String droneModel, double weight, int battery, String state) {
    public boolean updateDrone(Drones drones) {
        Drones drones1 = dronesRepository.findById(drones.getId()).orElseThrow(() -> new IllegalStateException("The Drone with Id "+drones.getId()+" does not exist"));
        if (drones.getDroneName() != null && drones.getDroneName().length() > 0 && !Objects.equals(drones1.getDroneName(), drones.getDroneName())){
            drones.setDroneName(drones.getDroneName());
        }
        if (drones.getSerialNumber() != null && drones.getSerialNumber().length() > 0 && !Objects.equals(drones1.getSerialNumber(), drones.getSerialNumber())){
            Optional<Drones> dronesOptional = dronesRepository.findDronesBySerialNumber(drones.getSerialNumber());
            if (dronesOptional.isPresent()){
                throw new IllegalStateException("Serial Number already present");
            }
            drones.setSerialNumber(drones.getSerialNumber());
        }
        if (drones.getDroneModel() != null && drones.getDroneModel().length() > 0 && !Objects.equals(drones1.getDroneModel(), drones.getDroneModel())){
            Optional<Drones> dronesOptional = dronesRepository.findDronesModel(drones.getDroneModel());
            if (dronesOptional.isPresent()){
                throw new IllegalStateException("Model Number already present");
            }
            drones.setSerialNumber(drones.getDroneModel());
        }
        if (drones.getWeight() != 0 && drones.getWeight() > 0){
            drones.setWeight(drones.getWeight());
        }else{
            throw new IllegalStateException("Drone weight must be greater than Zero (0)");
        }
        if (drones.getBattery() != 0 && drones.getBattery() > 0){
            drones.setBattery(drones.getBattery());
        }else{
            throw new IllegalStateException("Drone battery must be greater than Zero (0)");
        }
        if (drones.getState() != null && drones.getState().length() > 0){
            drones.setState(drones.getState());
        }else{
            throw new IllegalStateException("Invalid State value");
        }

        return true;
    }
}
