package com.emerald.gdd.common.params.impl;

/**
 * A class to mirror the ESRB ratings for video games. For more information on
 * ESRB visit there website.
 * 
 * @see https://www.esrb.org/ratings-guide/
 * 
 * @author C4X2
 * @version 1.0
 *
 */
public class ESRBRating
{
	private String	rating;
	private String	fullRating;
	private String	description;

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
}
