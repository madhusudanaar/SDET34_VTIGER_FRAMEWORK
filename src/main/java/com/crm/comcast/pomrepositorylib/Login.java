package com.crm.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.FileUtility;

public class Login extends FileUtility
{
	WebDriver driver = null;


public Login(WebDriver driver)
{
   PageFactory.initElements(driver, this);	
}

@FindBy(name="user_name")
private WebElement username;

@FindBy(name="user_password")
private WebElement password;

@FindBy(xpath = "//input[@id='submitButton']")
private WebElement loginbutton;


public WebDriver getDriver() {
	return driver;
}

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin() {
	return loginbutton;
}

/*
 * login to application by passing usernam and password
 */
// public void loginToApp(String usernam1 , String password1,WebDriver driver) 
// {
//	username.sendKeys(usernam1); 
//	password.sendKeys(password1);
//	loginbutton.click();
	

 public void loginToApp() throws Throwable 
 {
	 username.sendKeys(getPropertyKeyValue("username"));
	 password.sendKeys(getPropertyKeyValue("password"));
	 loginbutton.click();
	
}
 public void lgntoapp(String un,String pwd)
 {
	 username.sendKeys(un);
	 password.sendKeys(pwd);
	 loginbutton.click();
	 
 }


}








