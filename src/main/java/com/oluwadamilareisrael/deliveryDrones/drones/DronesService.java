package com.oluwadamilareisrael.deliveryDrones.drones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
