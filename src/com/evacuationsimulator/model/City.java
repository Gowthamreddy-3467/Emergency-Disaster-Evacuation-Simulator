package com.evacuationsimulator.model;

import com.evacuationsimulator.graph.Graph;

public class City {

    private Graph graph;

    private Node hospital;
    private Node shelter;
    private Node policeStation;
    private Node fireStation;
    private Node airport;

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Node getHospital() {
        return hospital;
    }

    public void setHospital(Node hospital) {
        this.hospital = hospital;
    }

    public Node getShelter() {
        return shelter;
    }

    public void setShelter(Node shelter) {
        this.shelter = shelter;
    }

    public Node getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(Node policeStation) {
        this.policeStation = policeStation;
    }

    public Node getFireStation() {
        return fireStation;
    }

    public void setFireStation(Node fireStation) {
        this.fireStation = fireStation;
    }

    public Node getAirport() {
        return airport;
    }

    public void setAirport(Node airport) {
        this.airport = airport;
    }

}