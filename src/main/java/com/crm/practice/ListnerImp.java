package com.crm.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
@Listeners(com.vtiger.comcast.genericUtility.ListenerImp.class)

public class ListnerImp extends BaseClass
{
	@Test
	public void screnshot()
	{
		System.out.println("-----start-------");
		Assert.assertEquals(false, true);
		System.out.println("------end------");
	}
	

}
