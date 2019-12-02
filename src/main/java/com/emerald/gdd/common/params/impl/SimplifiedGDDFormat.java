package com.emerald.gdd.common.params.impl;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import com.emerald.gdd.common.params.model.GDD;

/**
 * A class representation of a simple 10-page GDD.
 * 
 * @author C4X2
 * @version 1.0
 */
public class SimplifiedGDDFormat implements GDD
{
	// Page 1 Begin
	private BufferedImage			graphic;
	private String					title;
	private String					contactInfo;
	private String					companyInfo;
	private GamePlatform			targetedPlatform;
	private ESRBRating				esrbRating;
	private String					targetAudience;
	private Date					shipDate;
	// Page 1 End

	// Page 2 Begin
	private String					storyOutline;
	// Page 2 End

	// Page 3 Begin
	private String					gameInspirations;
	// Page 3 End

	// Page 4-X Begin
	List<CharacterDesignTemplate>	heroesAndVillains;
	// Page 4-X End

	// Page X + 1 Begin
	private String					characterControlSheme;
	// Page X + 1 End

	// Page X + 2 Begin
	private String					playerExperienceGoal;
	// Page X + 2 End

	// Page X + 3 Begin
	private String					mechanics;
	// Page X + 3 End

	// Final Page
	private String					monetizationStrategy;
	// Final Page

	public BufferedImage getGraphic()
	{
		return graphic;
	}

	public void setGraphic(BufferedImage graphic)
	{
		this.graphic = graphic;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContactInfo()
	{
		return contactInfo;
	}

	public void setContactInfo(String contactInfo)
	{
		this.contactInfo = contactInfo;
	}

	public String getCompanyInfo()
	{
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo)
	{
		this.companyInfo = companyInfo;
	}

	public GamePlatform getTargetedPlatform()
	{
		return targetedPlatform;
	}

	public void setTargetedPlatform(GamePlatform targetedPlatform)
	{
		this.targetedPlatform = targetedPlatform;
	}

	public ESRBRating getEsrbRating()
	{
		return esrbRating;
	}

	public void setEsrbRating(ESRBRating esrbRating)
	{
		this.esrbRating = esrbRating;
	}

	public String getTargetAudience()
	{
		return targetAudience;
	}

	public void setTargetAudience(String targetAudience)
	{
		this.targetAudience = targetAudience;
	}

	public Date getShipDate()
	{
		return shipDate;
	}

	public void setShipDate(Date shipDate)
	{
		this.shipDate = shipDate;
	}

	public String getStoryOutline()
	{
		return storyOutline;
	}

	public void setStoryOutline(String storyOutline)
	{
		this.storyOutline = storyOutline;
	}

	public String getGameInspirations()
	{
		return gameInspirations;
	}

	public void setGameInspirations(String gameInspirations)
	{
		this.gameInspirations = gameInspirations;
	}

	public List<CharacterDesignTemplate> getHeroesAndVillains()
	{
		return heroesAndVillains;
	}

	public void setHeroesAndVillains(List<CharacterDesignTemplate> heroesAndVillains)
	{
		this.heroesAndVillains = heroesAndVillains;
	}

	public String getCharacterControlSheme()
	{
		return characterControlSheme;
	}

	public void setCharacterControlSheme(String characterControlSheme)
	{
		this.characterControlSheme = characterControlSheme;
	}

	public String getPlayerExperienceGoal()
	{
		return playerExperienceGoal;
	}

	public void setPlayerExperienceGoal(String playerExperienceGoal)
	{
		this.playerExperienceGoal = playerExperienceGoal;
	}

	public String getMechanics()
	{
		return mechanics;
	}

	public void setMechanics(String mechanics)
	{
		this.mechanics = mechanics;
	}

	public String getMonetizationStrategy()
	{
		return monetizationStrategy;
	}

	public void setMonetizationStrategy(String monetizationStrategy)
	{
		this.monetizationStrategy = monetizationStrategy;
	}
}
