package com.evacuationsimulator.algorithms;

import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;
import com.evacuationsimulator.model.RouteResult;

import java.util.*;

public class Dijkstra {

    public RouteResult shortestPath(Graph graph, Node source, Node destination) {

        HashMap<Node, Integer> distance = new HashMap<>();
        HashMap<Node, Node> previous = new HashMap<>();

        PriorityQueue<NodeDistance> queue = new PriorityQueue<>();

        for (Node node : graph.getNodes()) {
            distance.put(node, Integer.MAX_VALUE);
        }

        distance.put(source, 0);

        queue.offer(new NodeDistance(source, 0));

        while (!queue.isEmpty()) {

            NodeDistance current = queue.poll();
            Node currentNode = current.getNode();

            if (current.getDistance() > distance.get(currentNode)) {
                continue;
            }

            for (Edge edge : currentNode.getEdges()) {

                if (edge.isBlocked()) {
                    continue;
                }

                Node neighbour = edge.getDestination();

                int newDistance =
                        distance.get(currentNode) + edge.getTravelCost();

                if (newDistance < distance.get(neighbour)) {

                    distance.put(neighbour, newDistance);
                    previous.put(neighbour, currentNode);

                    queue.offer(new NodeDistance(neighbour, newDistance));
                }
            }
        }

        return buildResult(previous, distance, source, destination);
    }

    private RouteResult buildResult(
            HashMap<Node, Node> previous,
            HashMap<Node, Integer> distance,
            Node source,
            Node destination) {

        List<Node> route = new ArrayList<>();

        Node current = destination;

        while (current != null) {

            route.add(current);
            current = previous.get(current);

        }

        Collections.reverse(route);

        StringBuilder output = new StringBuilder();

        output.append("══════════════════════════════════════════════════════\n");
        output.append("        🚑 EVACUAID - SHORTEST ROUTE\n");
        output.append("══════════════════════════════════════════════════════\n\n");

        output.append("📍 SOURCE\n");
        output.append("----------------------------------------------\n");
        output.append(source.getLocationName());

        output.append("\n\n");

        output.append("🎯 DESTINATION\n");
        output.append("----------------------------------------------\n");
        output.append(destination.getLocationName());

        output.append("\n\n");

        output.append("🛣 SHORTEST ROUTE\n");
        output.append("----------------------------------------------\n\n");

        for (int i = 0; i < route.size(); i++) {

            output.append("   ");

            output.append(route.get(i).getLocationName());

            if (i != route.size() - 1) {

                output.append("\n");
                output.append("        │\n");
                output.append("        ▼\n");

            }

        }

        output.append("\n\n");

        output.append("══════════════════════════════════════════════════════\n");

        output.append("📏 TOTAL TRAVEL COST : ");
        output.append(distance.get(destination));
        output.append(" Units\n");

        output.append("🚦 ROUTE STATUS : SAFE\n");

        output.append("══════════════════════════════════════════════════════\n");

        output.append("\n");

        output.append("✅ Route Generated Successfully");

        return new RouteResult(
                route,
                distance.get(destination),
                output.toString());

    }

}