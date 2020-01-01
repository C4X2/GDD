package com.emerald.gdd.beans.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.emerald.gdd.beans.model.MessageRegistryBean;
import com.emerald.gdd.services.impl.MessageManagerImpl;

/**
 * This is the primary way that text values in the UI are populated. This class
 * implements Map so that the values can be accessed in the clean
 * #{msg.key_value}. This class assumes a JSF environment!
 *
 * @author C4X2
 * @version 3.2
 */
@Component(value = "msg")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MessageRegistryBeanImpl implements MessageRegistryBean, Map
{

	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		// Since we are using this class as a wrapper for the MessageManager, this
		// inquiry will always be false since there will always be messages in the DB.
		return false;
	}

	@Override
	public boolean containsKey(Object key)
	{
		return (MessageManagerImpl.instance().getMessage((String) key) == null);
	}

	@Override
	public boolean containsValue(Object value)
	{
		throw new UnsupportedOperationException("At this time the containsValue() opeation has not been defined");
	}

	@Override
	public Object get(Object key)
	{
		return (MessageManagerImpl.instance().getMessage((String) key));
	}

	@Override
	public Object put(Object key, Object value)
	{
		return (MessageManagerImpl.instance().addMessage((String) key, (String) value));
	}

	@Override
	public Object remove(Object key)
	{
		throw new UnsupportedOperationException(
				"At this time, this application does not support removing messages from the UI.");
	}

	@Override
	public void putAll(Map m)
	{
		for (Object key : m.keySet())
		{
			put(key, m.get(key));
		}

	}

	@Override
	public void clear()
	{
		throw new UnsupportedOperationException("At this time the clear() opeation has not been defined");
	}

	@Override
	public Set keySet()
	{
		throw new UnsupportedOperationException("At this time the keySet() opeation has not been defined");
	}

	@Override
	public Collection values()
	{
		throw new UnsupportedOperationException("At this time the values() opeation has not been defined");
	}

	@Override
	public Set entrySet()
	{
		throw new UnsupportedOperationException("At this time the entrySet() opeation has not been defined");
	}

}
