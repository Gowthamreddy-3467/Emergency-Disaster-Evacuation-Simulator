package com.evacuationsimulator.main;

import com.evacuationsimulator.algorithms.BFS;
import com.evacuationsimulator.algorithms.DFS;
import com.evacuationsimulator.algorithms.Dijkstra;
import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Node;
import com.evacuationsimulator.services.CityBuilder;
import com.evacuationsimulator.model.City;

public class Main {

    public static void main(String[] args) {

        // Create the city
        City cityModel = CityBuilder.createCity();

        Graph city = cityModel.getGraph();

        // Get required locations from the graph
        Node hospital = cityModel.getHospital();
        Node shelter = cityModel.getShelter();

        // Display Graph
        city.displayGraph();

        // Dijkstra
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.shortestPath(city, hospital, shelter);

        // BFS
        BFS bfs = new BFS();
        bfs.traverse(city, hospital);

        // DFS
        DFS dfs = new DFS();
        dfs.traverse(city, hospital);

    }
}