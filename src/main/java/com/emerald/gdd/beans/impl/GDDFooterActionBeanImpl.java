package com.emerald.gdd.beans.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ManagedBean(name = "footer", eager = true)
//@SessionScoped
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
