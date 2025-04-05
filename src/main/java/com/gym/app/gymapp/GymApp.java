package com.gym.app.gymapp;

import com.gym.app.gymapp.features.MailService;

/**
 *
 * @author fabi
 */
public class GymApp {

    public static void main(String[] args) {
        MailService.sendEmail(
                "gymcabita2025@outlook.com",
                "¡Funciona desde GymApp!",
                "<p><strong>Este es un correo de prueba con Resend</strong></p>"
        );
    }

}
