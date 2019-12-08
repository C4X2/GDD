package com.emerald.gdd.beans.impl;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import com.emerald.gdd.beans.model.BaseBean;
import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.services.model.ESRBRatingService;
import com.emerald.gdd.services.impl.ESRBRatingServiceImpl;
import com.emerald.gdd.services.impl.GamePlatformServiceImpl;
import com.emerald.gdd.services.impl.SimplifiedGDDBuilderImpl;
import com.emerald.gdd.services.model.GamePlatformService;
import com.emerald.gdd.services.model.SimplifiedGDDBuilder;

@ManagedBean(name = "build", eager = true)
@SessionScoped
public class GDDBuildBeanImpl implements BaseBean
{
	private SimplifiedGDDBuilder	simplifiedGDDBuilder;
	private GamePlatformService		gamePlatformService;
	private Integer					pageNumber;
	private ESRBRatingService		eSRBRatingService;

	@PostConstruct
	public void init()
	{
		setPageNumber(1);
		this.setSimplifiedGDDBuilder(new SimplifiedGDDBuilderImpl());
		this.setESRBRatingService(new ESRBRatingServiceImpl());
		this.setGamePlatformService(new GamePlatformServiceImpl());
	}

	public SimplifiedGDDBuilder getSimplifiedGDDBuilder()
	{
		return simplifiedGDDBuilder;
	}

	public void setSimplifiedGDDBuilder(SimplifiedGDDBuilder simplifiedGDDBuilder)
	{
		this.simplifiedGDDBuilder = simplifiedGDDBuilder;
	}

	public Integer getPageNumber()
	{
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	public void incrementPageNumber()
	{
		setPageNumber(pageNumber + 1);
	}

	public List<SelectItem> getGamePlatforms()
	{
		List<GamePlatform> gamePlatforms = getGamePlatformService().getAllGamePlatforms();
		List<SelectItem> returnList = CommonUtils.getDefaultList();
		for (GamePlatform gamePlatform : gamePlatforms)
		{
			returnList.add(new SelectItem(gamePlatform, gamePlatform.getName()));
		}
		return returnList;
	}

	public List<SelectItem> getEsrbRatings()
	{
		List<ESRBRating> esrbRatings = getESRBRatingService().getAllESRBRatings();
		List<SelectItem> returnList = CommonUtils.getDefaultList();
		for (ESRBRating esrbRating : esrbRatings)
		{
			returnList.add(new SelectItem(esrbRating, esrbRating.getRating()));
		}
		return returnList;
	}

	public ESRBRatingService getESRBRatingService()
	{
		return this.eSRBRatingService;
	}

	public void setESRBRatingService(ESRBRatingService esrbRatingService)
	{
		this.eSRBRatingService = esrbRatingService;
	}

	public GamePlatformService getGamePlatformService()
	{
		return this.gamePlatformService;
	}

	public void setGamePlatformService(GamePlatformService gamePlatformService)
	{
		this.gamePlatformService = gamePlatformService;
	}
	
	public void graphicUpload(FileUploadEvent event)
	{
		System.out.println("Entering grahpicUpload method");
		Assert.notNull(event, "The file upload did not occur properly");
		UploadedFile file = event.getFile();
		System.out.println();
		System.out.println(file.getFileName());
		System.out.println();
	}
	
	public List<SelectItem> getMediaTypes()
	{
		List<SelectItem> returnList = CommonUtils.getDefaultList();
		Object ong = MediaType.TEXT_XML;
		
		return returnList;
	}
}
