package com.gridapp.emailservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EmailService
{
    private final Session mailsession;

    public EmailService()
    {
        try
        {
            InitialContext ic = new InitialContext();
            mailsession = (Session) ic.lookup("java:jboss/mail/Default");
        } catch (NamingException e)
        {
            throw new RuntimeException("Failed to lookup mail session");
        }
    }

    public void sendEmail(String from, String to, String subject, String body) throws MessagingException
    {
        MimeMessage message = new MimeMessage(mailsession);
        message.setFrom(from);
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
        System.out.println("Email sent successfully!");
    }
}
