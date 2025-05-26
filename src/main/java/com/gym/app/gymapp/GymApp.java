package com.gym.app.gymapp;

import com.gym.app.gymapp.frames.LoginFrameV1;

import java.io.IOException;

public class GymApp {

    private static final String LOCAL_JAR_PATH = "GymApp-1.0-SNAPSHOT-jar-with-dependencies.jar";

    public static void main(String[] args) {
        boolean updated = Updater.checkAndUpdate();

        if (updated) {
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", LOCAL_JAR_PATH);
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        } else {
            javax.swing.SwingUtilities.invokeLater(() -> new LoginFrameV1());
        }
    }
}