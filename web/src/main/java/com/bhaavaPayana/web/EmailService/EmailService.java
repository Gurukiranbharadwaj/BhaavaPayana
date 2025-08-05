package com.bhaavaPayana.web.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bhaavaPayana.web.DTO.ContactRequest;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(ContactRequest request) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo("sanjayrsofficial@gmail.com");        
        message.setSubject("Contact Me Request For Bhaava Payana From"+request.getName());    
        message.setText("Name:"+request.getName()+
        		"\n Email:"+request.getEmail()+
        		"\n Mobile Number:"+request.getMobileNo()+        
        		"\n Message:"+request.getMessage());
		
		
		mailsender.send(message);
		System.out.println("Email Sent Successfully");
		
	}

}
