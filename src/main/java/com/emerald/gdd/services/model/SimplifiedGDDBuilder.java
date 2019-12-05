package com.emerald.gdd.services.model;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

import com.emerald.gdd.common.params.impl.CharacterDesignTemplate;
import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.GamePlatform;


public interface SimplifiedGDDBuilder extends GDDBuilder
{
	public SimplifiedGDDBuilder setGraphicImage(BufferedImage graphic);

	public SimplifiedGDDBuilder setGDDTitle(String title);

	public SimplifiedGDDBuilder setCompanyName(String companyName);

	public SimplifiedGDDBuilder setTargetedGamePlatForm(String targetedPlatform);
	
	public SimplifiedGDDBuilder setTargetedGamePlatForm(GamePlatform targetedPlatform);

	public SimplifiedGDDBuilder setTargetedESRBRatingAs(String eSRBRating);

	public SimplifiedGDDBuilder setTargetedESRBRatingAs(ESRBRating eSRBRating);

	public SimplifiedGDDBuilder setTargetedAudienceAs(String targetedAudience);

	public SimplifiedGDDBuilder setTargetShipDateAs(String shipdate);

	public SimplifiedGDDBuilder setTargetShipDateAs(Date shipdate);

	public SimplifiedGDDBuilder theStoryOutlineIs(String storyOutline);

	public SimplifiedGDDBuilder theGameInspirationAre(String gameInspirations);

	public SimplifiedGDDBuilder addAHeroOrVillianToTheOutline(CharacterDesignTemplate character);

	public SimplifiedGDDBuilder addMultipleHeroesOrVillians(List<CharacterDesignTemplate> characters);

	public SimplifiedGDDBuilder defineAPlayerExperienceGoal(String goal);

	public SimplifiedGDDBuilder defineAControlScheme(String mechanics);

	public SimplifiedGDDBuilder defineAMonetizationStrategy(String monetizationStrategy);

}
