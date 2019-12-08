package com.emerald.gdd.data.impl;

import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emerald.gdd.common.params.impl.Message;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.data.model.MessageRegistryDAO;

public class MessageRegistryDAOImpl implements MessageRegistryDAO
{

	@Override
	public String selectById(String id)
	{
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			Message message = session.selectOne("MessageMapper.selectById", id);
			return message.getMessage();
		} catch (Exception e)
		{
			e.printStackTrace();
			// do nothing
		}
		return null;
	}

	@Override
	public int insert(Message record)
	{
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			int rows = session.insert("MessageMapper.insert", record);
			session.commit(true);
			return rows;
		} catch (Exception e)
		{
			// do nothing
		}
		return 0;
	}

}
