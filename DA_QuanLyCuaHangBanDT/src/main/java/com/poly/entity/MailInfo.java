package com.poly.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailInfo {
	@NotBlank(message = "{NotBlank.mail.from}")
	@Email(message = "Email.mail.form")
	String from;
	
	@NotBlank(message = "{NotBlank.mail.to}")
	@Email(message = "NotBlank.mail.to")
	String to;
	
	
	String[] cc;
	String[] bcc;
	
	String subject;
	
	@NotBlank(message = "{NotBlank.mail.body}")
	String body;
	String[] attachments;

	public MailInfo(String to, String subject, String body) {
		this.from = "FPT Polytechnic <poly@fpt.edu.vn>";
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
}
