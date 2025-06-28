package org.attestation_final.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attestation_final.services.IEmailServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements IEmailServices {

    @Value("${spring.mail.username}")
    private String email;
    private final JavaMailSender mailSender;

    @Override
    public void send(String to, String subject, String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailMessage.setFrom(email);
        mailSender.send(mailMessage);
    }
}
