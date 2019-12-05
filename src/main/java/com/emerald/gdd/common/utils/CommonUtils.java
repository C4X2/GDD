package com.emerald.gdd.common.utils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class CommonUtils
{
	public static final String PLEASE_SELECT = "Please Select";
	
	/**
	 * Returns a list of select items only populated with a \'Please Select\' options mapped onto a null object value.
	 * @return a default list of SelectItems.
	 */
	public static List<SelectItem> getDefaultList()
	{
		List<SelectItem> returnList = new ArrayList<SelectItem> ();
		returnList.add(new SelectItem(null, PLEASE_SELECT));
		return returnList;
	}
}
