package com.evacuationsimulator.simulation;

import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

public class DisasterSimulator {

    public void blockRoad(Graph graph,
                          String sourceName,
                          String destinationName) {

        for (Node node : graph.getNodes()) {

            for (Edge edge : node.getEdges()) {

                if (edge.getSource().getLocationName().equals(sourceName)
                        && edge.getDestination().getLocationName().equals(destinationName)) {

                    edge.setBlocked(true);

                    System.out.println("\n================================");
                    System.out.println(" ROAD BLOCKED ");
                    System.out.println("================================");
                    System.out.println(sourceName + " -> " + destinationName);

                    return;
                }

            }

        }

        System.out.println("Road not found.");

    }

}
