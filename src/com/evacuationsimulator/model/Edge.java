package com.evacuationsimulator.model;

public class Edge {

    private Node source;
    private Node destination;
    private int distance;

    public Edge(Node source, Node destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
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

    @Override
    public String toString() {
        return source.getLocationName()
                + " -> "
                + destination.getLocationName()
                + " ("
                + distance
                + " km)";
    }
}