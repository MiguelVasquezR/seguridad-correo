package resenas.utils;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class Correo {

    public static String enviarAlertaSeguridad(String destinatario, String email, String password) {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mvrosas01@gmail.com", "xskq lfoq yhau wzya");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mvrosas01@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            MimeBodyPart htmlPart = new MimeBodyPart();

            String mensajeHTML = "<html>" +
                    "<head>" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" +
                    "</head>" +
                    "<body style='margin: 0; padding: 0; font-family: Arial, sans-serif; width: 100%;'>" +
                    "<table width='100%' bgcolor='#F58A27' style='color: #fff; text-align: center;'>" +
                    "<tr>" +
                    "<td>" +
                    "</td>" +
                    "<td>" +
                    "</td>" +
                    "</tr>" +
                    "</table>" +
                    "<div style='width: 100%; background-color: #fff; text-align: center;'>" +
                    "<h2>Alerta de seguridad: Has caido en una trampa</h2>" +
                    "<div style='background-color: #f2f2f2; width: 50%; padding: 10px; margin: 0 auto;'>" +
                    "<p>Hola, este correo es para informarte que a traves del engano, se han podido robar tus datos para ingresar a la plataforma de Eminus. "
                    +
                    "Debes tener mas cuidado con las paginas a las que entras y en quien confias.</p>" +
                    "</div>" +
                    "</div>" +
                    "<div style='width: 100%; background-color: #fff; margin-top: 40px; text-align: center;'>" +
                    "<h3>Tus credenciales son las siguientes:</h3>" +
                    "<p>Usuario: " + email + " <br/> Contrasena: " + password + "</p>" +
                    "<p>No te preocupes, tus contrasenas no se han almacenado en ningun lado, solo se han procesado para enviarte este correo. "
                    +
                    "Tus credenciales siguen siendo seguras, solo no olvides siempre tener cuidado con las paginas a las que ingresas.</p>"
                    +
                    "</div>" +
                    "<div style='width: 100%; background-color: #fff; margin-top: 40px; text-align: center;'>" +
                    "</div>" +
                    "</body>" +
                    "</html>";

            message.setSubject("Alerta de seguridad");
            htmlPart.setContent(mensajeHTML, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);

            message.setContent(multipart);

            Transport.send(message);
            return "Correo enviado correctamente.";
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            return "Hubo un error al enviar el correo.";
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            return "Hubo un error inesperado.";
        }
    }

}