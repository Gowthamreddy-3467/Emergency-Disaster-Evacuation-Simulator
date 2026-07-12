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

    public void addEdge(Edge edge) {

        edge.getSource().addEdge(edge);

    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void resetVisited() {

        for (Node node : nodes) {
            node.setVisited(false);
        }

    }

    public void displayGraph() {

        System.out.println("\n========== CITY MAP ==========\n");

        for (Node node : nodes) {

            System.out.println(node);

            if (node.getEdges().isEmpty()) {

                System.out.println("   No Connected Roads");

            } else {

                for (Edge edge : node.getEdges()) {

                    System.out.println("   --> "
                            + edge.getDestination().getLocationName()
                            + " ("
                            + edge.getDistance()
                            + " km"
                            + ", Traffic: "
                            + edge.getTrafficLevel()
                            + ")");

                }

            }

            System.out.println();

        }

    }

}