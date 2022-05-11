package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProducts 
{

		public  CreateProducts(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		 @FindBy(xpath = "//img[@alt='Create Product...']")
		    private WebElement createprodImg;

		public WebElement getCreateprodImg() {
			return createprodImg;
		}

		
		

}
