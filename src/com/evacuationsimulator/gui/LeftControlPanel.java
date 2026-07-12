package com.evacuationsimulator.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LeftControlPanel extends JPanel {

    private JComboBox<String> sourceBox;
    private JComboBox<String> destinationBox;
    private JComboBox<String> disasterBox;
    private JComboBox<String> vehicleBox;

    private JButton findRouteButton;
    private JButton simulateButton;
    private JButton rescueQueueButton;

    public LeftControlPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(AppColors.SIDEBAR);

        setBorder(new EmptyBorder(20,20,20,20));

        add(createTitle("🚨 CONTROL PANEL"));

        add(Box.createVerticalStrut(25));

        // =========================
        // SOURCE
        // =========================

        add(createLabel("📍 Source Location"));

        sourceBox = createComboBox(new String[]{
                "Hospital",
                "School",
                "Fire Station",
                "Police Station",
                "Shelter",
                "Airport"
        });

        add(sourceBox);

        add(Box.createVerticalStrut(18));

        // =========================
        // DESTINATION
        // =========================

        add(createLabel("🎯 Destination"));

        destinationBox = createComboBox(new String[]{
                "Shelter",
                "Hospital",
                "Airport",
                "Residential Area"
        });

        add(destinationBox);

        add(Box.createVerticalStrut(18));

        // =========================
        // DISASTER
        // =========================

        add(createLabel("🌪 Disaster Type"));

        disasterBox = createComboBox(new String[]{
                "None",
                "Flood",
                "Fire",
                "Earthquake",
                "Cyclone"
        });

        add(disasterBox);

        add(Box.createVerticalStrut(18));

        // =========================
        // VEHICLE
        // =========================

        add(createLabel("🚑 Rescue Vehicle"));

        vehicleBox = createComboBox(new String[]{
                "Ambulance",
                "Fire Truck",
                "Police Vehicle",
                "Rescue Bus"
        });

        add(vehicleBox);

        add(Box.createVerticalGlue());

        // =========================
        // BUTTONS
        // =========================

        findRouteButton = createButton("🗺 Find Route");

        simulateButton = createButton("🚨 Simulate Disaster");

        rescueQueueButton = createButton("🚑 Rescue Queue");

        add(findRouteButton);

        add(Box.createVerticalStrut(15));

        add(simulateButton);

        add(Box.createVerticalStrut(15));

        add(rescueQueueButton);

    }

    private JLabel createTitle(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(Color.WHITE);

        label.setFont(new Font("Segoe UI", Font.BOLD, 22));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return label;

    }

    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setForeground(Color.WHITE);

        label.setFont(new Font("Segoe UI", Font.BOLD, 15));

        label.setBorder(new EmptyBorder(0,0,5,0));

        return label;

    }

    private JComboBox<String> createComboBox(String[] items) {

        JComboBox<String> comboBox = new JComboBox<>(items);

        comboBox.setMaximumSize(new Dimension(240,40));

        comboBox.setPreferredSize(new Dimension(240,40));

        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        comboBox.setBackground(Color.WHITE);

        return comboBox;

    }

    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setBackground(AppColors.BUTTON);

        button.setForeground(AppColors.BUTTON_TEXT);

        button.setFocusPainted(false);

        button.setFont(new Font("Segoe UI", Font.BOLD, 15));

        button.setMaximumSize(new Dimension(240,45));

        button.setPreferredSize(new Dimension(240,45));

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setBorder(BorderFactory.createEmptyBorder(8,10,8,10));

        return button;

    }

    public JButton getFindRouteButton() {
        return findRouteButton;
    }

    public JButton getSimulateButton() {
        return simulateButton;
    }

    public JButton getRescueQueueButton() {
        return rescueQueueButton;
    }

    public JComboBox<String> getSourceBox() {
        return sourceBox;
    }

    public JComboBox<String> getDestinationBox() {
        return destinationBox;
    }

    public JComboBox<String> getDisasterBox() {
        return disasterBox;
    }

    public JComboBox<String> getVehicleBox() {
        return vehicleBox;
    }
}