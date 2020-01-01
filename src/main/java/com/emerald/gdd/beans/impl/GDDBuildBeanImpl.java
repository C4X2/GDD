package com.emerald.gdd.beans.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.emerald.gdd.beans.model.BaseBean;
import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.common.params.impl.SimplifiedGDDFormat;
import com.emerald.gdd.common.utils.CommonUtils;
import com.emerald.gdd.services.model.ESRBRatingService;
import com.emerald.gdd.services.model.EmailService;
import com.emerald.gdd.services.impl.ESRBRatingServiceImpl;
import com.emerald.gdd.services.impl.EmailServiceImpl;
import com.emerald.gdd.services.impl.GamePlatformServiceImpl;
import com.emerald.gdd.services.impl.SimplifiedGDDBuilderImpl;
import com.emerald.gdd.services.impl.SimplifiedGDDFileOutBuilderImpl;
import com.emerald.gdd.services.model.GamePlatformService;
import com.emerald.gdd.services.model.SimplifiedGDDBuilder;
import com.emerald.gdd.services.model.SimplifiedGDDFileOutBuilder;

@Component(value = "build")
@Scope("session")
public class GDDBuildBeanImpl implements BaseBean
{
	@Autowired
	private SimplifiedGDDBuilder		simplifiedGDDBuilder;
	@Autowired
	private SimplifiedGDDFileOutBuilder	simplifiedGDDFileOutBuilder;
	@Autowired
	private GamePlatformService			gamePlatformService;
	private Integer						pageNum;
	@Autowired
	private ESRBRatingService			eSRBRatingService;
	@Autowired
	private EmailService				emailService;
	private String						userEmail;
	/**
	 * This is the first page in the scroll-able build content.
	 */
	private final static Integer		FIRST_PAGE				= 1;
	/**
	 * This is the last page in the scroll-able build content.
	 */
	private final static Integer		FINAL_PAGE				= 10;
	/**
	 * This value is to prevent the user from making too many pages and overloading
	 * the program. With the possibility to make 'infinite' characters, a bad actor
	 * could in theory try to overload the system.
	 */
	private final static Integer		MAX_ALLOWABLE_PAGES		= 1000;
	private static final String			MISSING_MSG				= "You are missing some required fields. Please ensure that you have filled out the Title, the Story Outline, the Game Mechanics, the Player Experience Goal and the Monetization Strategy.";
	private static final String			VALID_EMAIL_REQUEST		= "Please add a real email!";
	private static final String			SUCESSFULLY_SENT_EMAIL	= "An email was successfully sent to: ";
	private static final String			INBOX					= "Please check your inbox";

	/////////////////////////////////////////////////////
	// **************************************************
	// * The following booleans control what is seen on *
	// * the UI. *
	// **************************************************
	/////////////////////////////////////////////////////
	private List<Boolean>				isPageActive;

	@PostConstruct
	public void init()
	{
		setPageNum(1);
		isPageActive = new ArrayList<Boolean>(FINAL_PAGE);
		for (int i = 0; i < FINAL_PAGE; i++)
		{
			isPageActive.add(i, Boolean.FALSE);
		}
		showPage(FIRST_PAGE);
	}

	public void nextPage()
	{
		/* || Possibly implement a method to check number of total pages */
		if (getPageNumber() <= FINAL_PAGE - 1)
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

	public void graphicUpload(FileUploadEvent event)
	{
		Assert.notNull(event, "The file upload did not occur properly");
		UploadedFile file = event.getFile();
		BufferedImage bf = null;
		try
		{
			bf = ImageIO.read((File) file);
		} catch (IOException e)
		{

		}
	}

	public void build()
	{
		SimplifiedGDDFormat simplifiedGDDFormat = (SimplifiedGDDFormat) this.simplifiedGDDBuilder.build();
		if (simplifiedGDDFormat == null)
		{
			CommonUtils.addPopUpMessage("Result:", MISSING_MSG);
			return;
		}
		String email = getUserEmail();
		if (!emailService.validateEmail(email))
		{
			CommonUtils.addPopUpMessage("Result:", VALID_EMAIL_REQUEST);
			return;
		}

		emailService.send(email, this.simplifiedGDDFileOutBuilder.convertToDownloadFile(simplifiedGDDFormat));

		refresh();

		CommonUtils.addPopUpMessage("Result:", SUCESSFULLY_SENT_EMAIL + email + " " + INBOX);
	}

	public void refresh()
	{
		setPageNum(FIRST_PAGE);
		this.simplifiedGDDBuilder.refresh();
		this.userEmail = "";
		showPage(FIRST_PAGE);
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
		for (int i = 0; i < isPageActive.size(); i++)
		{
			if (isPageActive.get(i))
			{
				return i;
			}
		}
		return FIRST_PAGE;
	}

	public SimplifiedGDDFileOutBuilder getSimplifiedGDDFileOutBuilder()
	{
		return simplifiedGDDFileOutBuilder;
	}

	public void setSimplifiedGDDFileOutBuilder(SimplifiedGDDFileOutBuilder simplifiedGDDFileOutBuilder)
	{
		this.simplifiedGDDFileOutBuilder = simplifiedGDDFileOutBuilder;
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

	public EmailService getEmailService()
	{
		return emailService;
	}

	public void setEmailService(EmailService emailService)
	{
		this.emailService = emailService;
	}

	public void setUserEmail(String email)
	{
		this.userEmail = email;
	}

	public String getUserEmail()
	{
		return this.userEmail;
	}
}
