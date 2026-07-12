package com.evacuationsimulator.gui;

import com.evacuationsimulator.model.Node;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CityMapPanel extends JPanel {

    private final Map<String, Point> nodePositions;
    private List<Node> highlightedRoute;

    public CityMapPanel() {

        setPreferredSize(new Dimension(700, 260));

        setBackground(Color.WHITE);

        nodePositions = new HashMap<>();

        highlightedRoute = new ArrayList<>();

        initializePositions();
    }

    private void initializePositions() {

        nodePositions.put("Hospital", new Point(80, 70));
        nodePositions.put("School", new Point(220, 70));
        nodePositions.put("Fire Station", new Point(80, 180));
        nodePositions.put("Police Station", new Point(220, 180));
        nodePositions.put("Shopping Mall", new Point(380, 70));
        nodePositions.put("Shelter", new Point(380, 180));
        nodePositions.put("Railway Station", new Point(560, 180));
        nodePositions.put("Airport", new Point(560, 70));
    }

    public void setHighlightedRoute(List<Node> route) {

        highlightedRoute = route;

        repaint();
    }

    public void clearRoute() {

        highlightedRoute.clear();

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawRoad(g2, "Hospital", "School");
        drawRoad(g2, "Hospital", "Fire Station");
        drawRoad(g2, "Fire Station", "Police Station");
        drawRoad(g2, "Police Station", "Shelter");
        drawRoad(g2, "School", "Shopping Mall");
        drawRoad(g2, "Shopping Mall", "Shelter");
        drawRoad(g2, "Shelter", "Railway Station");
        drawRoad(g2, "Railway Station", "Airport");

        drawHighlightedRoute(g2);

        drawNodes(g2);

    }

    private void drawRoad(Graphics2D g2,
                          String from,
                          String to) {

        Point p1 = nodePositions.get(from);
        Point p2 = nodePositions.get(to);

        g2.setColor(Color.GRAY);

        g2.setStroke(new BasicStroke(2));

        g2.drawLine(p1.x, p1.y, p2.x, p2.y);

    }

    private void drawHighlightedRoute(Graphics2D g2) {

        if (highlightedRoute == null ||
                highlightedRoute.size() < 2) {

            return;

        }

        g2.setColor(new Color(34, 177, 76));

        g2.setStroke(new BasicStroke(5));

        for (int i = 0; i < highlightedRoute.size() - 1; i++) {

            Point p1 = nodePositions.get(
                    highlightedRoute.get(i).getLocationName());

            Point p2 = nodePositions.get(
                    highlightedRoute.get(i + 1).getLocationName());

            if (p1 != null && p2 != null) {

                g2.drawLine(
                        p1.x,
                        p1.y,
                        p2.x,
                        p2.y);

            }

        }

    }

    private void drawNodes(Graphics2D g2) {

        for (Map.Entry<String, Point> entry : nodePositions.entrySet()) {

            String name = entry.getKey();

            Point p = entry.getValue();

            g2.setColor(getNodeColor(name));

            g2.fillOval(
                    p.x - 8,
                    p.y - 8,
                    16,
                    16);

            g2.setColor(Color.BLACK);

            g2.drawString(
                    name,
                    p.x - 30,
                    p.y - 15);

        }

    }

    private Color getNodeColor(String name) {

        switch (name) {

            case "Hospital":
                return Color.RED;

            case "Fire Station":
                return Color.ORANGE;

            case "Police Station":
                return Color.BLUE;

            case "Shelter":
                return new Color(0, 160, 0);

            case "Airport":
                return new Color(120, 0, 200);

            case "School":
                return Color.YELLOW;

            case "Shopping Mall":
                return Color.DARK_GRAY;

            case "Railway Station":
                return new Color(120, 70, 30);

            default:
                return Color.GRAY;

        }

    }

}