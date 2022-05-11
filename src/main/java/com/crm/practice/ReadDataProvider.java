package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.CreateNewOrganizations;
import com.crm.comcast.pomrepositorylib.CreateOrganizations;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.genericUtility.BaseClass;

public class ReadDataProvider extends BaseClass
{
	@Test(dataProvider = "data")
	public void ReadData(String data)
	{
		
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
     if(actualresult.contains(data))
     {
    	System.out.println("test case ia passed"); 
     }
     else
     {
    	 System.out.println("test case is fail");
     }
	}
     
	@DataProvider(name = "provider")
	public Object[][] provider() throws Throwable
	{
		Object[][] provider = elib.readDataForDataProvider("Sheet1");
		return provider;
	}

}
