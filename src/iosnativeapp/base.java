package iosnativeapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	static IOSDriver<IOSElement>driver;

	public static IOSDriver<IOSElement> capabilities() throws MalformedURLException {
	
		
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "NB");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		d.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Desktop/MyTasks.app");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;}
		
		 
		
	}
		

	



