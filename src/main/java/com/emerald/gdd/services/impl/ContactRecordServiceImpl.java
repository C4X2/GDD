package com.emerald.gdd.services.impl;

import java.sql.Date;
import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.util.StringUtils;

import com.emerald.gdd.common.params.impl.ContactRecord;
import com.emerald.gdd.common.utils.CommonUtils;
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
	public boolean validateAndSaveContactRecord(ContactRecord record)
	{
		if (record == null || !StringUtils.hasText(record.getReason()) || !StringUtils.hasText(record.getComment()))
		{
			return false;
		}
		record.setCreatedDate(Date.valueOf(LocalDate.now()));
		return contactRecordDAO.insert(record) > 0;
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
