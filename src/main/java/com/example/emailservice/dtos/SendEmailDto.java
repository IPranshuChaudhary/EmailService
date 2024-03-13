package com.example.emailservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailDto {
    private String to;
    private String from;
    private String message;
    private String subject;
}
