package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfo
{
	public  OrganizationsInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//span[@class='dvHeaderText']")
	    private WebElement successfullMsg;

	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	 
	
		 
	 

}
