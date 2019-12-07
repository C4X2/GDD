package com.emerald.gdd.common.params.impl;

import java.util.Date;

/**
 * A class to mirror the ESRB ratings for video games. For more information on
 * ESRB visit there website.
 *
 * @see https://www.esrb.org/ratings-guide/
 *
 * @author C4X2
 * @version 2.0
 *
 */
public class ESRBRating
{
	private String	rating;
	private String	fullRating;
	private String	description;
	private Date	createdDate;
	private Date	updateDate;
	private Date	retiredDate;

	public String getRating()
	{
		return rating;
	}

	public void setRating(String rating)
	{
		this.rating = rating;
	}

	public String getFullRating()
	{
		return fullRating;
	}

	public void setFullRating(String fullRating)
	{
		this.fullRating = fullRating;
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
