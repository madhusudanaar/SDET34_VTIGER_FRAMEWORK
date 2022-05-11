package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.CreateNewOrganizations;
import com.crm.comcast.pomrepositorylib.CreateOrganizations;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.genericUtility.BaseClass;

public class ReadDataFromExcelUsingDataProvidderTest extends BaseClass
{
	//OrgMultipleData
		
		@Test(dataProvider = "data",groups = "smoke")
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
		
		
		
		

		
}
