package com.oluwadamilareisrael.deliveryDrones.drones;

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
            throw new IllegalStateException("Drone already exists");
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

    public void updateDrone(Long droneId, String droneName, String serialNumber, String droneModel, double weight, int battery, String state) {
        Drones drones = dronesRepository.findById(droneId).orElseThrow(() -> new IllegalStateException("The Drone with Id "+droneId+" does not exist"));
        if (droneName != null && droneName.length() > 0 && !Objects.equals(drones.getDroneName(), droneName)){
            drones.setDroneName(droneName);
        }
        if (serialNumber != null && serialNumber.length() > 0 && !Objects.equals(drones.getSerialNumber(), serialNumber)){
            Optional<Drones> dronesOptional = dronesRepository.findDronesBySerialNumber(serialNumber);
            if (dronesOptional.isPresent()){
                throw new IllegalStateException("Serial Number already present");
            }
            drones.setSerialNumber(serialNumber);
        }
    }
}
