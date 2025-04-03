package com.gym.app.gymapp.features;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import io.github.cdimascio.dotenv.Dotenv; // Asegúrate de importar dotenv

import java.io.IOException;

public class MailService {

    private static final Dotenv dotenv = Dotenv.load(); // Cargar variables de .env
    private static final String SENDGRID_API_KEY = dotenv.get("SENDGRID_API_KEY"); // Obtener clave
    private static final String FROM_EMAIL = "gymcabita2025@outlook.com";

    public static void sendEmail(String toEmail, String subject, String body) {
        if (SENDGRID_API_KEY == null || SENDGRID_API_KEY.isEmpty()) {
            System.out.println("❌ Error: No se encontró la API Key de SendGrid.");
            return;
        }

        Email from = new Email(FROM_EMAIL);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Código de respuesta: " + response.getStatusCode());
            System.out.println("Cuerpo de respuesta: " + response.getBody());
        } catch (IOException ex) {
            System.out.println("Error al enviar el correo: " + ex.getMessage());
        }
    }
}
