package com.emerald.gdd.beans.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.util.Assert;

import com.emerald.gdd.beans.model.BaseBean;
import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.common.params.impl.SimplifiedGDDFormat;
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
	private Integer					pageNum;
	private ESRBRatingService		eSRBRatingService;
	/**
	 * This is the first page in the scroll-able build content.
	 */
	private final static Integer	FIRST_PAGE			= 1;
	/**
	 * This is the last page in the scroll-able build content.
	 */
	private final static Integer	FINAL_PAGE			= 10;
	/**
	 * This value is to prevent the user from making too many pages and overloading
	 * the program. With the possibility to make 'infinite' characters, a bad actor
	 * could in theory try to overload the system.
	 */
	private final static Integer	MAX_ALLOWABLE_PAGES	= 1000;
	
	/////////////////////////////////////////////////////
	//**************************************************
	//* The following booleans control what is seen on *
	//* the UI.                                        *
	//**************************************************
	/////////////////////////////////////////////////////
	private List<Boolean> isPageActive;


	@PostConstruct
	public void init()
	{
		setPageNum(1);
		this.setSimplifiedGDDBuilder(new SimplifiedGDDBuilderImpl());
		this.setESRBRatingService(new ESRBRatingServiceImpl());
		this.setGamePlatformService(new GamePlatformServiceImpl());
		isPageActive = new ArrayList<Boolean> (FINAL_PAGE);
		for (int i = 0; i < FINAL_PAGE; i++)
		{
			isPageActive.add(i, Boolean.FALSE);
		}
		showPage(FIRST_PAGE);
	}

	public SimplifiedGDDBuilder getSimplifiedGDDBuilder()
	{
		return simplifiedGDDBuilder;
	}

	public void setSimplifiedGDDBuilder(SimplifiedGDDBuilder simplifiedGDDBuilder)
	{
		this.simplifiedGDDBuilder = simplifiedGDDBuilder;
	}

	public Integer getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public void nextPage()
	{
		/* || Possibly implement a method to check number of total pages*/ 
		if (getPageNumber() == FINAL_PAGE - 1 )
		{

		} else
		{
			setPageNum(pageNum + 1);
			showPage(getPageNum());
		}
	}

	public void lastPage()
	{
		if (!(getPageNum() <= FIRST_PAGE))
		{
			setPageNum(pageNum - 1);
			showPage(getPageNum());
		}
	}

	public List<SelectItem> getGamePlatforms()
	{
		List<GamePlatform> gamePlatforms = getGamePlatformService().getAllGamePlatforms();
		List<SelectItem> returnList = CommonUtils.getDefaultList();
		for (GamePlatform gamePlatform : gamePlatforms)
		{
			returnList.add(new SelectItem(gamePlatform.getName(), gamePlatform.getName()));
		}
		return returnList;
	}

	public List<SelectItem> getEsrbRatings()
	{
		List<ESRBRating> esrbRatings = getESRBRatingService().getAllESRBRatings();
		List<SelectItem> returnList = CommonUtils.getDefaultList();
		for (ESRBRating esrbRating : esrbRatings)
		{
			returnList.add(new SelectItem(esrbRating.getFullRating(), esrbRating.getRating()));
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
	
	public List<Boolean> getIsPageActive()
	{
		return isPageActive;
	}

	public void setIsPageActive(List<Boolean> isPageActive)
	{
		this.isPageActive = isPageActive;
	}
	public void graphicUpload(FileUploadEvent event)
	{
		System.out.println("Entering grahpicUpload method");
		Assert.notNull(event, "The file upload did not occur properly");
		UploadedFile file = event.getFile();
		System.out.println();
		System.out.println(file.getFileName());
		System.out.println();
		BufferedImage bf = null;
		try {
			bf = ImageIO.read((File) file);
		}
		catch(IOException e)
		{
			System.out.println();
			System.out.println("You lose sucker!");
			System.out.println();
		}
	}

	public List<SelectItem> getMediaTypes()
	{
		List<SelectItem> returnList = CommonUtils.getDefaultList();

		return returnList;
	}

	public String getCurrentPage()
	{
		return "build_" + getPageNumber() + CommonUtils.XHTML;
	}


	private void showPage(int pageNumber)
	{
		for (int i = 0; i < FINAL_PAGE; i++)
		{
			isPageActive.set(i, Boolean.FALSE);
		}
		isPageActive.set(pageNumber, Boolean.TRUE);
	}
	
	private int getPageNumber()
	{
		for(int i = 0; i < isPageActive.size(); i++)
		{
			if (isPageActive.get(i))
			{
				return i;
			}
		}
		return FIRST_PAGE;
	}
	
	public void build()
	{
		SimplifiedGDDFormat simplifiedGDDFormat = (SimplifiedGDDFormat) this.simplifiedGDDBuilder.build();
	}
}
