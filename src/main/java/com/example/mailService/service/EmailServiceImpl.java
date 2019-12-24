package com.example.mailService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.mailService.model.MailInfo;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value ("${mail.senderName}")
	private String senderName;
	
	@Override
	public boolean sendMail(MailInfo mailInfo) {
		boolean status = true;
		try {
			SimpleMailMessage msg = new SimpleMailMessage();	
			String message = "Dear "+mailInfo.getReceiverName() + ",\n\n" + mailInfo.getMessage() + "\n\nRegards,\n\n" +senderName;
			msg.setSubject(mailInfo.getSubject());
			msg.setTo(mailInfo.getReceiverList());
			msg.setCc(mailInfo.getReceiverInCc());
			msg.setBcc(mailInfo.getReceiverInBcc());
			msg.setText(message);
			javaMailSender.send(msg);
		}catch(Exception e) {
			status = false;
		}
		return status;
	}
}
