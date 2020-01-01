package com.emerald.gdd.common.params.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author C4X2
 * @version 1.0
 *
 */
@Component
public class ContactRecord
{
	private String	reason;
	private String	comment;
	private Date	createdDate;
	private Date	updateDate;
	private Date	retiredDate;

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
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
