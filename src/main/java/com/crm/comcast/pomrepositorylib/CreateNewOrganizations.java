package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizations 
{
	public CreateNewOrganizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//input[@name='accountname']")
	    private WebElement orgName;
	 
	 @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	    private WebElement saveBtn;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateOrg(String data) 
	{
		orgName.sendKeys(data);
		saveBtn.click();
		
	}
	 
	 

	


	
	 
}
