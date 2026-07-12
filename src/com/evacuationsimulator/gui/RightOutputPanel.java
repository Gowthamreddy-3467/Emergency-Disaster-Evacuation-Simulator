package com.evacuationsimulator.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RightOutputPanel extends JPanel {

    private JTextArea outputArea;
    private CityMapPanel cityMapPanel;

    public RightOutputPanel() {

        setLayout(new BorderLayout());

        setBorder(new EmptyBorder(10,10,10,10));

        // ==========================
        // CITY MAP
        // ==========================

        JPanel mapPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("CITY MAP", SwingConstants.CENTER);

        title.setFont(new Font("Segoe UI", Font.BOLD, 18));

        title.setForeground(AppColors.TITLE);

        mapPanel.add(title, BorderLayout.NORTH);

        cityMapPanel = new CityMapPanel();

        mapPanel.add(cityMapPanel, BorderLayout.CENTER);

        // ==========================
        // OUTPUT AREA
        // ==========================

        outputArea = new JTextArea();

        outputArea.setEditable(false);

        outputArea.setFont(new Font("Consolas", Font.PLAIN, 18));

        outputArea.setBackground(new Color(250,250,250));

        outputArea.setForeground(Color.BLACK);

        outputArea.setMargin(new Insets(10,10,10,10));

        outputArea.setLineWrap(true);

        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        // ==========================
        // SPLIT PANE
        // ==========================

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                mapPanel,
                scrollPane
        );

        splitPane.setDividerLocation(250);

        splitPane.setResizeWeight(0.35);

        splitPane.setOneTouchExpandable(true);

        add(splitPane, BorderLayout.CENTER);

        outputArea.setText("""
Welcome to EvacuAid

System Status : READY

Select source and destination.

Click Find Route to begin.
""");

    }

    public void setOutput(String text){

        outputArea.setText(text);

        outputArea.setCaretPosition(0);

    }

    public CityMapPanel getCityMapPanel(){

        return cityMapPanel;

    }
    public void highlightRoute(java.util.List<com.evacuationsimulator.model.Node> route) {

        cityMapPanel.setHighlightedRoute(route);

    }

}