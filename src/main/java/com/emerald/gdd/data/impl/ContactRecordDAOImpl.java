package com.emerald.gdd.data.impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emerald.gdd.common.params.impl.ContactRecord;
import com.emerald.gdd.data.model.ContactRecordDAO;

public class ContactRecordDAOImpl implements ContactRecordDAO
{
	private final String MY_BATIS_RESOURCE_LOCATION = "com/emerald/gdd/data/mybatis-config.xml";
	@Override
	public int insert(ContactRecord record)
	{
		try
		{
			InputStream reader = Resources.getResourceAsStream(MY_BATIS_RESOURCE_LOCATION);
		    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
		    SqlSession session = sqlSessionFactory.openSession();
		    session.selectOne("ContactRecordMapper.insert", record);
		    return 1;
		}
		catch(Exception e)
		{
			// do nothing
		}
		return 0;
		
	}

}
