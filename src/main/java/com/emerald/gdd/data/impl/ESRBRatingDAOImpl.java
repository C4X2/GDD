package com.emerald.gdd.data.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.Message;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.data.model.ESRBRatingDAO;

public class ESRBRatingDAOImpl implements ESRBRatingDAO
{

	@Override
	public List<ESRBRating> selectAll()
	{
		SqlSession session = null;
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			List<ESRBRating> eSRBRating = session.selectList("ESRBRatingMapper.selectAll");
			return eSRBRating;
		} catch (Exception e)
		{
			e.printStackTrace();
			// do nothing
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return null;
	}
	@Override
	public ESRBRating selectById(String id)
	{
		SqlSession session = null;
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			ESRBRating eSRBRating = session.selectOne("ESRBRatingMapper.selectById", id);
			return eSRBRating;
		} catch (Exception e)
		{
			e.printStackTrace();
			// do nothing
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return null;
	}

	@Override
	public int insert(ESRBRating record)
	{
		SqlSession session = null;
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			int rows = session.insert("ESRBRatingMapper.insert", record);
			session.commit(true);
			return rows;
		} catch (Exception e)
		{
			// do nothing
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
		return 0;
	}

}
