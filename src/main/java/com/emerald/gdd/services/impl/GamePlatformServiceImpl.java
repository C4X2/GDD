package com.emerald.gdd.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.data.impl.GamePlatformDAOImpl;
import com.emerald.gdd.data.model.GamePlatformDAO;
import com.emerald.gdd.services.model.GamePlatformService;

public class GamePlatformServiceImpl implements GamePlatformService
{
	GamePlatformDAO gamePlatformDAO;
	
	public GamePlatformServiceImpl()
	{
		gamePlatformDAO = new GamePlatformDAOImpl();
	}

	@Override
	public List<GamePlatform> getAllGamePlatforms()
	{
		List<GamePlatform> rtrnList = new ArrayList<GamePlatform> ();
		rtrnList.addAll(gamePlatformDAO.selectAll());
		return rtrnList;
	}

	@Override
	public GamePlatform selectGamePlatformByName(String name)
	{
		return gamePlatformDAO.selectById(name);
	}
    
}
