package com.emerald.gdd.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.data.model.GamePlatformDAO;
import com.emerald.gdd.services.model.GamePlatformService;

@Component
public class GamePlatformServiceImpl implements GamePlatformService
{
	@Autowired
	GamePlatformDAO gamePlatformDAO;

	@Override
	public List<GamePlatform> getAllGamePlatforms()
	{
		List<GamePlatform> rtrnList = new ArrayList<GamePlatform>();
		rtrnList.addAll(gamePlatformDAO.selectAll());
		return rtrnList;
	}

	@Override
	public GamePlatform selectGamePlatformByName(String name)
	{
		return gamePlatformDAO.selectById(name);
	}

}
