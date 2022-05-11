package com.crm.productexcell2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.pomrepositorylib.CreateNewProducts;
import com.crm.comcast.pomrepositorylib.CreateProducts;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;
import com.crm.comcast.pomrepositorylib.ProductsInfo;
import com.vtiger.comcast.genericUtility.ExceellUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreatProductWithMandatoryField {

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
		
		
		String BROWSER = flib.getPropertyKeyValue ("browser");
		String URL = flib.getPropertyKeyValue("url");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD =  flib.getPropertyKeyValue("password");
		
		
		
		/*Random ram = new Random();
		int ramint = ram.nextInt(1000);*/
		jlib.getRanDomNumber();
		
		//step:Excell
		String data = elib.getDataFromExcel("sheet1", 1, 3);
		 /*FileInputStream  fis1 = new FileInputStream("./data/organi1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row rw = sh.getRow(1);
		String orgname = rw.getCell(2).getStringCellValue()  +  ramint;
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
		
		/*driver.manage().window().maximize();*/
		wlib.waitUntilPageLoad(driver);
		
		//Step1:login
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
		
		/*driver.get(URL);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(data);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(2000);*/
		
		//step:Verify
		ProductsInfo pi=new ProductsInfo(driver);
		String actualresult = pi.getsuccessfullMsg().getText();
		if(actualresult.contains(data))
		{
			System.out.println("testcase is passed");
		}
		else
		{
			System.out.println("testcase is fail");
		}
		
		/*Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOver(driver, ele);
		/*Actions  act = new  Actions(driver);
		act.moveToElement(ele).perform();*/
		/*driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		
		/*logout*/
		hp.Logout(driver);
		driver.close();

		
		

		

	}

}
