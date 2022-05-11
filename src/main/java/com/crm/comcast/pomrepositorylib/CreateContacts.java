package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContacts
{
	
	public CreateContacts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath =  "//a[@href='index.php?module=Contacts&action=index']")
	    private WebElement createcontImg;

	public WebElement getCreatecontImg()
	{
		return createcontImg;
	}
	

}	

	
	
	


