package com.emerald.gdd.services.model;

import java.io.File;

import org.primefaces.model.StreamedContent;

import com.emerald.gdd.common.params.impl.SimplifiedGDDFormat;

public interface SimplifiedGDDFileOutBuilder
{
	public static final String	DEFAULT_PATH			= "C:\\DEVELOPMENT\\TEMP";
	public static final String	SYSTEM_FILE_SEPERATOR	= File.separator;
	public static final String	DEFAULT_FILE_TYPE		= ".txt";

	/**
	 * Sets the output path of the file for this file builder. If this filed is not
	 * set before the {@link #convertToDownloadFile(SimplifiedGDDFormat)} is used,
	 * the default file path is used.
	 * 
	 * @param path the output path
	 */
	public void setPath(String path);

	/**
	 * Returns the path that will be the destination of the output file.
	 * 
	 * @return the path that will be the destination of the output file.
	 */
	public String getPath();

	/**
	 * 
	 * @param input a SimplifiedGDDFormat
	 * @return a file formatted as a GDD.
	 */
	public File convertToDownloadFile(SimplifiedGDDFormat input);
	
	public StreamedContent toStreamedContent(File file);
}
