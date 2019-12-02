package com.emerald.gdd.common.params.impl;

import java.awt.image.BufferedImage;
import java.util.List;
import com.emerald.gdd.common.constants.*;

/**
 * A character template to be included in a simplified GDD.
 * 
 * @author C4X2
 * @version 1.0
 */
public class CharacterDesignTemplate
{
	private String			name;
	private String			description;
	private String			damageDescription;
	private String			particleEffects;
	private String			levelReward;
	private String			sfx;
	private BufferedImage	image;
	private String			additionalHUDElements;
	private List<String>	addititonalReqs;
	private List<String>	attackDescriptions;
	private List<Animation>	requiredAnimations;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Animation> getRequiredAnimations()
	{
		return requiredAnimations;
	}

	public void setRequiredAnimations(List<Animation> requiredAnimations)
	{
		this.requiredAnimations = requiredAnimations;
	}

	public List<String> getAttackDescriptions()
	{
		return attackDescriptions;
	}

	public void setAttackDescriptions(List<String> attackDescriptions)
	{
		this.attackDescriptions = attackDescriptions;
	}

	public String getDamageDescription()
	{
		return damageDescription;
	}

	public void setDamageDescription(String damageDescription)
	{
		this.damageDescription = damageDescription;
	}

	public String getParticleEffects()
	{
		return particleEffects;
	}

	public void setParticleEffects(String particleEffects)
	{
		this.particleEffects = particleEffects;
	}

	public String getLevelReward()
	{
		return levelReward;
	}

	public void setLevelReward(String levelReward)
	{
		this.levelReward = levelReward;
	}

	public List<String> getAddititonalReqs()
	{
		return addititonalReqs;
	}

	public void setAddititonalReqs(List<String> addititonalReqs)
	{
		this.addititonalReqs = addititonalReqs;
	}

	public String getSfx()
	{
		return sfx;
	}

	public void setSfx(String sfx)
	{
		this.sfx = sfx;
	}

	public String getAdditionalHUDElements()
	{
		return additionalHUDElements;
	}

	public void setAdditionalHUDElements(String additionalHUDElements)
	{
		this.additionalHUDElements = additionalHUDElements;
	}

}
