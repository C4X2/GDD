package com.emerald.gdd.services.impl;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import org.springframework.util.StringUtils;

import com.emerald.gdd.common.params.impl.CharacterDesignTemplate;
import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.common.params.impl.SimplifiedGDDFormat;
import com.emerald.gdd.common.params.model.GDD;

import com.emerald.gdd.services.model.SimplifiedGDDBuilder;

public class SimplifiedGDDBuilderImpl implements SimplifiedGDDBuilder
{
	private SimplifiedGDDFormat simplifiedGDDFormat;

	@Override
	public boolean hasSufficientCriteria()
	{
		if (simplifiedGDDFormat != null)
		{
			if (StringUtils.hasText(simplifiedGDDFormat.getTitle())
					&& StringUtils.hasText(simplifiedGDDFormat.getStoryOutline())
					&& StringUtils.hasText(simplifiedGDDFormat.getPlayerExperienceGoal())
					&& StringUtils.hasText(simplifiedGDDFormat.getMonetizationStrategy())
					&& StringUtils.hasText(simplifiedGDDFormat.getMechanics()))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public GDD build()
	{
		if (hasSufficientCriteria())
		{
			return simplifiedGDDFormat;
		}
		return null;
	}

	@Override
	public SimplifiedGDDBuilder setGraphicImage(BufferedImage graphic)
	{
		this.simplifiedGDDFormat.setGraphic(graphic);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setGDDTitle(String title)
	{
		this.simplifiedGDDFormat.setTitle(title);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setCompanyName(String companyName)
	{
		this.simplifiedGDDFormat.setCompanyInfo(companyName);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setTargetedGamePlatForm(GamePlatform targetedPlatform)
	{
		this.simplifiedGDDFormat.setTargetedPlatform(targetedPlatform);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setTargetedGamePlatForm(String targetedPlatform)
	{
		return setTargetedGamePlatForm(getGamePlatformFromString(targetedPlatform));
	}

	// Might move this into a GamePlatformService class
	private GamePlatform getGamePlatformFromString(String targetedPlatform)
	{
		// TODO: FIND A GAMEPLATFORM BASED OFF KEY
		// LOOK SOMETHING LIKE
		// GAMEPLATFORMDAO.selectPlatformByPrimaryKey(targetedPlatform);
		return null;
	}

	@Override
	public SimplifiedGDDBuilder setTargetedESRBRatingAs(String eSRBRating)
	{
		return setTargetedESRBRatingAs(getESRBRatingFromString(eSRBRating));
	}

	private ESRBRating getESRBRatingFromString(String eSRBRating)
	{
		// TODO: FIND A ESRBRating BASED OFF KEY
		// LOOK SOMETHING LIKE
		// ESRBRatingDAO.selectPlatformByPrimaryKey(targetedPlatform);
		return null;
	}

	@Override
	public SimplifiedGDDBuilder setTargetedESRBRatingAs(ESRBRating eSRBRating)
	{
		this.simplifiedGDDFormat.setEsrbRating(eSRBRating);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setTargetedAudienceAs(String targetedAudience)
	{
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setTargetShipDateAs(String shipdate)
	{
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public SimplifiedGDDBuilder setTargetShipDateAs(Date shipdate)
	{
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public SimplifiedGDDBuilder theStoryOutlineIs(String storyOutline)
	{
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public SimplifiedGDDBuilder theGameInspirationAre(String gameInspirations)
	{
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public SimplifiedGDDBuilder addAHeroOrVillianToTheOutline(CharacterDesignTemplate character)
	{
		// TODO Auto-generated method stub
		return addMultipleHeroesOrVillians(Collections.singletonList(character));
	}

	@Override
	public SimplifiedGDDBuilder addMultipleHeroesOrVillians(List<CharacterDesignTemplate> characters)
	{
		this.simplifiedGDDFormat.getHeroesAndVillains().addAll(characters);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder defineAPlayerExperienceGoal(String goal)
	{
		this.simplifiedGDDFormat.setPlayerExperienceGoal(goal);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder defineAControlScheme(String mechanics)
	{
		this.simplifiedGDDFormat.setMechanics(mechanics);
		return this;
	}

	@Override
	public SimplifiedGDDBuilder defineAMonetizationStrategy(String monetizationStrategy)
	{
		this.simplifiedGDDFormat.setMonetizationStrategy(monetizationStrategy);
		return this;
	}

}
