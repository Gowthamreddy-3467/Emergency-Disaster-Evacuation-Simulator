package com.evacuationsimulator.services;

import com.evacuationsimulator.enums.LocationType;
import com.evacuationsimulator.enums.TrafficLevel;
import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.City;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;

public class CityBuilder {

    public static City createCity() {

        Graph graph = new Graph();

        // Create Nodes
        Node hospital = new Node("Hospital", LocationType.HOSPITAL);
        Node school = new Node("School", LocationType.SCHOOL);
        Node police = new Node("Police Station", LocationType.POLICE_STATION);
        Node fire = new Node("Fire Station", LocationType.FIRE_STATION);
        Node shelter = new Node("Shelter", LocationType.SHELTER);
        Node busStand = new Node("Bus Stand", LocationType.BUS_STAND);
        Node railway = new Node("Railway Station", LocationType.RAILWAY_STATION);
        Node airport = new Node("Airport", LocationType.AIRPORT);
        Node mall = new Node("Shopping Mall", LocationType.MALL);
        Node residential = new Node("Residential Area", LocationType.RESIDENTIAL_AREA);
        Node government = new Node("Government Office", LocationType.GOVERNMENT_OFFICE);
        Node park = new Node("City Park", LocationType.PARK);

        City city = new City();

        // Add nodes to Graph
        graph.addNode(hospital);
        graph.addNode(school);
        graph.addNode(police);
        graph.addNode(fire);
        graph.addNode(shelter);
        graph.addNode(busStand);
        graph.addNode(railway);
        graph.addNode(airport);
        graph.addNode(mall);
        graph.addNode(residential);
        graph.addNode(government);
        graph.addNode(park);

        // Add nodes to City lookup
        city.addNode(hospital);
        city.addNode(school);
        city.addNode(police);
        city.addNode(fire);
        city.addNode(shelter);
        city.addNode(busStand);
        city.addNode(railway);
        city.addNode(airport);
        city.addNode(mall);
        city.addNode(residential);
        city.addNode(government);
        city.addNode(park);

        // Roads
        graph.addEdge(new Edge(hospital, school, 5, TrafficLevel.HIGH));
        graph.addEdge(new Edge(hospital, fire, 4, TrafficLevel.LOW));

        graph.addEdge(new Edge(fire, police, 3, TrafficLevel.LOW));

        graph.addEdge(new Edge(police, shelter, 4, TrafficLevel.MEDIUM));

        graph.addEdge(new Edge(school, mall, 6, TrafficLevel.HIGH));
        graph.addEdge(new Edge(school, busStand, 3, TrafficLevel.MEDIUM));

        graph.addEdge(new Edge(busStand, railway, 4, TrafficLevel.MEDIUM));
        graph.addEdge(new Edge(busStand, park, 3, TrafficLevel.LOW));

        graph.addEdge(new Edge(railway, airport, 7, TrafficLevel.LOW));

        graph.addEdge(new Edge(mall, residential, 2, TrafficLevel.HIGH));

        graph.addEdge(new Edge(residential, shelter, 3, TrafficLevel.MEDIUM));

        graph.addEdge(new Edge(government, shelter, 5, TrafficLevel.LOW));

        graph.addEdge(new Edge(park, residential, 2, TrafficLevel.LOW));

        city.setGraph(graph);

        return city;

    }

}