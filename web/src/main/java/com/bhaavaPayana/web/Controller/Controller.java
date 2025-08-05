package com.bhaavaPayana.web.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhaavaPayana.web.DTO.ContactRequest;
import com.bhaavaPayana.web.EmailService.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class Controller {
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public Map<String, String>sendMessage(@RequestBody ContactRequest request){
		
		emailService.sendEmail(request);
		Map<String, String>response=new HashMap<>();
		response.put("message", "Message sent Sucessfully");
		return response;
	}
	
	

}
