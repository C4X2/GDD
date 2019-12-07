package com.emerald.gdd.services.impl;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.ibatis.io.Resources;

import com.emerald.gdd.common.params.impl.Message;
import com.emerald.gdd.services.model.MessageManager;
import com.emerald.gdd.services.model.MessageRegistryService;

public final class MessageManagerImpl implements MessageManager
{
	private static MessageManagerImpl	msg	= null;
	private MessageRegistryService		messageRegistryService;

	private MessageManagerImpl()
	{
		messageRegistryService = new MessageRegistryServiceImpl();
	}

	/**
	 * Method used to reference this class instance. All classes that utilize this
	 * manager should call instance(), as it is the only access point of
	 * instantiation( preferably over any public constructors).
	 * 
	 * @return the current instance of the class. A new instance will be created if
	 *         one does not already exist.
	 */
	public static MessageManager instance()
	{
		if (msg == null)
		{
			msg = new MessageManagerImpl();
		}
		return msg;
	}

	@Override
	public String getMessage(String key)
	{
		return getMessage(key, null);
	}

	@Override
	public String getMessage(String key, String defaultMessage)
	{
		if (key == null)
		{
			return null;
		}
		String message = messageRegistryService.selectMessageFromKey(key);
		return (message == null) ? defaultMessage : message;

	}

	@Override
	public String getMessage(String key, String defaultMessage, String resource)
	{
		if (key == null)
		{
			return null;
		}
		if (resource == null)
		{
			return getMessage(key, defaultMessage);
		}
		try
		{
			String propertyKey = (String) Resources.getUrlAsProperties(resource).get(key);
			return (propertyKey == null) ? defaultMessage : messageRegistryService.selectMessageFromKey(propertyKey);
		} catch (Exception e) 
		{}
		return null;
	}

	@Override
	public boolean addMessage(String key, String message)
	{
		if (key == null || message == null)
		{
			return false;
		}
		Message record = new Message();
		record.setCreatedDate(Date.valueOf(LocalDate.now()));
		record.setMessage(message);
		record.setMessageKey(key);
		record.setDescription(message);
		return messageRegistryService.insertMessage(record);
	}

}
