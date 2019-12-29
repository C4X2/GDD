package com.emerald.gdd.services.impl;

import com.emerald.gdd.common.constants.EmeraldEmailConstants;
import com.emerald.gdd.services.model.EmailService;

import java.io.File;

import org.apache.commons.mail.*;

public class EmailServiceImpl implements EmailService, EmeraldEmailConstants
{

	private String userEmail;

	@Override
	public void send(String email)
	{
		send(email, null);
	}

	@Override
	public void send(String email, File attachment)
	{
		// Check to see input is a valid email address
		if (!validateEmail(email))
		{
			return;
		}

		// Create the attachment
		EmailAttachment emailAttachment = new EmailAttachment();
		if (attachment != null)
		{
			emailAttachment.setPath(attachment.getAbsolutePath());
			emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
			emailAttachment.setDescription(GDD_FILE);
			emailAttachment.setName(attachment.getName().isEmpty() ? GDD_FILE : attachment.getName());
		}
		// Create the email
		try
		{
			MultiPartEmail outputEmail = new MultiPartEmail();
			outputEmail.setHostName(EMAIL_SERVER);
			outputEmail.addTo(email, "Receiptant");
			outputEmail.setFrom(FROM_ADDRESS, FROM_ADDRESSOR);
			outputEmail.setSubject(GDD_FILE);
			outputEmail.setMsg("Here is the GDD File");
			outputEmail.attach(emailAttachment);
			outputEmail.setAuthentication(FROM_ADDRESS, PASSWORD);
			outputEmail.setSSLOnConnect(true);
			outputEmail.setSslSmtpPort(SSL_PORT_NUMBER.toString());
			outputEmail.send();
		} catch (EmailException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public boolean validateEmail(String email)
	{
		if (email == null)
		{
			return false;
		}
		return email.matches(EMAIL_REGEX);
	}

	@Override
	public void setUserEmail(String email)
	{
		this.userEmail = email;
	}

	@Override
	public String getUserEmail()
	{
		return this.userEmail;
	}

}