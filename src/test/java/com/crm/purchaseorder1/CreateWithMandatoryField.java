package com.crm.purchaseorder1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWithMandatoryField {

	public static void main(String[] args) throws IOException, InterruptedException
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
		
		//launch url and explicit wait
		driver.get(URL);
		String title = driver.getTitle();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
		
		
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		driver.getWindowHandle();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[.='Purchase Order']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("sub1");
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//change parent browser to child browser 1
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
		while(it1.hasNext())
		{
			String cid1 = it1.next();
			driver.switchTo().window(cid1);
			String title1 = driver.getTitle();
			
			if(title1.contains("Vendors&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("ven1");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='ven1']")).click();
		
		
				Set<String> set2 = driver.getWindowHandles();
				Iterator<String> it2 = set2.iterator();
				
				while(it2.hasNext())
				{
					String cid2 = it2.next();
					driver.switchTo().window(cid2);
					String title2 = driver.getTitle();
					
					if(title2.contains("PurchaseOrder&action"))
					{
						break;
					}
				}
				
				// step:2
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
				
				Set<String> set3 = driver.getWindowHandles();
				Iterator<String> it3 = set3.iterator();
				
				while(it3.hasNext())
				{
					String cid3 = it3.next();
					driver.switchTo().window(cid3);
					String title3 = driver.getTitle();
					
					if(title3.contains("PurchaseOrder&action"))
					{
						break;
					}
				}
				
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("con1");
				driver.findElement(By.xpath("//input[@name='search']")).click();
				driver.findElement(By.xpath("//a[.=' con1']")).click();
				Alert ale = driver.switchTo().alert();
				ale.accept();
				
				
				Set<String> set4 = driver.getWindowHandles();
				Iterator<String> it4 = set4.iterator();
				
				while(it3.hasNext())
				{
					String cid4 = it4.next();
					driver.switchTo().window(cid4);
					String title4 = driver.getTitle();
					
					if(title4.contains("PurchaseOrder&action"))
					{
						break;
					}
				}
				
				driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
				driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[1]")).sendKeys("abcdefgh");
				driver.findElement(By.xpath("(//textarea[@class='detailedViewTextBox'])[2]")).sendKeys("xyzyzjkh");
				
				// step 3
				driver.findElement(By.xpath("//img[@title='Products']")).click();
				
				Set<String> set5 = driver.getWindowHandles();
				Iterator<String> it5 = set5.iterator();
				
				while(it5.hasNext())
				{
					String cid5 = it5.next();
					driver.switchTo().window(cid5);
					String title5 = driver.getTitle();
					
					if(title5.contains("Products&action"))
					{
						break;
					}
				}
				
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("pr1");
				driver.findElement(By.xpath("//input[@name='search']")).click();
				driver.findElement(By.xpath("//a[.='pr1']")).click();
				
				Set<String> set6 = driver.getWindowHandles();
				Iterator<String> it6 = set6.iterator();
				
				while(it5.hasNext())
				{
					String cid6 = it6.next();
					driver.switchTo().window(cid6);
					String title6 = driver.getTitle();
					
					if(title6.contains("PurchaseOrder&action"))
					{
						break;
					}
				}
				driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("2");
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
				
	}

}
