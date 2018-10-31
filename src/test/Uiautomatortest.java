package test;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Uiautomatortest{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
	AndroidDriver<AndroidElement> driver=capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Syntax for android automator: driver.findElementByAndroidUIAutomator("attribute("value")")
		// Common interview question - specific to Appium
		// Have to comment out double quotes within double quotes
		// To identify attribute
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		
		//validate clickable feature for all options - go through properties
		//driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
		// to identify property
		//to pull out a specific index use .get instead of .size
		// should print out as 0, but instead prints out as 13 - posisbly a known issue
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

	private static AndroidDriver<AndroidElement> capabilities() {
		// TODO Auto-generated method stub
		return null;
	}

}
