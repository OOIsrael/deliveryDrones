package com.oluwadamilareisrael.deliveryDrones.loading;

public class Loading {
    private Long id;
    private String medName;
    private String medCode;

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

    public String getMedCode() {
        return medCode;
    }

    public void setMedCode(String medCode) {
        this.medCode = medCode;
    }

    public Loading(Long id, String medName, String medCode) {
        this.id = id;
        this.medName = medName;
        this.medCode = medCode;
    }

    public Loading() {
    }

    public Loading(String medName, String medCode) {
        this.medName = medName;
        this.medCode = medCode;
    }

    @Override
    public String toString() {
        return "Loading{" +
                "id=" + id +
                ", medName='" + medName + '\'' +
                ", medCode='" + medCode + '\'' +
                '}';
    }
}
