package com.oluwadamilareisrael.deliveryDrones.drones;


import javax.persistence.*;

@Entity
@Table
public class Drones {

    @Id
    @SequenceGenerator(
            name = "drones",
            sequenceName = "drones_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "drones_sequence"
    )
    private Long id;
    private String droneName;
    private String serialNumber;
    private String droneModel;
    private double weight;
    private int battery;
    private String state;

    public Drones(Long id, String droneName, String serialNumber, String droneModel, double weight, int battery, String state) {
        this.id = id;
        this.droneName = droneName;
        this.serialNumber = serialNumber;
        this.droneModel = droneModel;
        this.weight = weight;
        this.battery = battery;
        this.state = state;
    }

    public Drones() {
    }

    public Drones(String droneName, String serialNumber, String droneModel, double weight, int battery, String state) {
        this.droneName = droneName;
        this.serialNumber = serialNumber;
        this.droneModel = droneModel;
        this.weight = weight;
        this.battery = battery;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDroneName() {
        return droneName;
    }

    public void setDroneName(String droneName) {
        this.droneName = droneName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDroneModel() {
        return droneModel;
    }

    public void setDroneModel(String droneModel) {
        this.droneModel = droneModel;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Drones{" +
                "id=" + id +
                ", droneName='" + droneName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", droneModel='" + droneModel + '\'' +
                ", weight=" + weight +
                ", battery=" + battery +
                ", state='" + state + '\'' +
                '}';
    }
}
