package com.emerald.gdd.services.model;

import com.emerald.gdd.common.params.model.Singleton;

/**
 * 
 * A general interface for retrieving, caching, and reading messages from the DB
 * to be displayed to the UI.
 * 
 * @author C4X2
 * @param <T>
 *
 */
public interface MessageManager extends Singleton<MessageManager>
{
	/**
	 * Get message from the given key. This method will search the local cache
	 * first, then the database. If the message is not found in either context it
	 * will return null.
	 * 
	 * @param key the key for the message.
	 * @return the message as a String object, null otherwise.
	 */
	public String getMessage(String key);

	/**
	 * Get message from the given key. This method will search the local cache
	 * first, then the database. If the message is not found in either context it
	 * will return the default message.
	 * 
	 * @param key key the key for the message.
	 * @param defaultMessage a default message to return in case that the message is
	 *        not found
	 * @return the message as a String object, defaultMessage otherwise.
	 */
	public String getMessage(String key, String defaultMessage);

	/**
	 * Get message from the given key. This method will search the given URI
	 * resource first for the message, then the local cache first, then the
	 * database. If the message is not found in either context it will return the
	 * default message.
	 * 
	 * @param key the key for the message.
	 * @param defaultMessage a default message to return in case that the message is
	 *        not found
	 * @param resource a URI to path to search for the message linked with the given
	 *        key.
	 * @return the message as a String object, defaultMessage otherwise.
	 */
	public String getMessage(String key, String defaultMessage, String resource);

	/**
	 * Add a message to the MESSAGE_REGISTRY through w/o having to run SQL scripts.
	 * 
	 * @param key the key to be associated with the message.
	 * @param message the message
	 * @return true if the message was written successfully, false otherwise.
	 */
	public boolean addMessage(String key, String message);
}
