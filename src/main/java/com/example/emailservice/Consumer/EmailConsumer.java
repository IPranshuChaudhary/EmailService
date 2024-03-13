package com.example.emailservice.Consumer;

import com.example.emailservice.dtos.SendEmailDto;
import com.example.emailservice.services.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EmailConsumer {
    private ObjectMapper objectMapper;
    private EmailService emailService;

    EmailConsumer(ObjectMapper objectMapper, EmailService emailService){
        this.objectMapper = objectMapper;
        this.emailService = emailService;

    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "SendEmail", groupId = "EmailService")
    public void deliverEmails(String context) throws JsonProcessingException {

        SendEmailDto sendEmailDto = new SendEmailDto();

        sendEmailDto = objectMapper.readValue(context, SendEmailDto.class);

        System.out.println(context);
        emailService.sendSimpleMail(sendEmailDto);
    }
}
