package com.evacuationsimulator.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusPanel extends JPanel {

    private JLabel systemStatusLabel;
    private JLabel roadsLabel;
    private JLabel requestsLabel;
    private JLabel trafficLabel;

    public StatusPanel() {

        setLayout(new FlowLayout(FlowLayout.LEFT,25,8));

        setBackground(AppColors.STATUS);

        setBorder(new EmptyBorder(5,10,5,10));

        systemStatusLabel = createLabel("🟢 System : READY");

        roadsLabel = createLabel("🚧 Roads : 12");

        requestsLabel = createLabel("🚑 Pending Requests : 4");

        trafficLabel = createLabel("🚦 Traffic : MEDIUM");

        add(systemStatusLabel);

        add(roadsLabel);

        add(requestsLabel);

        add(trafficLabel);

    }

    private JLabel createLabel(String text){

        JLabel label = new JLabel(text);

        label.setFont(new Font("Segoe UI",Font.BOLD,14));

        label.setForeground(new Color(33,33,33));

        return label;

    }

    public void setSystemStatus(String status){

        systemStatusLabel.setText("🟢 System : " + status);

    }

    public void setRoadCount(int roads){

        roadsLabel.setText("🚧 Roads : " + roads);

    }

    public void setPendingRequests(int requests){

        requestsLabel.setText("🚑 Pending Requests : " + requests);

    }

    public void setTrafficLevel(String level){

        trafficLabel.setText("🚦 Traffic : " + level);

    }

}