package com.evacuationsimulator.model;

import com.evacuationsimulator.enums.LocationType;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String locationName;
    private LocationType locationType;
    private boolean visited;

    private List<Edge> edges;

    public Node(String locationName, LocationType locationType) {
        this.locationName = locationName;
        this.locationType = locationType;
        this.visited = false;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public String getLocationName() {
        return locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return locationName + " [" + locationType + "]";
    }
}