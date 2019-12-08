package com.emerald.gdd.services.model;

import java.util.List;

import com.emerald.gdd.common.params.impl.GamePlatform;

public interface GamePlatformService
{
	public List<GamePlatform> getAllGamePlatforms();

	public GamePlatform selectGamePlatformByName(String name);
}
