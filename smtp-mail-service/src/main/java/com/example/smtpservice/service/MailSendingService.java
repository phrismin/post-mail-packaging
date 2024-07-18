package com.example.smtpservice.service;

public interface MailSendingService {
    void send(String to, String subject, String text) throws Exception;
}