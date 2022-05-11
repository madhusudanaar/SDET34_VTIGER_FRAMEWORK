package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaigns 
{
	public CreateCampaigns(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	 private WebElement CampaignsPlus;

	public WebElement getCampaignsPlus() {
		return CampaignsPlus;
	}
	
	public void CreateCampaigns(String data)
	{
		
		CampaignsPlus.click();
		
		
	}
}
