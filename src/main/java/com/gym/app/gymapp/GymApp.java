package com.gym.app.gymapp;

import com.gym.app.gymapp.frames.LoginFrameV1;

import java.io.File;
import java.io.IOException;

public class GymApp {

    private static final String LOCAL_JAR_PATH = "GymApp-1.0-SNAPSHOT.jar";

    public static void main(String[] args) {

        boolean updated = Updater.checkAndUpdate();

        if (updated) {
            System.out.println("Reiniciando aplicación con la versión actualizada...");

            try {
                // Construir el comando para reiniciar el .jar actualizado
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", LOCAL_JAR_PATH);
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Salir de la aplicación actual
            System.exit(0);
        } else {
            // No hubo actualización, se inicia normalmente la app
            javax.swing.SwingUtilities.invokeLater(() -> {
                new LoginFrameV1();
            });
        }
    }
}