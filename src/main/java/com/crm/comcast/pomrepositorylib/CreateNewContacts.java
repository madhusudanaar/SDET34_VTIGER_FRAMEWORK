package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContacts
{
	public CreateNewContacts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
    private WebElement createlnk;
	
	
	 public WebElement getCreatelnk() {
		return createlnk;
	}

	@FindBy(xpath = "//input[@name='lastname']")
	    private WebElement createnewcont;
	 
	 @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	    private WebElement saveBtn;

	public WebElement getCreatenewcont() {
		return createnewcont;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateCont(String data)
	{
		createlnk.click();
		createnewcont.sendKeys(data);
		saveBtn.click();
		
	}

	
	 

	

}
