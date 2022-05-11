package com.crm.contactsexcell2;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.ContactsInfo;
import com.crm.comcast.pomrepositorylib.CreateContacts;
import com.crm.comcast.pomrepositorylib.CreateNewContacts;
import com.crm.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.genericUtility.BaseClass;

public class Asserts1 extends BaseClass 
{
	public class CreateAccountWithMandatoryField extends BaseClass
	{
	@Test(groups = "smoke")	
	public void creatCon() throws Throwable
	{
			//Utilities
//			WebDriverUtility wlib = new WebDriverUtility();
//			FileUtility flib = new FileUtility();
//			ExceellUtility elib = new ExceellUtility();
//			JavaUtility jlib = new JavaUtility();
			
		
			/*FileInputStream  fis = new FileInputStream("./data/ARM.properties");
			Properties  pobj = new  Properties();
			pobj.load(fis);*/
			
//			
//			String BROWSER = flib.getPropertyKeyValue("browser");
			String URL = flib.getPropertyKeyValue("url");
//			String USERNAME = flib.getPropertyKeyValue("username");
//			String PASSWORD = flib.getPropertyKeyValue("password");
//			
			
			/*Random ram = new Random();
			int ramint = ram.nextInt(1000);*/
			jlib.getRanDomNumber();
			
			//step:Excell
			String data = elib.getDataFromExcel("sheet1", 1, 1);
			/*FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("sheet1");
			Row rw = sh.getRow(1);
			String orgname = rw.getCell(1).getStringCellValue()  +  ramint;
			wb.close();*/
			
			
//			WebDriver driver=null;
//			if(BROWSER.equals("chrome"))
//			{
//				driver=new ChromeDriver();
//			}
//			else if(BROWSER.equals("firefox"))
//			{
//				driver=new FirefoxDriver();
//			}
//			else
//			{
//				driver=new ChromeDriver();
//			}
			
			/*driver.manage().window().maximize();*/
			wlib.waitUntilPageLoad(driver);
		
			//Step1: login to application
			driver.get(URL);
//			Login lp = new Login(driver);
//			lp.lgntoapp(USERNAME, PASSWORD);
			
			/*driver.get(URL);
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			driver.findElement(By.xpath("//a[.='Contacts']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);*/
			
			
			//Step2:Navigate to contacts
			Home hp = new Home(driver);
			hp.getContactsLnk().click();
			
			//Step3:Create contacts
			CreateContacts cc = new CreateContacts(driver);
			cc.getCreatecontImg().click();
			
			
			//Step4:Create new contacts
			CreateNewContacts cn = new CreateNewContacts(driver);
			cn.CreateCont(data);
			
			
			//step:Verify
			ContactsInfo ci = new ContactsInfo(driver);
			String actualresult = ci.getsuccessfullMsg().getText();
			System.out.println("actualresult");
			boolean result = actualresult.contains(data);
			Assert.assertTrue(result,"cont is not created");
			System.out.println("Contacts is created");
	}			
	}
}
