package msbuddy;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login {
	static IOSDriver<IOSElement>driver;
	final String taskName = "Task #1";
	final String descriptionText = "Testing Description Display for Task #1";
	

	@BeforeTest
	public static IOSDriver<IOSElement> capabilities() throws MalformedURLException {
	
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "Test iPhone");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		d.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Desktop/MSBuddy.app");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;}
			
	
	@BeforeMethod
	public void sleep() throws InterruptedException{
		Thread.sleep(1000);
	}
	
	/*@AfterTest
	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}*/

	
	@Test (priority = 1, enabled = true)
	public void TestLoginScreenDisplay() {
	
		
		//Assert.assertTrue(driver.findElementByAccessibilityId("Your privacy is important to us. We will not share your personal information.").isEnabled());
		//Assert.assertTrue(driver.findElementByAccessibilityId("Already a member?").isEnabled());
		
		Assert.assertTrue(driver.findElementByAccessibilityId("onboarding.sign-in-btn").isEnabled());
		driver.findElementByAccessibilityId("onboarding.sign-in-btn").click();
				
		/* Future Tests:
		 *  Accessibility ID's needed for:
		 *  Title
		 *  Text
		 *  Image
		 *  Let's Go
		 *  Terms and Conditions Link
		 *  Privacy Link
		 */ 
		 	
		}
	@Test (priority = 2, enabled = true)
	public void TestLoginEmail() {
		Assert.assertTrue(driver.findElementByName("sign-in.email-txt-fld").isEnabled());
		driver.findElementByName("sign-in.email-txt-fld").sendKeys("user2-1540924531@qahlm.com");
		
		Assert.assertTrue(driver.findElementByAccessibilityId("Password sign-in.password-txt-fld").isEnabled());
		driver.findElementByAccessibilityId("Password sign-in.password-txt-fld").sendKeys("12121212");
		
		
		Assert.assertTrue(driver.findElementByAccessibilityId("sign-in.next-btn").isEnabled());
		driver.findElementByAccessibilityId("sign-in.next-btn").click();
		
		
				

	}
	
	
	}

	
		
		
		
	
		

	
		

		
		
		
	



