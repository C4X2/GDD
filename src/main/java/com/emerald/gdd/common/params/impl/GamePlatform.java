package com.emerald.gdd.common.params.impl;

import java.util.Date;

import com.emerald.gdd.common.constants.MediaType;

public class GamePlatform
{
	private String		name;
	private String		abbrivatedName;
	/** A ;-delimited list of manufacturers */
	private String		manufacturer;
	private String		website;
	/**
	 * A developer of a GamePlatform differs from a manufacturer in that the
	 * developer is primarily responsible for the design and architecture of the
	 * system.
	 */
	private String		developer;
	/**
	 * The different types of non-game media the system can handle.
	 */
	private MediaType	mediaTypes;
	private boolean		isCurrentSystem;
	/**
	 * This date refers to the release date of the system in its primary market. For
	 * most hardware systems America is used as the default.
	 */
	private Date		releaseDate;
	private Date		createdDate;
	private Date		updateDate;
	private Date		retiredDate;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAbbrivatedName()
	{
		return abbrivatedName;
	}

	public void setAbbrivatedName(String abbrivatedName)
	{
		this.abbrivatedName = abbrivatedName;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public String getDeveloper()
	{
		return developer;
	}

	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}

	public MediaType getMediaTypes()
	{
		return mediaTypes;
	}

	public void setMediaTypes(MediaType mediaTypes)
	{
		this.mediaTypes = mediaTypes;
	}

	public boolean isCurrentSystem()
	{
		return isCurrentSystem;
	}

	public void setCurrentSystem(boolean isCurrentSystem)
	{
		this.isCurrentSystem = isCurrentSystem;
	}

	public Date getReleaseDate()
	{
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
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
