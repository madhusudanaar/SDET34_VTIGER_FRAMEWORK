package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaigns 
{
	public CreateNewCampaigns (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='campaignname']")
	 private WebElement CampaignsnameTextField;
	
	
	@FindBy(xpath = "//input[@class='crmButton small save']")
	 private WebElement SaveButton;


	public WebElement getCampaignsnameTextField() {
		return CampaignsnameTextField;
	}

    public WebElement getSaveButton() {
		return SaveButton;
	}
	
    public void CreateCampaigns(String data)
	{
		CampaignsnameTextField.sendKeys(data);
		SaveButton.click();
		
	}

	

}
