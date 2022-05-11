package com.crm.vendoursexcell2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateAccountWithMandatoryField {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		FileInputStream  fis = new FileInputStream("./data/ARM.properties");
		Properties  pobj = new  Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
		Random ram = new Random();
		int ramint = ram.nextInt(1000);
		
		//step:Excell
		FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row rw = sh.getRow(1);
		String orgname = rw.getCell(3).getStringCellValue()  +  ramint;
		wb.close();
		
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//a[@href='javascript:;'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[.='Vendors']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(2000);
		
		//step:Verify
		String actorgnameinfo = driver.findElement(By.xpath("//span[.='[ ACC19 ] org3 -  Organization Information']")).getText();
		if(actorgnameinfo.contains(orgname))
		{
			System.out.println("tc is passed");
		}
		else
		{
			System.out.println("tc is fail");
		}
		Thread.sleep(2000);
		
	
		Actions  act1 = new  Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		
		

		

	}

}
