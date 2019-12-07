package com.emerald.gdd.data.impl;

import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emerald.gdd.common.params.impl.Message;
import com.emerald.gdd.data.model.MessageRegistryDAO;

public class MessageRegistryDAOImpl implements MessageRegistryDAO
{
	private final String MY_BATIS_RESOURCE_LOCATION = "com/emerald/gdd/data/mybatis-config.xml";
	@Override
	public String selectById(String id)
	{
		try
		{
			InputStream reader = Resources.getResourceAsStream(MY_BATIS_RESOURCE_LOCATION);
			//Reader reader = Resources.getResourceAsReader("com/emerald/gdd/data/mybatis-config.xml");
	    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	    	SqlSession session = sqlSessionFactory.openSession();
	    	Message message = session.selectOne("MessageMapper.selectById", id);
	    	return message.getMessage();
		}
		catch(Exception e)
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
			Reader reader = Resources.getResourceAsReader(MY_BATIS_RESOURCE_LOCATION);
	    	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	    	SqlSession session = sqlSessionFactory.openSession();
	    	session.selectOne("MessageMapper.insert", record);
	    	return 1;
		}
		catch(Exception e)
		{
			// do nothing
		}
		return 0;
	}

}
