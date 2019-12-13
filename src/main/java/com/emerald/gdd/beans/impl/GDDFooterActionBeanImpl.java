package com.emerald.gdd.beans.impl;

import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class GDDFooterActionBeanImpl
{
	private final String githubLink = "https://github.com/C4X2/GDD";

	public void github(ActionEvent ae)
	{
		//TODO add additional processing
	}
	
	public String getGithubLink()
	{
		return githubLink;
	}
}
