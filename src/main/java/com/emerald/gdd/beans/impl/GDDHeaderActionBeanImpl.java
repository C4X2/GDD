package com.emerald.gdd.beans.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name="headerActionBean")
@SessionScoped
public class GDDHeaderActionBeanImpl
{
	public static final String HOME = "Home";
	
	public SelectItem getHome()
	{
		return new SelectItem("Home", "home");
	}
}
