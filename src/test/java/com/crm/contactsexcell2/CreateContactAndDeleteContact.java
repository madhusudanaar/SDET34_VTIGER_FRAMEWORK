package com.crm.contactsexcell2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericUtility.ExceellUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateContactAndDeleteContact {

	public static void main(String[] args) throws Throwable
	{
		//Utilities
				WebDriverUtility wlib = new WebDriverUtility();
				FileUtility flib = new FileUtility();
				ExceellUtility elib = new ExceellUtility();
				JavaUtility jlib = new JavaUtility();
				
			
				/*FileInputStream  fis = new FileInputStream("./data/ARM.properties");
				Properties  pobj = new  Properties();
				pobj.load(fis);*/
				
				String URL = flib.getPropertyKeyValue("url");
				String USERNAME = flib.getPropertyKeyValue("username");
				String PASSWORD = flib.getPropertyKeyValue("password");
				String BROWSER = flib.getPropertyKeyValue("browser");
				
				/*Random ram = new Random();
				int ramint = ram.nextInt(1000);*/
				jlib.getRanDomNumber();
				
				//step:Excell
				String data = elib.getDataFromExcel("sheet1", 3, 1);
				/*FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("sheet1");
				Row rw = sh.getRow(1);
				String orgname = rw.getCell(1).getStringCellValue()  +  ramint;
				wb.close();*/
				
				
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
				wlib.waitUntilPageLoad(driver);
			
				driver.get(URL);
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				
				driver.findElement(By.xpath("//a[.='Contacts']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
				
				//step:Verify
				String contactinfo = driver.findElement(By.xpath("//span[.='[ CON18 ] con777  -  Contact Information']")).getText();
				if(contactinfo.contains(data))
				{
					System.out.println("tc is passed");
				}
				else
				{
					System.out.println("tc is fail");
				}
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]")).click();
				
				
			//Mouse hover action
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wlib.mouseOver(driver, ele);
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();

				
				

			}


	}


