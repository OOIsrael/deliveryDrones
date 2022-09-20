package com.oluwadamilareisrael.deliveryDrones.medication;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table
public class Medication {
    @Id
    @SequenceGenerator(
            name = "medication",
            sequenceName = "medication_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "medication_sequence"
    )
   private Long id;
   private String medName;
   private double medWeight;
   private String medCode;
   private Blob medImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public double getMedWeight() {
        return medWeight;
    }

    public void setMedWeight(double medWeight) {
        this.medWeight = medWeight;
    }

    public String getMedCode() {
        return medCode;
    }

    public void setMedCode(String medCode) {
        this.medCode = medCode;
    }

    public Blob getMedImage() {
        return medImage;
    }

    public void setMedImage(Blob medImage) {
        this.medImage = medImage;
    }

    public Medication() {
    }

    public Medication(Long id, String medName, double medWeight, String medCode, Blob medImage) {
        this.id = id;
        this.medName = medName;
        this.medWeight = medWeight;
        this.medCode = medCode;
        this.medImage = medImage;
    }

    public Medication(String medName, double medWeight, String medCode, Blob medImage) {
        this.medName = medName;
        this.medWeight = medWeight;
        this.medCode = medCode;
        this.medImage = medImage;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", medName='" + medName + '\'' +
                ", medWeight=" + medWeight +
                ", medCode='" + medCode + '\'' +
                ", medImage=" + medImage +
                '}';
    }
}
