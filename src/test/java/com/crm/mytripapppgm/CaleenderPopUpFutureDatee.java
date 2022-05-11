package com.crm.mytripapppgm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaleenderPopUpFutureDatee {

	public static void main(String[] args) throws InterruptedException
	{

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
		 for(;;)
		 {
			 try
			 {
				 driver.findElement(By.xpath("//div[@aria-label='Fri Jul 29 2022']")).click();
				 break;
			 }
			 catch (Exception e)
			 {
				 driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		 }
		 
		       driver.quit();

	}

}
