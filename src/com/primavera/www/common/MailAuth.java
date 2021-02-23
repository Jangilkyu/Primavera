package com.primavera.www.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MailAuth extends Authenticator{

	PasswordAuthentication pa;
	
	public MailAuth() {
		String mailID = "jewelrye6@gmail.com";
		String mailPW = "sun18817";
		
		pa = new PasswordAuthentication(mailID, mailPW);
	}

	public PasswordAuthentication getAuthentication() {
		return pa;
	}
	
}
