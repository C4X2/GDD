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
		List<GamePlatform> rtrnList = new ArrayList<GamePlatform> ();
		// Add all relevant GamePlatforms
		return rtrnList;
	}

	@Override
	public GamePlatform selectGamePlatformByName(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}
    
}
