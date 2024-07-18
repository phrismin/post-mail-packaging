package com.example.smtpservice.service.impl;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import com.example.smtpservice.service.MailSendingService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailSendingServiceImpl implements MailSendingService {
    private final Session session;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Override
    public void send(String to, String subject, String messageBody) throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setContent(messageBody, "text/html");

        try (Transport transport = session.getTransport()) {
            log.info("Sending email to {}", to);

            transport.connect(host, username, password);
            transport.sendMessage(msg, msg.getAllRecipients());

            log.info("Successfully sent email to {}", to);
            //TODO добавить в очередь статус ок
//            publisher.send("success");
        } catch (Exception ex) {
            log.error("Email to {} was not sent", to);
            log.error("Error message: {}", ex.getMessage());
            //TODO добавить в очередь статус не доставлено
//            publisher.send("notSuccess");
        }
    }
}
