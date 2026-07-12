package com.evacuationsimulator.gui;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {

        setLayout(new BorderLayout());

        JLabel heading = new JLabel(
                "Emergency Operations Dashboard",
                SwingConstants.CENTER);

        heading.setFont(new Font("Arial", Font.BOLD, 22));

        add(heading, BorderLayout.NORTH);

        JTextArea infoArea = new JTextArea();

        infoArea.setEditable(false);

        infoArea.setText("""
Welcome to EvacuAid

Available Modules

• Graph
• Dijkstra
• BFS
• DFS
• Rescue Queue
• Disaster Simulation
• Traffic System

System Ready...
""");

        add(new JScrollPane(infoArea), BorderLayout.CENTER);

    }

}