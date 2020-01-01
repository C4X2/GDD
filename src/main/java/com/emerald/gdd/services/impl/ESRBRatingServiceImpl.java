package com.emerald.gdd.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emerald.gdd.common.params.impl.ESRBRating;
import com.emerald.gdd.data.model.ESRBRatingDAO;
import com.emerald.gdd.services.model.ESRBRatingService;

@Component
public class ESRBRatingServiceImpl implements ESRBRatingService
{
	@Autowired
	private ESRBRatingDAO eSRBRatingDAO;

	@Override
	public List<ESRBRating> getAllESRBRatings()
	{
		List<ESRBRating> rtrnList = new ArrayList<ESRBRating>();
		rtrnList.addAll(new ArrayList<ESRBRating>(eSRBRatingDAO.selectAll()));
		return rtrnList;
	}

}
