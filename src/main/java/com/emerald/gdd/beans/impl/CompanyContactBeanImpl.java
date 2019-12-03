package com.emerald.gdd.beans.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import com.emerald.gdd.beans.model.CompanyContactBean;
import com.emerald.gdd.common.params.impl.ContactRecord;

@ManagedBean(name = "contact")
@RequestScope
public class CompanyContactBeanImpl implements CompanyContactBean
{
	private static final String	PLEASE_SELECT	= "Please Select";
	private static final String	COMPLAINT		= "Complaint";
	private static final String	SUGGESTION		= "Suggestion";
	private static final String	OTHER			= "Other";
	@Autowired
	private ContactRecord		contactRecord;
	
	@PostConstruct
	public void init()
	{
		System.out.println("Yolo Swag");
		contactRecord = new ContactRecord();
	}

	@Override
	public List<SelectItem> getHelpList()
	{
		List<SelectItem> helpList = new ArrayList<>();
		helpList.add(new SelectItem(null, PLEASE_SELECT));
		helpList.add(new SelectItem(COMPLAINT, COMPLAINT));
		helpList.add(new SelectItem(SUGGESTION, SUGGESTION));
		helpList.add(new SelectItem(OTHER, OTHER));
		/*
		 * Here retrieve all helplist select items from the database to populate the UI
		 */
		return helpList;
	}
	
	public void save()
	{
		if (contactRecord != null)
		{
			System.out.println();
			System.out.println("Not null!");
			System.out.println();
		}
	}

	public ContactRecord getContactRecord()
	{
		return contactRecord;
	}

	public void setContactRecord(ContactRecord contactRecord)
	{
		this.contactRecord = contactRecord;
	}

}
