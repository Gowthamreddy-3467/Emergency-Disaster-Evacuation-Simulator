package com.evacuationsimulator.algorithms;

import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

import java.util.*;

public class Dijkstra {

    public void shortestPath(Graph graph, Node source, Node destination) {

        HashMap<Node, Integer> distance = new HashMap<>();
        HashMap<Node, Node> previous = new HashMap<>();

        PriorityQueue<NodeDistance> queue = new PriorityQueue<>();

        // Initialize distances
        for (Node node : graph.getNodes()) {
            distance.put(node, Integer.MAX_VALUE);
        }

        distance.put(source, 0);

        queue.add(new NodeDistance(source, 0));

        while (!queue.isEmpty()) {

            NodeDistance current = queue.poll();

            Node currentNode = current.getNode();

            for (Edge edge : currentNode.getEdges()) {

                Node neighbour = edge.getDestination();

                int newDistance =
                        distance.get(currentNode) + edge.getDistance();

                if (newDistance < distance.get(neighbour)) {

                    distance.put(neighbour, newDistance);

                    previous.put(neighbour, currentNode);

                    queue.add(new NodeDistance(neighbour, newDistance));

                }

            }

        }

        printPath(previous, distance, source, destination);

    }

    private void printPath(HashMap<Node, Node> previous,
                           HashMap<Node, Integer> distance,
                           Node source,
                           Node destination) {

        List<Node> path = new ArrayList<>();

        Node current = destination;

        while (current != null) {

            path.add(current);

            current = previous.get(current);

        }

        Collections.reverse(path);

        System.out.println("\n===============================");
        System.out.println(" SHORTEST EVACUATION ROUTE ");
        System.out.println("===============================\n");

        for (int i = 0; i < path.size(); i++) {

            System.out.print(path.get(i).getLocationName());

            if (i != path.size() - 1) {
                System.out.print("  -->  ");
            }

        }

        System.out.println();

        System.out.println("\nTotal Distance : "
                + distance.get(destination)
                + " km");

    }

}