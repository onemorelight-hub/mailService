package com.example.mailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mailService.model.MailInfo;
import com.example.mailService.service.EmailService;

@RestController
@RequestMapping (value = "/sendmail")
public class MailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping ("/sendVerificationMail")
	public boolean sendVerificationMail(@RequestBody MailInfo mailInfo) {
		return emailService.sendMail(mailInfo);
	}
}
