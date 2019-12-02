package com.emerald.gdd.beans.impl;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.emerald.gdd.beans.model.MessageRegistryBean;

/**
 *
 * @author C4X2
 * @version 1.0
 */
@ManagedBean(name="msg" , eager=true)
@ApplicationScoped()
public class MessageRegistryBeanImpl implements MessageRegistryBean
{
	private final String trueName = "MessageResgistryBean";
	
	private String gddComment;
	
	public MessageRegistryBeanImpl()
	{
		
	}

	public String getTrueName()
	{
		return trueName;
	}
	
	public String getGDDComment()
	{
		return "What is a GDD you ask?";
	}

	public String getGddComment()
	{
		//return (gddComment == null) ? getGDDComment() : gddComment;
		return "Hello World!";
	}

	public void setGddComment(String gddComment)
	{
		this.gddComment = gddComment;
	}
	
	public String getHomepage()
	{
		return "Game Desgin Document";
	}
	

}
