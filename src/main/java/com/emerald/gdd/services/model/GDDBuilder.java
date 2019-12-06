package com.emerald.gdd.services.model;

import com.emerald.gdd.common.params.model.GDD;

public interface GDDBuilder
{
	/**
	 * A method to check if the builder has sufficient information to build its object.
	 * @return true if sufficient information has been provided, otherwise false;
	 */
	public boolean hasSufficientCriteria();
	
	/**
	 * Builds and returns the GDD if sufficient criteria has been provided.
	 * @return the GDD, or null if not enough criteria has been provided.
	 */
	public GDD build();
}
