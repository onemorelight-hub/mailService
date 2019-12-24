package com.example.mailService.service;

import org.springframework.stereotype.Service;

import com.example.mailService.model.MailInfo;

@Service
public interface EmailService {

	public boolean sendMail(MailInfo mailInfo);
}
