package com.evacuationsimulator.main;

import com.evacuationsimulator.enums.LocationType;
import com.evacuationsimulator.graph.Graph;
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

        city.addEdge(hospital, school, 5);
        city.addEdge(hospital, police, 3);
        city.addEdge(police, shelter, 4);
        city.addEdge(school, shelter, 6);

        city.displayGraph();

    }

}