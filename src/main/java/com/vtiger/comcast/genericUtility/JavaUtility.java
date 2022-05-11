package com.vtiger.comcast.genericUtility;

import java.util.Random;

/**
 * 
 * @author madhusudana
 * 
 */

public class JavaUtility {
	
	/**
	 * it is used to generate a random number
	 * @return  int data
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intrandom = random.nextInt(10000);
		return intrandom;
		
	}
	
	/**
	 * used to get system date and time in IST format
	 * @return
	 * 
	 */
	public String getSystemDateAndTime() {
		 java.util.Date date = new java.util.Date();
		return date.toString();
	}
	
	/**
	 * used to get system date and YYYY-MM-DD format
	 * @return
	 * 
	 */
	public String getSystemDateWithFormat() {
		 java.util.Date date = new java.util.Date();
			String dateAndTime = date.toString();
		
			    String YYYY = dateAndTime.split(" ")[5];
			   String DD = dateAndTime.split(" ")[2];
			   int MM = date.getMonth()+1;
			   
			    String finalFormat = YYYY+"-"+MM+"-"+DD;
			    return finalFormat;
			    
			   }
	public String getSystemDate() {
		 java.util.Date date = new java.util.Date();
		String dt = date.toString();
		return dt.replace(" ", "_").replace(":", "_");
	}
}
