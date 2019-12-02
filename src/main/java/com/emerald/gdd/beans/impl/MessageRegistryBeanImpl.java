package com.emerald.gdd.beans.impl;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.emerald.gdd.beans.model.MessageRegistryBean;

/**
 *
 * @author C4X2
 * @version 1.0
 */
@ManagedBean(name = "msg", eager = true)
@ApplicationScoped()
public class MessageRegistryBeanImpl implements MessageRegistryBean
{
	private final String	trueName	= "MessageResgistryBean";

	private String			gddComment;

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
		return "A Game Design Document, or GDD, defines every aspect of your game. "
				+ "Additionaly it acts as an orienting document for each stakeholder in your organization. "
				+ "As a GDD explicitly states the goals game development needs to meet , from the small technical requirements to the large conceptual challenges. "
				+ "Finally, A GDD is a resource for keeping a game true to its roots. If the game changes so should the GDD.";
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
