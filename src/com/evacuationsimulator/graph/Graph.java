package com.evacuationsimulator.graph;

import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node source, Node destination, int distance) {

        Edge edge = new Edge(source, destination, distance);

        source.addEdge(edge);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Node findNode(String name) {

        for (Node node : nodes) {

            if (node.getLocationName().equalsIgnoreCase(name)) {
                return node;
            }

        }

        return null;
    }

    public void displayGraph() {

        System.out.println("\n========== CITY MAP ==========\n");

        for (Node node : nodes) {

            System.out.println(node);

            for (Edge edge : node.getEdges()) {

                System.out.println("   --> "
                        + edge.getDestination().getLocationName()
                        + " ("
                        + edge.getDistance()
                        + " km)");
            }

            System.out.println();
        }

    }

}