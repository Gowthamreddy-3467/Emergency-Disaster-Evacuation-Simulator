package com.evacuationsimulator.algorithms;

import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void traverse(Graph graph, Node start) {

        graph.resetVisited();

        Queue<Node> queue = new LinkedList<>();

        start.setVisited(true);

        queue.add(start);

        System.out.println("\n========== BFS Traversal ==========\n");

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.println(current.getLocationName());

            for (Edge edge : current.getEdges()) {

                Node neighbour = edge.getDestination();

                if (!neighbour.isVisited()) {

                    neighbour.setVisited(true);

                    queue.add(neighbour);

                }

            }

        }

    }

}