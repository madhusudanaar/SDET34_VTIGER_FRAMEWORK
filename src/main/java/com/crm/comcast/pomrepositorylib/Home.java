package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class Home extends WebDriverUtility
{
	WebDriver driver;  //Global driver variable
	public Home(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(linkText ="Organizations")
	    private WebElement OrganizationsLnk;
		
	    @FindBy(linkText= "Contacts")
	    private WebElement ContactsLnk;
	    
	    @FindBy(linkText="Products")
	    private WebElement ProductsLnk;
	    
	    
	    @FindBy(xpath ="//img[@src='themes/softed/images/menuDnArrow.gif']")
	    private WebElement MoreOptionLnk;
	    
	    @FindBy(xpath ="//a[.='Campaigns']")
	    private WebElement CampaignsOptionLnk;
	    
	    @FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	    private WebElement administratorTag;
	    
	     @FindBy(xpath ="//a[.='Sign Out']")
	    private WebElement signoutLnk;
	     
	     
		public WebDriver getDriver() {
			return driver;
		}
        
		public WebElement getOrganizationsLnk() {
			return OrganizationsLnk;
		}


		public WebElement getContactsLnk() {
			return ContactsLnk;
		}


		public WebElement getProductsLnk() {
			return ProductsLnk;
		}


		public WebElement getMoreOptionLnk() {
			return MoreOptionLnk;
		}
		
		public WebElement getCampaignsOptionLnk() {
			return CampaignsOptionLnk;
		}


		public WebElement getAdministratorTag() {
			return administratorTag;
		}


		public WebElement getSignoutLnk() {
			return signoutLnk;
		}
		
		/**
		 * mouse over to more option
		 */
	    public void MoveToMore(WebDriver driver,WebElement element)
	    {
	        mouseOver(driver,MoreOptionLnk);
	    	
			
		}

		public void MoreCampaignLnk(WebDriver driver)
		{
			CampaignsOptionLnk.click();	
		}

		public void Logout(WebDriver driver)
		{
			mouseOver(driver, administratorTag);
			signoutLnk.click();
		}
		
		public void CampaignsLink(WebDriver driver)
		{
			MoveToMore(driver, MoreOptionLnk);
			CampaignsOptionLnk.click();

		}
			
} 
	     

	     
	    

	    

