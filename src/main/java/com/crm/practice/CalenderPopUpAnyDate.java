package com.crm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUpAnyDate {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[.='From']")).click();
		
		WebElement src = driver.findElement(By.xpath("//input[@placeholder='From']"));
		WebElement dst = driver.findElement(By.xpath("//input[@placeholder='To']"));
		
		src.sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		
		dst.sendKeys("Chennai");
		driver.findElement(By.xpath("Chennai, India"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Apr 20 2022']")).click();
		
		
		

	}

}
