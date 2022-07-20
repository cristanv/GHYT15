package com.crm.GHYT15.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Cristan
 *
 */

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */
    public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream("./data/commondata.properties.txt");
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		return value;
    	
    }

	

}
