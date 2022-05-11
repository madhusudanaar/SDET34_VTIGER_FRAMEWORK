package com.crm.orgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOrganization {

	public static void main(String[] args) throws InterruptedException, IOException
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
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys( PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		Thread.sleep(2000);
		
		 driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		


	}

	
}
