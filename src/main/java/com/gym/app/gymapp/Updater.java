package com.gym.app.gymapp;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Updater {

    private static final String VERSION_URL = "https://raw.githubusercontent.com/FabianJimenez29/Gym-App/master/version.txt";
    private static final String DOWNLOAD_URL = "https://github.com/FabianJimenez29/Gym-App/releases/download/V1.0/GymApp-1.0-SNAPSHOT-jar-with-dependencies.jar";
    private static final String NEW_JAR_TEMP_NAME = "GymApp-temp.jar";
    private static final String FINAL_JAR_NAME = "GymApp-1.0-SNAPSHOT-jar-with-dependencies.jar";
    private static final String VERSION_LOCAL = "V1.0";

    public static boolean checkAndUpdate() {
        try {
            String versionRemota = readRemoteVersion(VERSION_URL);
            if (!VERSION_LOCAL.equals(versionRemota)) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "Hay una nueva versión disponible (" + versionRemota + "). ¿Deseas actualizar?",
                        "Actualización disponible", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    downloadFileWithProgress(DOWNLOAD_URL, NEW_JAR_TEMP_NAME);
                    launchUpdaterScript();
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al buscar actualización: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private static String readRemoteVersion(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return in.readLine().trim();
        }
    }

    private static void downloadFileWithProgress(String fileURL, String savePath) throws IOException {
        HttpURLConnection httpConn = (HttpURLConnection) new URL(fileURL).openConnection();
        int responseCode = httpConn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            int fileSize = httpConn.getContentLength();
            JProgressBar progressBar = new JProgressBar(0, fileSize);
            progressBar.setStringPainted(true);
            JOptionPane pane = new JOptionPane(progressBar, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            JDialog dialog = pane.createDialog("Descargando actualización...");
            dialog.setModal(false);
            dialog.setVisible(true);

            try (InputStream inputStream = httpConn.getInputStream(); FileOutputStream outputStream = new FileOutputStream(savePath)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                int totalRead = 0;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    totalRead += bytesRead;
                    outputStream.write(buffer, 0, bytesRead);
                    progressBar.setValue(totalRead);
                }
            }

            dialog.dispose();
        } else {
            throw new IOException("No se pudo descargar el archivo. Código HTTP: " + responseCode);
        }
        httpConn.disconnect();
    }

    private static void launchUpdaterScript() throws IOException {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            String script = """
                    @echo off
                    timeout /t 2 >nul
                    del "%s"
                    ren "%s" "%s"
                    start javaw -jar "%s"
                    """.formatted(FINAL_JAR_NAME, NEW_JAR_TEMP_NAME, FINAL_JAR_NAME, FINAL_JAR_NAME);

            File scriptFile = new File("update.bat");
            try (FileWriter writer = new FileWriter(scriptFile)) {
                writer.write(script);
            }

            Runtime.getRuntime().exec("cmd /c start update.bat");
        } else {
            String script = """
                    #!/bin/bash
                    sleep 2
                    rm "%s"
                    mv "%s" "%s"
                    nohup java -jar "%s" &
                    """.formatted(FINAL_JAR_NAME, NEW_JAR_TEMP_NAME, FINAL_JAR_NAME, FINAL_JAR_NAME);

            File scriptFile = new File("update.sh");
            try (FileWriter writer = new FileWriter(scriptFile)) {
                writer.write(script);
            }

            scriptFile.setExecutable(true);
            new ProcessBuilder("/bin/bash", "update.sh").start();
        }
    }
}
