package com.gym.app.gymapp;

import com.gym.app.gymapp.frames.LoginFrameV1;

import java.io.IOException;

public class GymApp {
    public static void main(String[] args) {
        boolean updated = Updater.checkAndUpdate();

        if (updated) {
            System.exit(0); 
        } else {
            javax.swing.SwingUtilities.invokeLater(() -> new LoginFrameV1());
        }
    }
}