package com.crm.opportunityexcell2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateMandatoryField {

	public static void main(String[] args) throws IOException 
	{
		WebDriverUtility wlib = new WebDriverUtility();
		
		
		FileInputStream  fis = new FileInputStream("./data/ARM.properties");
		Properties  pobj = new  Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
		//Random ram = new Random();
		//int ramint = ram.nextInt(1000);
		
		//step:Excell1
		FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row rw = sh.getRow(1);
		String orgname = rw.getCell(0).getStringCellValue();
		wb.close();
		
		//step:Excell2
		FileInputStream  fis2 = new FileInputStream("./data/organi1.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis2);
		Sheet sh1 = wb1.getSheet("sheet1");
		Row rw1 = sh1.getRow(1);
		String orgname1 = rw1.getCell(5).getStringCellValue();
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
		wlib.waitUntilPageLoad( driver);
	
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(orgname1);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//child browser
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
		while(it1.hasNext())
		{
			String cid1 = it1.next();
			driver.switchTo().window(cid1);
			String title1 = driver.getTitle();
			
			if(title1.contains("Accounts&action"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='org1']")).click();
		
		wlib.switchToWindow(driver, orgname1);
		
		//Set<String> set2 = driver.getWindowHandles();
		//Iterator<String> it2 = set2.iterator();	
		//while(it2.hasNext())
		//{
			//String cid2 = it2.next();
			//driver.switchTo().window(cid2);
			//String title2 = driver.getTitle();
			
		//	if(title2.contains("Potentials&action"))
			//{
				//break;
			//}
		//}
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		

	}

}
