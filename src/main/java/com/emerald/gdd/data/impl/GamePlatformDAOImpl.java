package com.emerald.gdd.data.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.data.model.GamePlatformDAO;
@Component
public class GamePlatformDAOImpl implements GamePlatformDAO
{

	@Override
	public List<GamePlatform> selectAll()
	{
		SqlSession session = null;
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			List<GamePlatform> gamePlatform = session.selectList("GamePlatformMapper.selectAll");
			return gamePlatform;
		} catch (Exception e)
		{
			e.printStackTrace();
			// do nothing
		} finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return null;
	}

	@Override
	public GamePlatform selectById(String id)
	{
		SqlSession session = null;
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			GamePlatform gamePlatform = session.selectOne("GamePlatformMapper.selectById", id);
			return gamePlatform;
		} catch (Exception e)
		{
			e.printStackTrace();
			// do nothing
		} finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return null;
	}

	@Override
	public GamePlatform select(GamePlatform gamePlatform)
	{
		return selectById(gamePlatform.getName());
	}

}
