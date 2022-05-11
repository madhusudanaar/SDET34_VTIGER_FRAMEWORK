package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.ContactsInfo;
import com.crm.comcast.pomrepositorylib.CreateContacts;
import com.crm.comcast.pomrepositorylib.CreateNewContacts;
import com.crm.comcast.pomrepositorylib.CreateNewOrganizations;
import com.crm.comcast.pomrepositorylib.CreateNewProducts;
import com.crm.comcast.pomrepositorylib.CreateOrganizations;
import com.crm.comcast.pomrepositorylib.CreateProducts;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.OrganizationsInfo;
import com.crm.comcast.pomrepositorylib.ProductsInfo;
import com.vtiger.comcast.genericUtility.BaseClass;

public class TestNg extends BaseClass
{

/*Organization*/
	
	  //OrgMultipleData
	
			@Test(dataProvider = "data")
			public void readDatatest(String OrgName)
			{
				
				
				//Step3:Navigate to organization
				Home hp = new Home(driver);
				hp.getOrganizationsLnk().click();
				
				//Step4:Create organization
				CreateOrganizations co = new CreateOrganizations(driver);
				co.getCreateorgImg().click();
				
				//Step5:Create new organization
				CreateNewOrganizations cn = new CreateNewOrganizations(driver);
				cn.CreateOrg(OrgName+jlib.getRanDomNumber());
				
				//Step5:Validation
				OrganizationsInfo oip = new OrganizationsInfo(driver);
				String header = oip.getSuccessfullMsg().getText();
				if(header.contains(OrgName))
				{
					System.out.println(OrgName+" passed");
				}
			}
			
			
			//Step 1: Create data using DataProvider
			@DataProvider(name = "data")
			public Object[][] getData() throws Throwable
			{
				
				Object[][] data = elib.readDataForDataProvider("Sheet2");
				return data;
			}
			
			
/*Contacts*/
			//ContMultipleData
			
			@Test(dataProvider = "data")
			public void readDatatest1(String ContName)
			{
				
				
				//Step3:Navigate to Contacts
				Home hp = new Home(driver);
				hp.getContactsLnk().click();
				
				//Step4:Create Contacts
				CreateContacts cc = new CreateContacts(driver);
				cc.getCreatecontImg().click();
				
				//Step5:Create new Contacts
				CreateNewContacts cn1 = new CreateNewContacts(driver);
				cn1.CreateCont(ContName+jlib.getRanDomNumber());
				
				//Step5:Validation
				ContactsInfo cip = new ContactsInfo(driver);
				String header = cip.getsuccessfullMsg().getText();
				if(header.contains(ContName))
				{
					System.out.println(ContName+" passed");
				}
			}
			
			
			//Step 1: Create data using DataProvider
			@DataProvider(name = "data")
			public Object[][] getData1() throws Throwable
			{
				
				Object[][] data = elib.readDataForDataProvider("Sheet2");
				return data;
			}
			
			
			
/*Products*/			
			//ProdMultipleData
			
			@Test(dataProvider = "data")
			public void readDatatest2(String ProdName)
			{
				
				
				//Step3:Navigate to Products
				Home hp = new Home(driver);
				hp.getProductsLnk().click();
				
				//Step4:Create Products
				CreateProducts cp = new CreateProducts(driver);
				cp.getCreateprodImg().click();
				
				//Step5:Create new Products
				CreateNewProducts cn = new CreateNewProducts(driver);;
				cn.CreateProd(ProdName+jlib.getRanDomNumber());
				
				//Step5:Validation
				ProductsInfo pip = new ProductsInfo(driver);
				String header = pip.getsuccessfullMsg().getText();
				if(header.contains(ProdName))
				{
					System.out.println(ProdName+" passed");
				}
			}
			
			
			//Step 1: Create data using DataProvider
			@DataProvider(name = "data")
			public Object[][] getData2() throws Throwable
			{
				
				Object[][] data = elib.readDataForDataProvider("Sheet2");
				return data;
			}
			
			
			
			
			
}
