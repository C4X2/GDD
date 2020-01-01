package com.emerald.gdd.beans.model;

import java.util.List;
import javax.faces.model.SelectItem;

/**
 * This bean handles a clients respondence given from the contact us page.
 * 
 * @author C4X2
 * @version 1.0
 *
 */
public interface CompanyContactBean extends BaseBean
{
	/**
	 * 
	 * @return a list of select-able options.
	 */
	public List<SelectItem> getHelpList();

	/**
	 * Submits the contact record. If the contact record is not valid it will not be
	 * saved.
	 */
	public void submit();

	/**
	 * Reset the ContactRecord in context.
	 */
	public void resetContactRecord();
}
