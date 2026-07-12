package com.evacuationsimulator.gui;

import com.evacuationsimulator.algorithms.Dijkstra;
import com.evacuationsimulator.algorithms.PriorityQueueManager;
import com.evacuationsimulator.enums.RescuePriority;
import com.evacuationsimulator.enums.VehicleType;
import com.evacuationsimulator.graph.Graph;
import com.evacuationsimulator.model.City;
import com.evacuationsimulator.model.Node;
import com.evacuationsimulator.model.RescueRequest;
import com.evacuationsimulator.model.RouteResult;
import com.evacuationsimulator.services.CityBuilder;
import com.evacuationsimulator.simulation.DisasterManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private LeftControlPanel leftControlPanel;
    private RightOutputPanel rightOutputPanel;
    private StatusPanel statusPanel;

    private City city;
    private Graph graph;

    private PriorityQueueManager queueManager;

    public MainFrame() {

        city = CityBuilder.createCity();
        graph = city.getGraph();

        queueManager = new PriorityQueueManager();

        loadSampleRequests();

        setTitle("EvacuAid - Emergency Control Center");

        setSize(1120, 650);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "EvacuAid - Smart Disaster Response & Evacuation System",
                SwingConstants.CENTER);

        title.setFont(new Font("Segoe UI", Font.BOLD, 30));

        title.setForeground(AppColors.TITLE);

        title.setBorder(BorderFactory.createEmptyBorder(15,10,15,10));

        add(title, BorderLayout.NORTH);

        leftControlPanel = new LeftControlPanel();
        leftControlPanel.setPreferredSize(new Dimension(280, 0));

        rightOutputPanel = new RightOutputPanel();

        statusPanel = new StatusPanel();

        add(leftControlPanel, BorderLayout.WEST);
        add(rightOutputPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        connectEvents();

        setVisible(true);
    }

    private void loadSampleRequests() {

        queueManager.addRequest(
                new RescueRequest(
                        "Rahul",
                        city.getNode("Hospital"),
                        RescuePriority.CRITICAL,
                        VehicleType.AMBULANCE,
                        "Heart Attack"));

        queueManager.addRequest(
                new RescueRequest(
                        "Kiran",
                        city.getNode("Airport"),
                        RescuePriority.HIGH,
                        VehicleType.FIRE_TRUCK,
                        "Aircraft Fire"));

        queueManager.addRequest(
                new RescueRequest(
                        "Priya",
                        city.getNode("Police Station"),
                        RescuePriority.MEDIUM,
                        VehicleType.POLICE_VEHICLE,
                        "Road Accident"));

        queueManager.addRequest(
                new RescueRequest(
                        "Arjun",
                        city.getNode("Fire Station"),
                        RescuePriority.LOW,
                        VehicleType.RESCUE_BUS,
                        "Minor Injury"));
    }

    private void connectEvents() {

        // ===============================
        // FIND ROUTE
        // ===============================
        leftControlPanel.getFindRouteButton().addActionListener(e -> {

            String sourceName =
                    (String) leftControlPanel.getSourceBox().getSelectedItem();

            String destinationName =
                    (String) leftControlPanel.getDestinationBox().getSelectedItem();

            Node source = city.getNode(sourceName);
            Node destination = city.getNode(destinationName);

            if (source == null || destination == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid source or destination.");

                return;
            }

            Dijkstra dijkstra = new Dijkstra();

            RouteResult result =
                    dijkstra.shortestPath(graph, source, destination);

            rightOutputPanel.setOutput(result.getOutput());
            rightOutputPanel.highlightRoute(result.getRoute());

            statusPanel.setSystemStatus("ROUTE GENERATED");
            statusPanel.setPendingRequests(
                    queueManager.getPendingRequestCount());
            statusPanel.setTrafficLevel("MEDIUM");
            statusPanel.setRoadCount(12);

        });

        // ===============================
        // SIMULATE DISASTER
        // ===============================
        leftControlPanel.getSimulateButton().addActionListener(e -> {

            String disaster =
                    (String) leftControlPanel.getDisasterBox().getSelectedItem();

            DisasterManager manager = new DisasterManager();

            String result = manager.simulate(disaster);

            // Clear any highlighted route
            rightOutputPanel.getCityMapPanel().clearRoute();

            rightOutputPanel.setOutput(result);

            statusPanel.setSystemStatus("DISASTER ACTIVE");
            statusPanel.setTrafficLevel("HIGH");
            statusPanel.setRoadCount(10);

        });;

        // ===============================
        // RESCUE QUEUE
        // ===============================
        leftControlPanel.getRescueQueueButton().addActionListener(e -> {

            // Clear any highlighted route
            rightOutputPanel.getCityMapPanel().clearRoute();

            rightOutputPanel.setOutput(
                    queueManager.getQueueAsString());

            statusPanel.setSystemStatus("QUEUE LOADED");
            statusPanel.setPendingRequests(
                    queueManager.getPendingRequestCount());

        });

    }

}