package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProducts
{
	

	public CreateNewProducts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='productname']")
	    private WebElement createnewprod;
	 
	 @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	    private WebElement saveBtn;
	 


	public WebElement getCreatenewprod() {
		return createnewprod;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void CreateProd(String data)
	{
		
		createnewprod.sendKeys(data);
		saveBtn.click();
		
	}
	 
	 

} 



