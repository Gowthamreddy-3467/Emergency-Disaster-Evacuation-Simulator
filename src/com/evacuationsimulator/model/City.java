package com.evacuationsimulator.model;

import com.evacuationsimulator.graph.Graph;

import java.util.HashMap;
import java.util.Map;

public class City {

    private Graph graph;

    private Map<String, Node> nodes;

    public City() {

        nodes = new HashMap<>();

    }

    public Graph getGraph() {

        return graph;

    }

    public void setGraph(Graph graph) {

        this.graph = graph;

    }

    public void addNode(Node node) {

        nodes.put(node.getLocationName(), node);

    }

    public Node getNode(String name) {

        return nodes.get(name);

    }

    public Map<String, Node> getNodes() {

        return nodes;

    }

}