package com.oluwadamilareisrael.deliveryDrones.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
      @Query("SELECT s FROM Medication s where s.medCode = :medCode")
    Optional<Medication> findDronesBymedCode(String medCode);

    @Query("SELECT s FROM Medication s where s.medName = :medName")
    Optional<Medication> findDronesBymedName(String medName);
}
