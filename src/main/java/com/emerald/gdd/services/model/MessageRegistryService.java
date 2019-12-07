package com.emerald.gdd.services.model;

import com.emerald.gdd.common.params.impl.Message;

public interface MessageRegistryService
{

	public String selectMessageFromKey(String key);

	public boolean insertMessage(Message record);
}
