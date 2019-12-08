package com.emerald.gdd.services.impl;

import com.emerald.gdd.common.params.impl.ContactRecord;
import com.emerald.gdd.data.impl.ContactRecordDAOImpl;
import com.emerald.gdd.data.model.ContactRecordDAO;
import com.emerald.gdd.services.model.ContactRecordService;

public class ContactRecordServiceImpl implements ContactRecordService
{
	private ContactRecordDAO contactRecordDAO;
	public ContactRecordServiceImpl()
	{
		setContactRecordDAO(new ContactRecordDAOImpl());
	}
	@Override
	public void validateAndSaveContactRecord(ContactRecord record)
	{
		contactRecordDAO.insert(record);		
	}
	public ContactRecordDAO getContactRecordDAO()
	{
		return contactRecordDAO;
	}

	public void setContactRecordDAO(ContactRecordDAO contactRecordDAO)
	{
		this.contactRecordDAO = contactRecordDAO;
	}


	
}
