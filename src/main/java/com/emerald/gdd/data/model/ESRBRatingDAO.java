package com.emerald.gdd.data.model;

import java.util.List;

import com.emerald.gdd.common.params.impl.ESRBRating;

public interface ESRBRatingDAO
{
	public List<ESRBRating> selectAll();
	
	public int insert(ESRBRating record);
	
	public ESRBRating selectById(String id);
}
