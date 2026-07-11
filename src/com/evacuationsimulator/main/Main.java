package com.evacuationsimulator.main;

import com.evacuationsimulator.algorithms.BFS;
import com.evacuationsimulator.algorithms.DFS;
import com.evacuationsimulator.algorithms.Dijkstra;
import com.evacuationsimulator.enums.LocationType;
import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

public class Main {

    public static void main(String[] args) {

        Graph city = new Graph();

        Node hospital = new Node("Hospital", LocationType.HOSPITAL);
        Node school = new Node("School", LocationType.SCHOOL);
        Node police = new Node("Police Station", LocationType.POLICE_STATION);
        Node shelter = new Node("Shelter", LocationType.SHELTER);

        city.addNode(hospital);
        city.addNode(school);
        city.addNode(police);
        city.addNode(shelter);

        city.addEdge(new Edge(hospital, school, 5));
        city.addEdge(new Edge(hospital, police, 3));
        city.addEdge(new Edge(police, shelter, 4));
        city.addEdge(new Edge(school, shelter, 6));

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