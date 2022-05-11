package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.pomrepositorylib.ContactsInfo;
import com.crm.comcast.pomrepositorylib.CreateContacts;
import com.crm.comcast.pomrepositorylib.CreateNewContacts;
import com.crm.comcast.pomrepositorylib.CreateNewOrganizations;
import com.crm.comcast.pomrepositorylib.CreateOrganizations;
import com.crm.comcast.pomrepositorylib.Home;
import com.crm.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.genericUtility.BaseClass;

public class ReadDataCreateContacts extends BaseClass
{
	//ContMultipleData
	
			@Test(dataProvider = "data",groups = "smoke")
			public void readDatatest(String ContName)
			{
				
				
				//Step3:Navigate to Contacts
				Home hp = new Home(driver);
				hp.getContactsLnk().click();
				
				//Step4:Create Contacts
				CreateContacts cc = new CreateContacts(driver);
				cc.getCreatecontImg().click();
				
				//Step5:Create new Contacts
				CreateNewContacts cn = new CreateNewContacts(driver);
				cn.CreateCont(ContName+jlib.getRanDomNumber());
				
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
			public Object[][] getData() throws Throwable
			{
				
				Object[][] data = elib.readDataForDataProvider("Sheet2");
				return data;
			}
			
			
			
			
}
