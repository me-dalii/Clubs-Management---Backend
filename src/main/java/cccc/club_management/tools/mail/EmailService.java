package cccc.club_management.tools.mail;

import java.io.ByteArrayOutputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {

    String sender;
    String host;
    Properties properties;
    Session session;
    ByteArrayOutputStream outputStream;

    public EmailService(){
        // Sender's email ID needs to be mentioned
        sender = "bizerteMunicipality@gmail.com";
        // Assuming you are sending email from through gmails smtp
        host = "smtp.gmail.com";
        // Get system properties
        properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bizerteMunicipality@gmail.com", "bulehovntrugoxjk");
            }
        });
        outputStream  = null;
    }

    public void sendEmail(String receipentEmail, String subject, String body){
        try {

            session.setDebug(true);
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(body);

            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(sender);
            InternetAddress iaRecipient = new InternetAddress(receipentEmail);

            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);

            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);
            //send off the email
            Transport.send(mimeMessage);

        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
