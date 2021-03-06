package com.emerald.gdd.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.emerald.gdd.common.constants.StandardTextString;
import com.emerald.gdd.common.params.impl.SimplifiedGDDFormat;
import com.emerald.gdd.services.model.SimplifiedGDDFileOutBuilder;
@Component
public class SimplifiedGDDFileOutBuilderImpl implements SimplifiedGDDFileOutBuilder, StandardTextString
{
	private String	path;
	private String	fileType;

	@Override
	public void setPath(String path)
	{
		this.path = path;
	}

	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}

	@Override
	public File convertToDownloadFile(SimplifiedGDDFormat input)
	{
		if (input == null)
		{
			return null;
		}
		PrintWriter pw = null;
		try
		{
			File rtrnVal = new File(
					getPath() + SYSTEM_FILE_SEPERATOR + input.getCompanyInfo() + " - GDD" + getFileType());
			rtrnVal.createNewFile();
			if (rtrnVal.canWrite())
			{
				pw = new PrintWriter(rtrnVal);
				// Start Writing GDD
				pw.write(input.getTitle());
				pw.write(StandardTextString.NEW_LINE);
				pw.write(StandardTextString.NEW_LINE);
				pw.write(input.getContactInfo() + "    "  + input.getCompanyInfo());
				pw.write(StandardTextString.NEW_LINE);
				// End Writing GDD
			}

			return rtrnVal;
		} catch (Exception e)
		{
		} finally
		{
			if (pw != null)
			{
				pw.flush();
				pw.close();
			}
		}
		return null;
	}

	private String getFileType()
	{
		if (StringUtils.hasText(this.fileType))
		{
			return this.fileType;
		}
		return DEFAULT_FILE_TYPE;
	}

	@Override
	public String getPath()
	{
		if (StringUtils.hasText(this.path))
		{
			return this.path;
		}
		return DEFAULT_PATH;
	}

	@Override
	public StreamedContent toStreamedContent(File file)
	{
		StreamedContent dFile = null;
		try
		{
			dFile = new DefaultStreamedContent(new FileInputStream(file), getFileType());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return dFile;
	}

}
