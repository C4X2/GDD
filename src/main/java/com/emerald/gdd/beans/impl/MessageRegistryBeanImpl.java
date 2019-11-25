package com.emerald.gdd.beans.impl;

import javax.faces.bean.ManagedBean;

import com.emerald.gdd.beans.model.MessageRegistryBean;

/**
 *
 * @author C4X2
 * @version 1.0
 */
@ManagedBean(name="msg" , eager=true)
public class MessageRegistryBeanImpl implements MessageRegistryBean
{
	private final String trueName = "MessageResgistryBean";

	public String getTrueName()
	{
		return trueName;
	}

}
