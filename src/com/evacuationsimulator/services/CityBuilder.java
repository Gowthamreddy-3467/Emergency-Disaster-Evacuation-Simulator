package com.evacuationsimulator.services;

import com.evacuationsimulator.enums.LocationType;
import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.Edge;
import com.evacuationsimulator.model.Node;
import com.evacuationsimulator.model.City;

public class CityBuilder {

    public static City createCity() {

        Graph city = new Graph();

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

        City cityModel = new City();

        cityModel.setHospital(hospital);
        cityModel.setShelter(shelter);
        cityModel.setPoliceStation(police);
        cityModel.setFireStation(fire);
        cityModel.setAirport(airport);

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

        city.addEdge(new Edge(hospital, school, 5));
        city.addEdge(new Edge(hospital, fire, 4));
        city.addEdge(new Edge(fire, police, 3));
        city.addEdge(new Edge(police, shelter, 4));
        city.addEdge(new Edge(school, mall, 6));
        city.addEdge(new Edge(school, busStand, 3));
        city.addEdge(new Edge(busStand, railway, 4));
        city.addEdge(new Edge(busStand, park, 3));
        city.addEdge(new Edge(railway, airport, 7));
        city.addEdge(new Edge(mall, residential, 2));
        city.addEdge(new Edge(residential, shelter, 3));
        city.addEdge(new Edge(government, shelter, 5));
        city.addEdge(new Edge(park, residential, 2));

        cityModel.setGraph(city);

        return cityModel;

    }

}