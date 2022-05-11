package com.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditContact {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("./data/testdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
	    String USERNAME = pobj.getProperty("username");
	    String PASSWORD = pobj.getProperty("password");
	   //String BROWSER = pobj.getProperty("browser");
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("(//a[.='edit'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("SDET3");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		

	}

}
