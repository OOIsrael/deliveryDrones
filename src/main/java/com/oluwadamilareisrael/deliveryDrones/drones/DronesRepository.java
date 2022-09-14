package com.oluwadamilareisrael.deliveryDrones.drones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DronesRepository extends JpaRepository<Drones,Long> {
    @Query("SELECT s FROM Drones s where s.serialNumber = :serialNumber")
    Optional<Drones> findDronesBySerialNumber(String serialNumber);
}
