package com.gym.app.gymapp;

import com.gym.app.gymapp.features.MailService;
import com.gym.app.gymapp.frames.LoginFrameV1;

/**
 *
 * @author fabi
 */
public class GymApp {

    public static void main(String[] args) {
        // Abrir primero el LoginFrameV1
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginFrameV1();  // Inicia el LoginFrameV1
        });
    }

}
