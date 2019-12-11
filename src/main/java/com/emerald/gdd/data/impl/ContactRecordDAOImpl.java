package com.emerald.gdd.data.impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emerald.gdd.common.params.impl.ContactRecord;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.data.model.ContactRecordDAO;

public class ContactRecordDAOImpl implements ContactRecordDAO
{

	@Override
	public int insert(ContactRecord record)
	{
		SqlSession session = null;
		try
		{
			InputStream reader = Resources.getResourceAsStream(CommonUtils.MY_BATIS_RESOURCE_LOCATION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			int rows = session.insert("ContactRecordMapper.insert", record);
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
