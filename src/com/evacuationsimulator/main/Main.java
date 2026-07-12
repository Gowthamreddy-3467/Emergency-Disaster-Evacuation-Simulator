package com.evacuationsimulator.main;

import com.evacuationsimulator.gui.MainFrame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new MainFrame();

        });

    }

}