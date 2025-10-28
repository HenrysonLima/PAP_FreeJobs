package com.pap.freejobs_website.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    // definir email que receberá os emails
    @Value("${app.mail.receiver}")
    private String receiverEmail;

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void enviarEmail(String assunto, String mensagem, String autorEmail) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(receiverEmail);
        email.setSubject(assunto);
        email.setReplyTo(autorEmail);
        email.setText(
                "Nova mensagem recebida através do formulário:\n\n" +
                        "De: " + autorEmail + "\n" +
                        "Mensagem:\n" + mensagem
        );

        mailSender.send(email);
    }
}
