package ru.innopolis.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class MyMailSender implements MailSender {
    @Override
    public void send(SimpleMailMessage simpleMessage) throws MailException {
        MailSender.super.send(simpleMessage);
    }

    @Override
    public void send(SimpleMailMessage... simpleMessages) throws MailException {

    }

//
//    private final JavaMailSender mailSender;
//
//
//    @Override
//    public void send(SimpleMailMessage simpleMessage) throws MailException {
//        MailSender.super.send(simpleMessage);
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo("duser87@yandex.ru");
//        mailMessage.setText("Hi!");
//        mailMessage.setSubject("Пысьмо");
//        mailSender.send(mailMessage);
//    }
//
//    @Override
//    public void send(SimpleMailMessage... simpleMessages) throws MailException {
//
//    }
}
