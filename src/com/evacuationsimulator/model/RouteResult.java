package com.evacuationsimulator.model;

import java.util.List;

public class RouteResult {

    private List<Node> route;
    private int totalCost;
    private String output;

    public RouteResult(List<Node> route, int totalCost, String output) {

        this.route = route;
        this.totalCost = totalCost;
        this.output = output;

    }

    public List<Node> getRoute() {
        return route;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getOutput() {
        return output;
    }

}