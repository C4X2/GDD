package com.emerald.gdd.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.common.params.impl.GamePlatform;
import com.emerald.gdd.data.impl.ESRBRatingDAOImpl;
import com.emerald.gdd.data.model.ESRBRatingDAO;
import com.emerald.gdd.services.model.ESRBRatingService;

public class ESRBRatingServiceImpl implements ESRBRatingService
{
	private ESRBRatingDAO eSRBRatingDAO;
	
	public ESRBRatingServiceImpl()
	{
		eSRBRatingDAO = new ESRBRatingDAOImpl();
	}
	
	@Override
	public List<ESRBRating> getAllESRBRatings()
	{
		List<ESRBRating> rtrnList = new ArrayList<ESRBRating> ();
		rtrnList.addAll(new ArrayList<ESRBRating>(eSRBRatingDAO.selectAll()));
		return rtrnList;
	}

}
