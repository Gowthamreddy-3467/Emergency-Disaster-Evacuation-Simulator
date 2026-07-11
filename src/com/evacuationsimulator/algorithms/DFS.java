package com.evacuationsimulator.algorithms;

import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

public class DFS {

    public void traverse(Graph graph, Node start) {

        graph.resetVisited();

        System.out.println("\n========== DFS Traversal ==========\n");

        dfs(start);

    }

    private void dfs(Node node) {

        node.setVisited(true);

        System.out.println(node.getLocationName());

        for (Edge edge : node.getEdges()) {

            Node neighbour = edge.getDestination();

            if (!neighbour.isVisited()) {

                dfs(neighbour);

            }

        }

    }

}