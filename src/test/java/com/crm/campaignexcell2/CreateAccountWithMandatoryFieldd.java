package com.crm.campaignexcell2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.CreateCampaigns;
import com.crm.comcast.pomrepositorylib.CreateLookUpImage;
import com.crm.comcast.pomrepositorylib.CreateNewCampaigns;
import com.crm.comcast.pomrepositorylib.CreateNewProducts;
import com.crm.comcast.pomrepositorylib.CreateProducts;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.genericUtility.ExceellUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

@Listeners(com.vtiger.comcast.genericUtility.ListenerImp.class)
public class CreateAccountWithMandatoryFieldd {
@Test

	public void createcampaign() throws Throwable
	{
		
		//Utilities
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		ExceellUtility elib = new ExceellUtility();
		JavaUtility jlib = new JavaUtility();
				
		/*FileInputStream  fis = new FileInputStream("./data/ARM.properties");
		Properties  pobj = new  Properties();
		pobj.load(fis);*/
		
		
		String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String USERNAME =flib.getPropertyKeyValue("username");
		String PASSWORD =flib.getPropertyKeyValue("password");
		
		
		//Random ram = new Random();
		//int ramint = ram.nextInt(1000);
		jlib.getRanDomNumber();
		
		//step:Excell
		  String data = elib.getDataFromExcel("sheet1", 1, 4);
		/*FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row rw = sh.getRow(1);
		String orgname = rw.getCell(3).getStringCellValue();
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
		
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
		wlib.waitUntilPageLoad(driver);
		
		//Step1: login to application
		driver.get(URL);
		Login lp = new Login(driver);
		lp.lgntoapp(USERNAME, PASSWORD);
		
		      //Navigate to products
				Home hp = new Home(driver);
				hp.getProductsLnk().click();
				
				//Create products
				CreateProducts cp = new CreateProducts(driver);
				cp.getCreateprodImg().click();
				
				//Create new product
				CreateNewProducts cn = new CreateNewProducts(driver);
				cn.CreateProd(data);
				
		
		
			
		//Step2:Navigate to campaigns and move to more
		Home hp1 = new Home(driver);
		hp1.CampaignsLink(driver);
		
		
		//Step3:Create campaigns
		CreateCampaigns cc = new CreateCampaigns(driver);
		cc.getCampaignsPlus().click();
		
		
		
		//Step4:Create new campaigns
		CreateNewCampaigns cnc = new CreateNewCampaigns(driver);
		cnc.getCampaignsnameTextField().sendKeys(data);
		
		//Step5:Create look up image
		CreateLookUpImage lpi = new CreateLookUpImage(driver);
		lpi.getCreateLookUpPlus().click();
		
		//Step6:Search product with child browser
		lpi.getSearchTextField().sendKeys(data);
		
		lpi.getSearchButtonLink().click();
		
		
		
		cnc.getSaveButton().click();
	}
}
