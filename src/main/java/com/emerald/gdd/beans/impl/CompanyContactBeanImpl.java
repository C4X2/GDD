package com.emerald.gdd.beans.impl;

import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emerald.gdd.beans.model.CompanyContactBean;
import com.emerald.gdd.common.params.impl.ContactRecord;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.services.model.ContactRecordService;

@Component(value = "contact")
@Scope("session")
public class CompanyContactBeanImpl implements CompanyContactBean
{
	private static final String		COMPLAINT	= "Complaint";
	private static final String		SUGGESTION	= "Suggestion";
	private static final String		OTHER		= "Other";
	private static final String		SUCCESS_MSG	= "Your record was submitted successfully!";
	private static final String		FAILURE_MSG	= "Your record errored out!";
	@Autowired
	private ContactRecord			contactRecord;
	@Autowired
	private ContactRecordService	contactRecordService;

	@Override
	public List<SelectItem> getHelpList()
	{
		List<SelectItem> helpList = CommonUtils.getDefaultList();
		helpList.add(new SelectItem(COMPLAINT, COMPLAINT));
		helpList.add(new SelectItem(SUGGESTION, SUGGESTION));
		helpList.add(new SelectItem(OTHER, OTHER));
		return helpList;
	}

	@Override
	public void submit()
	{
		boolean sucess = false;
		sucess = contactRecordService.validateAndSaveContactRecord(contactRecord);
		String message = (sucess) ? SUCCESS_MSG : FAILURE_MSG;
		CommonUtils.addPopUpMessage("Result:", message);
		resetContactRecord();
	}

	@Override
	public void resetContactRecord()
	{
		contactRecord = new ContactRecord();
	}

	public ContactRecord getContactRecord()
	{
		return contactRecord;
	}

	public void setContactRecord(ContactRecord contactRecord)
	{
		this.contactRecord = contactRecord;
	}

	public ContactRecordService getContactRecordService()
	{
		return contactRecordService;
	}

	public void setContactRecordService(ContactRecordService contactRecordService)
	{
		this.contactRecordService = contactRecordService;
	}

}
