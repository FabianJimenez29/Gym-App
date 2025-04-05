package com.gym.app.gymapp.features;


import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import io.github.cdimascio.dotenv.Dotenv;

public class MailService {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String RESEND_API_KEY = dotenv.get("RESEND_API_KEY");
    private static final String FROM_EMAIL = "Notificaciones <notificaciones@gymcabita.lat>";

    public static void sendEmail(String toEmail, String subject, String htmlBody) {
        if (RESEND_API_KEY == null || RESEND_API_KEY.isEmpty()) {
            System.out.println("❌ Error: No se encontró la API Key de Resend.");
            return;
        }

        try {
            Resend resend = new Resend(RESEND_API_KEY);

            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from(FROM_EMAIL)
                    .to(toEmail)
                    .subject(subject)
                    .html(htmlBody)
                    .build();

            CreateEmailResponse data = resend.emails().send(params);
            System.out.println("✅ Correo enviado. ID del mensaje: " + data.getId());

        } catch (ResendException e) {
            System.out.println("❌ Error al enviar correo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
