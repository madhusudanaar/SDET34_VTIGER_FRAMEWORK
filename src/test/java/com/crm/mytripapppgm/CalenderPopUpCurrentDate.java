package com.crm.mytripapppgm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUpCurrentDate {

	public static void main(String[] args) throws InterruptedException
	{
		
		Date d = new Date();
		String[] d1 = d.toString().split(" ");
		 String day = d1[0];
		 String month = d1[1];
		 String date = d1[2];
		 String year = d1[5];
		 
		 String traveldate = day+"  "+month+"  "+date+"  "+year;
		 System.out.println(traveldate);
		 
		 WebDriverManager.firefoxdriver().setup();
			
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.makemytrip.com");
			
			Actions act=new Actions(driver);
			act.moveByOffset(10, 10).click().perform();
			
			
			  WebElement ele = driver.findElement(By.xpath("//span[.='From']"));
				 ele.sendKeys("Bengalore");
			 driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
			 Thread.sleep(2000);
			 
			 
		
			WebElement ele1 = driver.findElement(By.xpath("//span[.='To']"));
			ele1.sendKeys("Delhi");
			driver.findElement(By.xpath("//p[.='New Delhi, India']")).click();
			 
			 
			 
			 driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
			 driver.findElement(By.xpath("//div[@aria-label='Fri Apr 29 2022']")).click();
			 
			 driver.quit();
			 
			 
			 
			
			
		

	}

}
