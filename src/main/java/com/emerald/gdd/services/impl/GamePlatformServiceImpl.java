package com.emerald.gdd.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.services.model.GamePlatformService;

public class GamePlatformServiceImpl implements GamePlatformService
{

	@Override
	public List<GamePlatform> getAllGamePlatforms()
	{
		return new ArrayList<GamePlatform> ();
	}
    
}
