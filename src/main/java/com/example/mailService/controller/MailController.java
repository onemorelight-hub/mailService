package com.example.mailService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@SuppressWarnings("rawtypes")
	@PostMapping ("/sendVerificationMail")
	public ResponseEntity sendVerificationMail(@RequestBody MailInfo mailInfo) {
		Map<String, Object> object = new HashMap<>();
		if(emailService.sendMail(mailInfo)) {
			object.put("message", "sucessed");
			return ResponseEntity.status(HttpStatus.OK).body(object);
		}
		object.put("message", "Failed");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(object);
	}
}
