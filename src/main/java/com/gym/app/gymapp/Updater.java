package com.gym.app.gymapp;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Updater {

    private static final String VERSION_URL = "https://raw.githubusercontent.com/FabianJimenez29/Gym-App/master/version.txt";
    private static final String DOWNLOAD_URL = "https://github.com/FabianJimenez29/Gym-App/releases/download/V1.2/GymApp-V1.2.jar";
    private static final String NEW_JAR_NAME = "GymApp-V1.1.jar";
    private static final String VERSION_LOCAL = "V1.1"; // 

    public static boolean checkAndUpdate() {
        try {
            String versionRemota = readRemoteVersion(VERSION_URL);
            if (!VERSION_LOCAL.equals(versionRemota)) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "Hay una nueva versión disponible (" + versionRemota + "). ¿Deseas actualizar?",
                        "Actualización disponible", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    downloadFileWithProgress(DOWNLOAD_URL, NEW_JAR_NAME);
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
        String oldJar = new File(Updater.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getName();

        String script = """
            #!/bin/bash
            sleep 2
            rm "%s"
            mv "%s" "%s"
            nohup java -jar "%s" &
            """.formatted(oldJar, NEW_JAR_NAME, oldJar, oldJar);

        File scriptFile = new File("update.sh");
        try (FileWriter writer = new FileWriter(scriptFile)) {
            writer.write(script);
        }

        // Hacer ejecutable el script
        scriptFile.setExecutable(true);

        // Ejecutar el script
        new ProcessBuilder("/bin/bash", "update.sh").start();
    }
}
