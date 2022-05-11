package com.crm.orgTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleExcel {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/testdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String URL = pobj.getProperty("url");
	    String USERNAME = pobj.getProperty("username");
	    String PASSWORD = pobj.getProperty("password");
	   //String BROWSER = pobj.getProperty("browser");
		
		
		  FileInputStream fis1=new FileInputStream("./data/org.xlsx"); 
		  Workbook book =WorkbookFactory.create(fis1);
		  Sheet sh = book.getSheet("sheet1"); 
		  Row row =sh.getRow(0); 
		  String name = row.getCell(0).getStringCellValue();
		  book.close();
		 
	    
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys( PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
	    WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}

}
