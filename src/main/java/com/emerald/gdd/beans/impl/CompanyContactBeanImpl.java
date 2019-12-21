package com.emerald.gdd.beans.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import com.emerald.gdd.beans.model.CompanyContactBean;
import com.emerald.gdd.common.params.impl.ContactRecord;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.services.impl.ContactRecordServiceImpl;
import com.emerald.gdd.services.model.ContactRecordService;

@ManagedBean(name = "contact")
@RequestScope
public class CompanyContactBeanImpl implements CompanyContactBean
{
	private static final String		COMPLAINT	= "Complaint";
	private static final String		SUGGESTION	= "Suggestion";
	private static final String		OTHER		= "Other";
	private static final String		SUCCESS_MSG	= "Your Record was submitted successfully!";
	private static final String		FAILURE_MSG	= "Your record errored out!";
	@Autowired
	private ContactRecord			contactRecord;
	private boolean					reasonSelected;
	private ContactRecordService	contactRecordService;

	@PostConstruct
	public void init()
	{
		setContactRecord(new ContactRecord());
		setContactRecordService(new ContactRecordServiceImpl());
	}

	@Override
	public List<SelectItem> getHelpList()
	{
		List<SelectItem> helpList = CommonUtils.getDefaultList();
		helpList.add(new SelectItem(COMPLAINT, COMPLAINT));
		helpList.add(new SelectItem(SUGGESTION, SUGGESTION));
		helpList.add(new SelectItem(OTHER, OTHER));
		return helpList;
	}

	public void save()
	{
		boolean sucess = false;
		sucess = contactRecordService.validateAndSaveContactRecord(contactRecord);
		String message = (sucess) ? SUCCESS_MSG : FAILURE_MSG;
		addPopUpMessage(message);
		resetContactRecord();
	}

	private void addPopUpMessage(String message)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Result:", message));
	}

	private void resetContactRecord()
	{
		contactRecord = null;
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

	public boolean isReasonSelected()
	{
		return reasonSelected;
	}

	public void setReasonSelected(boolean reasonSelected)
	{
		this.reasonSelected = reasonSelected;
	}

	public void revealTextBox(ValueChangeEvent event)
	{
		setReasonSelected(true);
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
