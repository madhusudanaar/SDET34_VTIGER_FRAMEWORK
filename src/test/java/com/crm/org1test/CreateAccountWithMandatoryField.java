package com.crm.org1test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageSetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountWithMandatoryField {

	public static void main(String[] args) throws Throwable
	{
		
		FileInputStream  fis = new FileInputStream("./data/ARM.properties");
		Properties  pobj = new  Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		//String BROWSER = pobj.getProperty("browser");
		
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("org3");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
	
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions  act = new  Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		

	}

	
		
	}


