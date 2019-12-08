package com.emerald.gdd.data.model;

import com.emerald.gdd.common.params.impl.Message;

public interface MessageRegistryDAO
{
	public String selectById(String id);
	
	public int insert(Message record);
}
