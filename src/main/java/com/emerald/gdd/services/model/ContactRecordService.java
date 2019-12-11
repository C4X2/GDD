package com.emerald.gdd.services.model;

import com.emerald.gdd.common.params.impl.ContactRecord;

public interface ContactRecordService
{
	/**
	 * Validates and saves the person contact record.
	 * 
	 * @param record the record to be saved
	 * @return true if both the validation succeed and the record is saved to the
	 *         database, false otherwise.
	 */
	public boolean validateAndSaveContactRecord(ContactRecord record);
}
