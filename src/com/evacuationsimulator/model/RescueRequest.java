package com.evacuationsimulator.model;

import com.evacuationsimulator.enums.RescuePriority;
import com.evacuationsimulator.enums.VehicleType;

public class RescueRequest implements Comparable<RescueRequest> {

    private String personName;
    private Node location;
    private RescuePriority priority;
    private VehicleType vehicleType;
    private String emergency;

    public RescueRequest(String personName,
                         Node location,
                         RescuePriority priority,
                         VehicleType vehicleType,
                         String emergency) {

        this.personName = personName;
        this.location = location;
        this.priority = priority;
        this.vehicleType = vehicleType;
        this.emergency = emergency;
    }

    public String getPersonName() {
        return personName;
    }

    public Node getLocation() {
        return location;
    }

    public RescuePriority getPriority() {
        return priority;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getEmergency() {
        return emergency;
    }

    @Override
    public int compareTo(RescueRequest other) {

        return this.priority.ordinal() - other.priority.ordinal();

    }

    @Override
    public String toString() {

        return "Person : " + personName +
                "\nLocation : " + location.getLocationName() +
                "\nPriority : " + priority +
                "\nVehicle : " + vehicleType +
                "\nEmergency : " + emergency;

    }

}