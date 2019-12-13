package com.emerald.gdd.common.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.services.impl.GamePlatformServiceImpl;
import com.emerald.gdd.services.model.GamePlatformService;

@FacesConverter(value = "targetedPlatformConverter")
public class TargetedPlatformConverter implements Converter
{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		GamePlatformService gps = new GamePlatformServiceImpl();
		GamePlatform rtnVal = gps.selectGamePlatformByName(value);
		return rtnVal;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		String rtnVal = "";
		if (value != null && value instanceof GamePlatform)
		{
			GamePlatform gm = (GamePlatform) value;
			rtnVal = gm.getName();
		}
		return rtnVal;
	}

}
