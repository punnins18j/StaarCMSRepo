package com.pabb.staarcms.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Poornima 
 * 
 * This class is used to store all the Generic methods related to Property Files
 */
public class FileUtility {

	/**
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 * 
	 * This Method is used to get the data from Properties file
	 */
	public String getDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
}
