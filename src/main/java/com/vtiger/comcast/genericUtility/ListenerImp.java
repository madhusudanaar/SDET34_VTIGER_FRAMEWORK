package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener
{
public void onTestFailure(ITestResult result)
{
	JavaUtility jlib = new JavaUtility();
	String testName = result.getMethod().getMethodName();
	EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
	File srcfile = edriver.getScreenshotAs(OutputType.FILE);
	File dstfile = new File("./screenshot/"+testName+"_"+jlib.getSystemDateAndTime()+".png");
	
	try {
		FileUtils.copyFile(srcfile, dstfile);
	}
	catch(IOException e) {
		
	}
}
}
