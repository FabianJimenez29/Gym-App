/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gym.app.gymapp;

import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author fabi
 */
public class MA {
    
    private GitHubUpdateChecker updateChecker;
    private javax.swing.Timer updateTimer;
    
    public MA() {
        updateChecker = new GitHubUpdateChecker();
        setupAutoUpdateCheck();
        
        // Verificar actualizaciones al iniciar (opcional)
        checkForUpdatesOnStartup();
    }
    
    private void setupAutoUpdateCheck() {
        // Verificar actualizaciones cada hora
        int checkInterval = 60 * 60 * 1000; // 1 hora en milisegundos
        
        updateTimer = new javax.swing.Timer(checkInterval, e -> {
            checkForUpdatesInBackground();
        });
        updateTimer.start();
    }
    
    private void checkForUpdatesOnStartup() {
        new Thread(() -> {
            try {
                Thread.sleep(5000); 
                if (updateChecker.checkForUpdates()) {
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        showUpdateNotification();
                    });
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    
    private void checkForUpdatesInBackground() {
        new Thread(() -> {
            if (updateChecker.checkForUpdates()) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    updateChecker.showUpdateDialog();
                });
            }
        }).start();
    }
    
    private void showUpdateNotification() {
        int option = JOptionPane.showConfirmDialog(
            null,
            "Hay una nueva versión disponible (" + updateChecker.getLatestVersion() + ").\n" +
            "¿Desea ver los detalles de la actualización?",
            "Nueva versión disponible",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE
        );
        if (option == JOptionPane.YES_OPTION) {
            updateChecker.showUpdateDialog();
        }else{
            System.exit(0);
        }
    }
    
    public void checkForUpdatesManually() {
        new Thread(() -> {
            boolean hasUpdates = updateChecker.checkForUpdates();
            javax.swing.SwingUtilities.invokeLater(() -> {
                if (hasUpdates) {
                    updateChecker.showUpdateDialog();
                } else {
                    JOptionPane.showMessageDialog(
                        null,
                        "Ya tienes la versión más reciente (" + 
                        updateChecker.getCurrentVersion() + ")",
                        "Sin actualizaciones",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });
        }).start();
    }
    
    public void showAboutDialog() {
        String info = "Mi Aplicación\n\n" +
                     "Versión actual: " + updateChecker.getCurrentVersion() + "\n" +
                     "Última verificación: " + getLastCheckTime() + "\n\n" +
                     "Para buscar actualizaciones manualmente,\n" +
                     "usa el menú Ayuda > Buscar actualizaciones";
        JOptionPane.showMessageDialog(
            null,
            info,
            "Acerca de",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private String getLastCheckTime() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("version.properties"));
            long lastCheck = Long.parseLong(props.getProperty("last_check", "0"));
            if (lastCheck > 0) {
                return new java.util.Date(lastCheck).toString();
            }
        } catch (Exception e) {
            // Ignorar errores
        }
        return "Nunca";
    }

}
