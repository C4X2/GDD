package com.emerald.gdd.beans.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "footer")
@Scope("request")
public class GDDFooterActionBeanImpl
{
	private final String githubLink = "https://github.com/C4X2/GDD";

	public String getGithubLink()
	{
		return githubLink;
	}
}
