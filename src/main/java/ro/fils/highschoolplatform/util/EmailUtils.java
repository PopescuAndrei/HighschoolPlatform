/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.util;

import java.util.ArrayList;
import java.util.Properties;
import ro.fils.highschoolplatform.domain.Student;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import ro.fils.highschoolplatform.domain.Homework;

/**
 *
 * @author andre
 */
public class EmailUtils {

    public void sendEmails(Homework hw, ArrayList<Student> students) {
        System.out.println("se apeleza");
        String from = "web@gmail.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.port", "25");
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            for (Student s : students) {
                System.out.println("baga mesaj catre" + s.getEmail());
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(s.getEmail()));
            }
            message.setSubject("Homework");

            // Send the actual HTML message, as big as you like
            message.setContent("<h1>This is a test mail.</h1>"
                    + "<p> It's a program I am developing and I just try to play with the mail API.<p>"
                    + "<p> If you're receiving this, please ignore it!</p>"
                    + "<p> You're homework is: </p>"
                    + "<p>" + hw.getDescription() + "</p>"
                    + "<p> Due Date: " + hw.getDueDate() + "</p>", "text/html");

            // Send message
            Transport.send(message);
            System.out.println(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
