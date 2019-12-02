package com.emerald.gdd.common.params.impl;

import java.util.Date;

/**
 * A parameter representing any text that is desplayed on the screen.
 * 
 * @author C4X2
 * @version 1.0
 */
public class Message
{
	private String	messageKey;
	private String	message;
	private String	description;
	private Date	createdDate;
	private Date	updateDate;
	private Date	retiredDate;

	public String getMessageKey()
	{
		return messageKey;
	}

	public void setMessageKey(String messageKey)
	{
		this.messageKey = messageKey;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public Date getRetiredDate()
	{
		return retiredDate;
	}

	public void setRetiredDate(Date retiredDate)
	{
		this.retiredDate = retiredDate;
	}
}
