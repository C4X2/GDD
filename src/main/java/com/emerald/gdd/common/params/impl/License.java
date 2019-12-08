package com.emerald.gdd.common.params.impl;

import java.util.Date;

/**
 * A parameter representing a License Agreement
 *
 * @author C4X2
 * @version 1.0
 */
public class License
{
	private String	licenseKey;
	private String	text;
	/** This is a link the homepage where the license text is defined */
	private String	linkToDef;
	private String	description;
	private Date	createdDate;
	private Date	updateDate;
	private Date	retiredDate;

	public String getLicenseKey()
	{
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey)
	{
		this.licenseKey = licenseKey;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getLinkToDef()
	{
		return linkToDef;
	}

	public void setLinkToDef(String linkToDef)
	{
		this.linkToDef = linkToDef;
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
