package com.crm.organiexcell2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.CreateNewOrganizations;
import com.crm.comcast.pomrepositorylib.CreateOrganizations;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;
import com.crm.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExceellUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateAccountWithMandatoryField extends BaseClass {

	private static String PASSWORD;
	private static String USERNAME;
	@Test
	public void testName() throws Exception {
		
	}
	public static void createorg() throws Throwable
	{
	
		// Create a objects for Utilities
	    WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		ExceellUtility elib = new ExceellUtility();
		JavaUtility jlib = new JavaUtility();
		
		
		/*FileInputStream  fis = new FileInputStream("./data/ARM.properties");
		Properties  pobj = new  Properties();
		pobj.load(fis);*/
		
		
		String URL = flib.getPropertyKeyValue("url");
		/*String BROWSER = flib.getPropertyKeyValue("browser");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");*/
		
		
		
		//Random number
		/*Random ram = new Random();
		int ramint = ram.nextInt(1000);*/
		/*jlib.getRanDomNumber();*/
		int randomnum = jlib.getRanDomNumber();
		
		
		//step:Read the data from Excell
		String data = elib.getDataFromExcel("sheet1", 1, 2) +  randomnum ;
		
		/*FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row rw = sh.getRow(1);
		String orgname = rw.getCell(0).getStringCellValue()  +  ramint;
		wb.close();*/
		
		
		/*WebDriver driver=null;
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
		}*/
		
		/*driver.manage().window().maximize();*/
		wlib.waitUntilPageLoad(driver);
		
		
		//Step1:Login to application
		driver.get(URL);
		Login lp = new Login(driver);
		lp.lgntoapp(USERNAME, PASSWORD);
		/*wlib.waitUntilPageLoad(driver);*/
		
		//Step2:Navigate to organization
		Home hp = new Home(driver);
		hp.getOrganizationsLnk().click();
		
		//Step3:Create organization
		CreateOrganizations co = new CreateOrganizations(driver);
		co.getCreateorgImg().click();
		
		//Step4:Create new organization
		CreateNewOrganizations cno = new CreateNewOrganizations(driver);
		cno.CreateOrg(data);
		
		//Step5:Org info
		OrganizationsInfo oi = new OrganizationsInfo(driver);
	    String actualresult = oi.getSuccessfullMsg().getText();
	    System.out.println("actualresult");
	    boolean result = actualresult.contains(data);
		Assert.assertTrue(result);
		System.out.println("Organization is created");
	      
	      
	    /* if(actualresult.contains(data))
	     {
	    	System.out.println("test case ia passed"); 
	     }
	     else
	     {
	    	 System.out.println("test case is fail");
	     }*/
	     
	     
	     
	      
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		