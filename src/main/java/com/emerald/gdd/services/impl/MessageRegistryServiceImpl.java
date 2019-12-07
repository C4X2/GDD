package com.emerald.gdd.services.impl;


import com.emerald.gdd.common.params.impl.Message;
import com.emerald.gdd.data.impl.MessageRegistryDAOImpl;
import com.emerald.gdd.data.model.MessageRegistryDAO;
import com.emerald.gdd.services.model.MessageRegistryService;

public class MessageRegistryServiceImpl implements MessageRegistryService
{

	private MessageRegistryDAO messageRegistryDAO;
	

	public MessageRegistryServiceImpl()
	{
		messageRegistryDAO = new MessageRegistryDAOImpl();
	}

	@Override
	public String selectMessageFromKey(String key)
	{
		return (key == null) ? null : messageRegistryDAO.selectById(key);
	}

	@Override
	public boolean insertMessage(Message record)
	{
		return (record == null) ? false : (messageRegistryDAO.insert(record) > 0);
	}
	
}
