package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizations 
{
	public CreateOrganizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//img[@alt='Create Organization...']")
	    private WebElement createorgImg;

	public WebElement getCreateorgImg() {
		return createorgImg;
	}

	
	 
		 
}
