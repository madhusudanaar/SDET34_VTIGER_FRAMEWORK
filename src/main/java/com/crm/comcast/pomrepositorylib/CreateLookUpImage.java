package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateLookUpImage extends WebDriverUtility
{
	WebDriver driver;
	public CreateLookUpImage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Select']")
	 private WebElement CreateLookUpPlus;
	
	@FindBy(xpath = "//input[@name='search_txt']")
	 private WebElement searchTextField;
	
	@FindBy(xpath = "//input[@name='search']")
	 private WebElement searchButtonLink;
	
	private CharSequence data;
	

	public WebElement getCreateLookUpPlus() {
		return CreateLookUpPlus;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
    public WebElement getSearchButtonLink() {
		return searchButtonLink;
	}
    
    

	public void CreateLookUpImage() 
	{
		CreateLookUpPlus.click();
	}
	
	
	public void CreatSearchTextField()
	{
		switchToWindow(driver,"Products&action");

		searchTextField.sendKeys(data);
		searchButtonLink.click();
		driver.findElement(By.xpath("//a[.='"+data+"']")).click();
	}
	
	
	
	
	
	
	
}
