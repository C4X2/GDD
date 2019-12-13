package com.emerald.gdd.beans.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.http.MediaType;
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
	private Integer					pageNumber;
	private ESRBRatingService		eSRBRatingService;
	/**
	 * This is the first page in the scroll-able build content.
	 */
	private final static Integer	FIRST_PAGE			= 1;
	/**
	 * This is the last page in the scroll-able build content.
	 */
	private final static Integer	FINAL_PAGE			= 9;
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
	private boolean page1;
	private boolean page2;
	private boolean page3;
	private boolean page4;
	private boolean page5;
	private boolean page6;
	private boolean page7;
	private boolean page8;
	private boolean page9;
	
	
	@PostConstruct
	public void init()
	{
		setPageNumber(1);
		this.setSimplifiedGDDBuilder(new SimplifiedGDDBuilderImpl());
		this.setESRBRatingService(new ESRBRatingServiceImpl());
		this.setGamePlatformService(new GamePlatformServiceImpl());
		page1 = true;
		page2 = false;
		page3 = false;
		page4 = false;
		page5 = false;
		page6 = false;
		page7 = false;
		page8 = false;
		page9 = false;
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

	public void nextPage()
	{
		/*
		if (getPageNumber() == FINAL_PAGE /* || Possibly implement a method to check number of total pages )
		{

		} else
		{
			setPageNumber(pageNumber + 1);
		}*/
		if (page1)
		{
			page1 = false;
			page2 = true;
		}
		else if (page2)
		{
			page2 = false;
			page3 = true;
		}
		else if (page3)
		{
			page3 = false;
			page4 = true;
		}
		else if (page4)
		{
			page4= false;
			page5 = true;
		}
		else if (page5)
		{
			page5= false;
			page6 = true;
		}
		else if (page6)
		{
			page6= false;
			page7 = true;
		}
		else if (page7)
		{
			page7= false;
			page8 = true;
		}
		else if (page8)
		{
			page8= false;
			page9 = true;
		}
		else if (page9)
		{
			page9= false;
			page1 = true;
		}
	}

	public void lastPage()
	{
		if (getPageNumber() <= FIRST_PAGE)
		{
			setPageNumber(FIRST_PAGE);
		} else
		{
			setPageNumber(pageNumber - 1);
		}
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

	public boolean isPage1()
	{
		return page1;
	}

	public void setPage1(boolean page1)
	{
		this.page1 = page1;
	}

	public boolean isPage2()
	{
		return page2;
	}

	public void setPage2(boolean page2)
	{
		this.page2 = page2;
	}

	public boolean isPage3()
	{
		return page3;
	}

	public void setPage3(boolean page3)
	{
		this.page3 = page3;
	}

	public boolean isPage4()
	{
		return page4;
	}

	public void setPage4(boolean page4)
	{
		this.page4 = page4;
	}

	public boolean isPage5()
	{
		return page5;
	}

	public void setPage5(boolean page5)
	{
		this.page5 = page5;
	}

	public boolean isPage6()
	{
		return page6;
	}

	public void setPage6(boolean page6)
	{
		this.page6 = page6;
	}

	public boolean isPage7()
	{
		return page7;
	}

	public void setPage7(boolean page7)
	{
		this.page7 = page7;
	}

	public boolean isPage8()
	{
		return page8;
	}

	public void setPage8(boolean page8)
	{
		this.page8 = page8;
	}

	public boolean isPage9()
	{
		return page9;
	}

	public void setPage9(boolean page9)
	{
		this.page9 = page9;
	}

}
