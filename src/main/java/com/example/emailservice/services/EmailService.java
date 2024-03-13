package com.example.emailservice.services;

import com.example.emailservice.dtos.SendEmailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    private String sender = "Do-Not-Reply";

    // Method 1
    // To send a simple email
    public String sendSimpleMail(SendEmailDto details)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getTo());
            mailMessage.setText(details.getMessage());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }

    }
}
