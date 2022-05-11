package com.vtiger.comcast.genericUtility;

import java.sql.SQLException;

import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.Login;
import com.mysql.cj.jdbc.Driver;

public class BaseClass {
	
	
	


	public static  WebDriver sdriver;


	public static WebDriver driver;

		
   public DataBaseUtility dlib=new DataBaseUtility();
   public FileUtility flib = new FileUtility();
   public WebDriverUtility wlib=new WebDriverUtility();
   public JavaUtility jlib=new JavaUtility();
   public ExceellUtility elib=new ExceellUtility();
    
		
	/*
	 * @BeforeSuite public void bsConf() throws SQLException { dlib.connectDB();
	 * 
	 * }
	 */
   
   
   @BeforeClass(groups = {"Smoketest", "Regressiontest"})
   
   public void bcconf() throws Throwable 
   {
	   
	   //launch the browser
	 String BROWSER = flib.getPropertyKeyValue("browser");
	 String URL = flib.getPropertyKeyValue("url");
	 
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
			System.out.println("launch any browser");
		}
		driver.manage().window().maximize();
		sdriver=driver;
		driver.get(URL);
		
	  }
   
   
   @BeforeMethod(groups = {"Smoketest", "Regressiontest"})
   
   public void bmConf() throws Throwable {
	   
	  Login lp = new Login(driver);
	  lp.loginToApp();
   }
   
	
	
	@AfterMethod(groups = {"Smoketest", "Regressiontest"})
	
	public void amConf()
	{
		
		Home hp = new Home(driver);
		hp.Logout(driver);
		
	}
	
	@AfterClass(groups = {"Smoketest", "Regressiontest"})
	
	public void acConf() 
	{
		
		driver.quit();
	}
	
	/*
	 * @AfterSuite
	 * 
	 * public void asConf() throws SQLException {
	 * 
	 * dlib.closeDB(); }
	 */

}
