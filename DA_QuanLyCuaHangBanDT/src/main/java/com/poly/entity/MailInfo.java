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
	
	String from;
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
