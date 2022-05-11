package com.crm.practice;

import org.testng.annotations.Test;

public class DependencyPriority
{
	@Test public void test1()
	{
		int Array[] = {1,3};
		System.out.println(Array[5]);
	}
	
	@Test (priority = 1, dependsOnMethods = "test1")
	public void test2()
	{
		System.out.println("========2nd test========");
	}
	
	@Test(priority = 2, dependsOnMethods = "test2")
	public void test3()
	{
		System.out.println("=========3rd test========");
	}
}
