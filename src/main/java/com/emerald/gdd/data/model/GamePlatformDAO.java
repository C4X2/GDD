package com.emerald.gdd.data.model;

import java.util.List;

import com.emerald.gdd.common.params.impl.GamePlatform;

public interface GamePlatformDAO
{
	List<GamePlatform> selectAll();
	
	GamePlatform selectById(String id);
	
	GamePlatform select(GamePlatform gamePlatform);
}
