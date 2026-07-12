package com.evacuationsimulator.model;

import com.evacuationsimulator.enums.TrafficLevel;

public class Edge {

    private Node source;
    private Node destination;
    private int distance;
    private TrafficLevel trafficLevel;
    private boolean blocked;

    public Edge(Node source,
                Node destination,
                int distance,
                TrafficLevel trafficLevel) {

        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.trafficLevel = trafficLevel;
        this.blocked = false;

    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public TrafficLevel getTrafficLevel() {
        return trafficLevel;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getTravelCost() {

        switch (trafficLevel) {

            case LOW:
                return distance;

            case MEDIUM:
                return distance * 2;

            case HIGH:
                return distance * 3;

            default:
                return distance;
        }

    }

    @Override
    public String toString() {

        return source.getLocationName()
                + " -> "
                + destination.getLocationName()
                + " ("
                + distance
                + " km, Traffic: "
                + trafficLevel
                + ", Blocked: "
                + blocked
                + ")";
    }
}