package com.emerald.gdd.beans.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.web.context.annotation.RequestScope;

import com.emerald.gdd.beans.model.CompanyContactBean;

@ManagedBean(name = "contact")
@RequestScope
public class CompanyContactBeanImpl implements CompanyContactBean
{
	private static final String	PLEASE_SELECT	= "Please Select";
	private static final String	COMPLAINT		= "Complaint";
	private static final String	SUGGESTION		= "Suggestion";
	private static final String	OTHER			= "Other";

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

}
