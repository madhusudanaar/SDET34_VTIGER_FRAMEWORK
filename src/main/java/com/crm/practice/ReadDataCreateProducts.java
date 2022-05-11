package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.ContactsInfo;
import com.crm.comcast.pomrepositorylib.CreateContacts;
import com.crm.comcast.pomrepositorylib.CreateNewContacts;
import com.crm.comcast.pomrepositorylib.CreateNewProducts;
import com.crm.comcast.pomrepositorylib.CreateProducts;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.ProductsInfo;
import com.vtiger.comcast.genericUtility.BaseClass;

public class ReadDataCreateProducts extends BaseClass
{
	//ProdMultipleData
	
	@Test(dataProvider = "data",groups = "smoke")
	public void readDatatest(String ProdName)
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
	  public Object[][] getData() throws Throwable
	 {
		
		Object[][] data = elib.readDataForDataProvider("Sheet2");
		return data;
	 }
	
	
	
}
