/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.Properties;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class GitHubUpdateChecker {

    // https://api.github.com/repos/fabianjimenez29/gym-app/releases/latest
    private static final String GITHUB_USER = "FabianJimenez29";
    private static final String GITHUB_REPO = "Gym-App";
    private static final String RELEASES_API_URL
            = "https://api.github.com/repos/" + GITHUB_USER + "/" + GITHUB_REPO + "/releases/latest";

    private static final String CURRENT_VERSION_FILE = "version.properties";
    private static final String JAR_NAME = "GymApp-1.0-SNAPSHOT-jar-with-dependencies.jar"; // Nombre de tu JAR en releases

    private String currentVersion;
    private GitHubRelease latestRelease;
    private Gson gson;

    public GitHubUpdateChecker() {
        gson = new Gson();
        loadCurrentVersion();
    }

    // Clase para mapear la respuesta de GitHub API
    private static class GitHubRelease {

        String tag_name;      // versión (ej: "v1.2.0")
        String name;          // título del release
        String body;          // descripción/changelog
        boolean draft;
        boolean prerelease;
        String published_at;
        GitHubAsset[] assets; // archivos adjuntos

        static class GitHubAsset {

            String name;
            String browser_download_url;
            int size;
            int download_count;
        }
    }

    private void loadCurrentVersion() {
        try {
            Properties props = new Properties();
            File versionFile = new File(CURRENT_VERSION_FILE);

            if (versionFile.exists()) {
                System.out.println("Archivo version.properties encontrado: " + versionFile.getAbsolutePath());
                props.load(new FileInputStream(versionFile));
                currentVersion = props.getProperty("version", "v1.0.0");
                System.out.println("Versión cargada desde archivo: " + currentVersion);
            } else {
                System.out.println("Archivo version.properties no existe. Creando en: " + versionFile.getAbsolutePath());
                currentVersion = "v1.0.0";
                saveCurrentVersion(); // Llamar aquí para crear el archivo
                System.out.println("Archivo version.properties creado con versión: " + currentVersion);
            }
        } catch (IOException e) {
            System.err.println("Error cargando versión: " + e.getMessage());
            currentVersion = "v1.0.0";
            // Intentar crear el archivo incluso si hay error
            try {
                saveCurrentVersion();
            } catch (Exception ex) {
                System.err.println("Error creando archivo de versión: " + ex.getMessage());
            }
        }
    }

    private void saveCurrentVersion() {
        try {
            Properties props = new Properties();
            props.setProperty("version", currentVersion);
            props.setProperty("last_check", String.valueOf(System.currentTimeMillis()));

            File versionFile = new File(CURRENT_VERSION_FILE);

            // Crear el directorio padre si no existe
            File parentDir = versionFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Guardar el archivo
            try (FileOutputStream fos = new FileOutputStream(versionFile)) {
                props.store(fos, "Información de versión de la aplicación");
            }

            System.out.println("Archivo version.properties guardado en: " + versionFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error guardando versión: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método principal para verificar actualizaciones y mostrar el diálogo
     * Este es el método que debes llamar desde tu aplicación
     */
    public void checkAndShowUpdateIfAvailable() {
        if (checkForUpdates()) {
            showUpdateDialog();
        } else {
            System.out.println("No hay actualizaciones disponibles o ya tienes la última versión.");
        }
    }

    /**
     * Método para verificar actualizaciones de forma silenciosa
     * Devuelve true si hay una actualización disponible
     */
    public boolean checkForUpdates() {
        try {
            System.out.println("Verificando actualizaciones desde GitHub...");

            URL url = new URL(RELEASES_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/vnd.github.v3+json");
            conn.setRequestProperty("User-Agent", "MiApp-UpdateChecker");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.err.println("Error en GitHub API: " + responseCode);
                return false;
            }

            // Leer respuesta JSON
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parsear JSON
            latestRelease = gson.fromJson(response.toString(), GitHubRelease.class);

            if (latestRelease == null || latestRelease.draft || latestRelease.prerelease) {
                System.out.println("No hay releases estables disponibles");
                return false;
            }

            System.out.println("Versión actual: " + currentVersion);
            System.out.println("Última versión: " + latestRelease.tag_name);

            // FIX: Corregir el orden de los parámetros
            boolean hasUpdate = isNewerVersion(latestRelease.tag_name, currentVersion);
            
            if (hasUpdate) {
                System.out.println("¡Nueva versión disponible!");
            } else {
                System.out.println("Ya tienes la última versión.");
            }
            
            return hasUpdate;

        } catch (Exception e) {
            System.err.println("Error verificando actualizaciones: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Compara si latestVersion es más nueva que currentVersion
     * @param latestVersion La versión más reciente (ej: "v1.2.0")
     * @param currentVersion La versión actual (ej: "v1.1.0")
     * @return true si latestVersion es más nueva
     */
    public boolean isNewerVersion(String latestVersion, String currentVersion) {
        try {
            // Remover prefijo "v" si existe (case insensitive)
            String cleanLatest = latestVersion.replaceAll("(?i)^v", "");
            String cleanCurrent = currentVersion.replaceAll("(?i)^v", "");

            System.out.println("Comparando versiones:");
            System.out.println("  Actual (limpia): " + cleanCurrent);
            System.out.println("  Última (limpia): " + cleanLatest);

            String[] latestParts = cleanLatest.split("\\.");
            String[] currentParts = cleanCurrent.split("\\.");

            int length = Math.max(currentParts.length, latestParts.length);
            
            for (int i = 0; i < length; i++) {
                int currentPart = i < currentParts.length ? Integer.parseInt(currentParts[i]) : 0;
                int latestPart = i < latestParts.length ? Integer.parseInt(latestParts[i]) : 0;
                
                System.out.println("  Comparando parte " + i + ": " + currentPart + " vs " + latestPart);
                
                if (latestPart > currentPart) {
                    System.out.println("  -> Versión más nueva encontrada");
                    return true;
                } else if (latestPart < currentPart) {
                    System.out.println("  -> Versión actual es más nueva");
                    return false;
                }
            }
            
            System.out.println("  -> Versiones iguales");
            return false; // versiones iguales
            
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear números de versión: " + e.getMessage());
            return false;
        }
    }

    public void showUpdateDialog() {
        if (latestRelease == null) {
            System.err.println("No hay información de release para mostrar");
            return;
        }

        // Crear mensaje con información de la actualización
        StringBuilder message = new StringBuilder();
        message.append("🚀 Nueva actualización disponible!\n\n");
        message.append("Versión actual: ").append(currentVersion).append("\n");
        message.append("Nueva versión: ").append(latestRelease.tag_name).append("\n\n");

        if (latestRelease.name != null && !latestRelease.name.isEmpty()) {
            message.append("Título: ").append(latestRelease.name).append("\n\n");
        }

        if (latestRelease.body != null && !latestRelease.body.isEmpty()) {
            message.append("Novedades:\n");
            // Limitar el changelog a 300 caracteres para que no sea muy largo
            String changelog = latestRelease.body.length() > 300
                    ? latestRelease.body.substring(0, 300) + "..." : latestRelease.body;
            message.append(changelog).append("\n\n");
        }

        message.append("¿Desea descargar e instalar la actualización ahora?");

        int option = JOptionPane.showConfirmDialog(
                null,
                message.toString(),
                "Actualización Disponible - " + latestRelease.tag_name,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (option == JOptionPane.YES_OPTION) {
            downloadAndInstallUpdate();
        }else{
            System.exit(0);
        }
    }

    public void downloadAndInstallUpdate() {
        try {
            // Buscar el archivo JAR en los assets
            GitHubRelease.GitHubAsset jarAsset = findJarAsset();
            if (jarAsset == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "No se encontró el archivo de la aplicación en la nueva versión.",
                        "Error de Actualización",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            System.out.println("Descargando: " + jarAsset.name);
            System.out.println("Tamaño: " + (jarAsset.size / 1024 / 1024) + " MB");

            // Crear diálogo con barra de progreso
            showDownloadProgressDialog(jarAsset);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error durante la actualización: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void showDownloadProgressDialog(GitHubRelease.GitHubAsset jarAsset) {
        javax.swing.JDialog progressDialog = new javax.swing.JDialog((java.awt.Frame) null, "Descargando Actualización", true);
        javax.swing.JProgressBar progressBar = new javax.swing.JProgressBar(0, 100);
        javax.swing.JLabel statusLabel = new javax.swing.JLabel("Iniciando descarga...");
        javax.swing.JLabel speedLabel = new javax.swing.JLabel(" ");

        // Configurar barra de progreso
        progressBar.setStringPainted(true);
        progressBar.setString("0%");

        // Layout del diálogo
        progressDialog.setLayout(new java.awt.BorderLayout());
        javax.swing.JPanel mainPanel = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior con información
        javax.swing.JPanel infoPanel = new javax.swing.JPanel(new java.awt.GridLayout(3, 1, 5, 5));
        infoPanel.add(new javax.swing.JLabel("Descargando: " + jarAsset.name));
        infoPanel.add(new javax.swing.JLabel("Tamaño: " + String.format("%.2f MB", jarAsset.size / 1024.0 / 1024.0)));
        infoPanel.add(statusLabel);

        // Panel central con barra de progreso
        javax.swing.JPanel progressPanel = new javax.swing.JPanel(new java.awt.BorderLayout(0, 5));
        progressPanel.add(progressBar, java.awt.BorderLayout.CENTER);
        progressPanel.add(speedLabel, java.awt.BorderLayout.SOUTH);

        mainPanel.add(infoPanel, java.awt.BorderLayout.NORTH);
        mainPanel.add(progressPanel, java.awt.BorderLayout.CENTER);

        progressDialog.add(mainPanel);
        progressDialog.setSize(400, 180);
        progressDialog.setLocationRelativeTo(null);
        progressDialog.setDefaultCloseOperation(javax.swing.JDialog.DO_NOTHING_ON_CLOSE);

        // Descargar en hilo separado
        new Thread(() -> {
            try {
                downloadFileWithProgress(jarAsset.browser_download_url, "app-update.jar", 
                    progressBar, statusLabel, speedLabel);

                javax.swing.SwingUtilities.invokeLater(() -> {
                    progressDialog.dispose();
                    installUpdateAndRestart();
                });

            } catch (Exception e) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    progressDialog.dispose();
                    JOptionPane.showMessageDialog(
                            null,
                            "Error descargando la actualización: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                });
            }
        }).start();

        progressDialog.setVisible(true);
    }

    private GitHubRelease.GitHubAsset findJarAsset() {
        if (latestRelease.assets == null) {
            return null;
        }

        for (GitHubRelease.GitHubAsset asset : latestRelease.assets) {
            if (asset.name.equals(JAR_NAME)
                    || asset.name.toLowerCase().endsWith(".jar")) {
                return asset;
            }
        }

        return null;
    }

    private void downloadFileWithProgress(String fileURL, String saveDir, javax.swing.JProgressBar progressBar, 
                                        javax.swing.JLabel statusLabel, javax.swing.JLabel speedLabel) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "MiApp-UpdateChecker");

        int fileSize = conn.getContentLength();
        long startTime = System.currentTimeMillis();

        try (InputStream in = conn.getInputStream(); FileOutputStream out = new FileOutputStream(saveDir)) {

            byte[] buffer = new byte[8192];
            int bytesRead;
            int totalBytesRead = 0;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;

                if (fileSize > 0) {
                    final int progress = (int) ((totalBytesRead * 100.0) / fileSize);
                    final int finalTotalBytesRead = totalBytesRead;
                    
                    // Calcular velocidad de descarga
                    long currentTime = System.currentTimeMillis();
                    long timeElapsed = currentTime - startTime;
                    
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        progressBar.setValue(progress);
                        progressBar.setString(progress + "%");
                        
                        // Actualizar estado
                        String downloaded = String.format("%.1f MB", finalTotalBytesRead / 1024.0 / 1024.0);
                        String total = String.format("%.1f MB", fileSize / 1024.0 / 1024.0);
                        statusLabel.setText("Descargando... " + downloaded + " / " + total);
                        
                        // Calcular y mostrar velocidad
                        if (timeElapsed > 1000) { // Solo después de 1 segundo
                            double speed = (finalTotalBytesRead / 1024.0 / 1024.0) / (timeElapsed / 1000.0);
                            speedLabel.setText(String.format("Velocidad: %.1f MB/s", speed));
                        }
                    });
                }
                
                // Pequeña pausa para que la UI se actualice suavemente
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Descarga interrumpida");
        }

        // Actualizar a completado
        javax.swing.SwingUtilities.invokeLater(() -> {
            progressBar.setValue(100);
            progressBar.setString("100%");
            statusLabel.setText("Descarga completada - Instalando...");
            speedLabel.setText("Preparando instalación...");
        });

        System.out.println("Descarga completada: " + saveDir);
    }

    private void installUpdateAndRestart() {
        try {
            String currentJar = getCurrentJarPath();

            // Crear script de actualización según el OS
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                createAndRunWindowsScript(currentJar);
            } else {
                createAndRunUnixScript(currentJar);
            }

            // Actualizar versión local
            currentVersion = latestRelease.tag_name;
            saveCurrentVersion();

            JOptionPane.showMessageDialog(
                    null,
                    "Actualización instalada correctamente.\nLa aplicación se reiniciará ahora.",
                    "Actualización Completada",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Cerrar la aplicación actual
            System.exit(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error instalando la actualización: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private String getCurrentJarPath() {
        try {
            return new File(GitHubUpdateChecker.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI()).getPath();
        } catch (Exception e) {
            return "app.jar";
        }
    }

    private void createAndRunWindowsScript(String currentJar) throws IOException {
        String script = "@echo off\n"
                + "echo Instalando actualización...\n"
                + "timeout /t 3 /nobreak > nul\n"
                + "copy /Y \"app-update.jar\" \"" + currentJar + "\"\n"
                + "del \"app-update.jar\"\n"
                + "echo Reiniciando aplicación...\n"
                + "start \"\" \"" + currentJar + "\"\n"
                + "del \"%~f0\"\n";

        Files.write(Paths.get("update.bat"), script.getBytes());
        Runtime.getRuntime().exec("cmd /c start update.bat");
    }

    private void createAndRunUnixScript(String currentJar) throws IOException {
        String script = "#!/bin/bash\n"
                + "echo 'Instalando actualización...'\n"
                + "sleep 3\n"
                + "cp app-update.jar \"" + currentJar + "\"\n"
                + "rm app-update.jar\n"
                + "echo 'Reiniciando aplicación...'\n"
                + "java -jar \"" + currentJar + "\" &\n"
                + "rm -- \"$0\"\n";

        Files.write(Paths.get("update.sh"), script.getBytes());
        Runtime.getRuntime().exec("chmod +x update.sh");
        Runtime.getRuntime().exec("./update.sh");
    }

    // Métodos públicos para información
    public String getCurrentVersion() {
        return currentVersion;
    }

    public String getLatestVersion() {
        return latestRelease != null ? latestRelease.tag_name : "Desconocida";
    }

    public String getLatestReleaseInfo() {
        if (latestRelease == null) {
            return "No hay información disponible";
        }

        StringBuilder info = new StringBuilder();
        info.append("Versión: ").append(latestRelease.tag_name).append("\n");
        info.append("Nombre: ").append(latestRelease.name).append("\n");
        info.append("Publicado: ").append(latestRelease.published_at).append("\n");
        if (latestRelease.body != null) {
            info.append("Descripción:\n").append(latestRelease.body);
        }

        return info.toString();
    }

    /**
     * Método de prueba para forzar mostrar el diálogo de actualización
     * Útil para testing
     */
    public void forceShowUpdateDialog() {
        if (checkForUpdates()) {
            showUpdateDialog();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo obtener información de actualizaciones o ya tienes la última versión.\n\n" +
                    "Versión actual: " + currentVersion,
                    "Verificación de Actualizaciones",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}