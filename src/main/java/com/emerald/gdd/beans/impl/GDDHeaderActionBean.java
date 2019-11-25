package com.emerald.gdd.beans.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean(name="headerActionBean")
public class GDDHeaderActionBean
{
	public static final String HOME = "Home";
	
	public SelectItem getHome()
	{
		return new SelectItem("Home", "home");
	}
}
