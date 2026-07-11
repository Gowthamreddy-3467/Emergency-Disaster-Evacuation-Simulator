package com.evacuationsimulator.model;

import com.evacuationsimulator.enums.LocationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private String locationName;
    private LocationType locationType;
    private List<Edge> edges;
    private boolean visited;

    public Node(String locationName, LocationType locationType) {
        this.locationName = locationName;
        this.locationType = locationType;
        this.edges = new ArrayList<>();
        this.visited = false;
    }

    public String getLocationName() {
        return locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
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

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Node))
            return false;

        Node other = (Node) obj;

        return Objects.equals(locationName, other.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName);
    }

}