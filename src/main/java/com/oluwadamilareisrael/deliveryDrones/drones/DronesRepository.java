package com.oluwadamilareisrael.deliveryDrones.drones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DronesRepository extends JpaRepository<Drones,Long> {
    @Query("SELECT s FROM Drones s where s.serialNumber = :serialNumber")
    Optional<Drones> findDronesBySerialNumber(String serialNumber);

    @Query("SELECT s FROM Drones s where s.droneModel = :droneModel")
    Optional<Drones> findDronesModel(String droneModel);

    @Query("SELECT s FROM Drones s where s.state = :state and battery > 25 and rownum=1")
    Optional<Drones> findDronesByState(String state);
}
