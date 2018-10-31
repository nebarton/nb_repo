package testngFiles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOSTests {
	private static IOSDriver<MobileElement> driver;
	
	@BeforeTest
	public void SetupiOS() throws MalformedURLException {
	
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "Test iPhone");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		d.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Desktop/My Tasks.app");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
}
	@AfterTest
	 public void tearDown() {
		 driver.quit();
	  }
	 @AfterMethod
	 public void navigateHome() {
		 driver.navigate().back();
	 }
	  
	    
	Test (priority = 1, enabled = true)
	public void TextInputTest(){
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByAccessibilityId("Text Entry").click();
		driver.findElementByClassName("XCUIElementTypeOther").sendKeys("Keep Going - you are doing great");
		driver.findElementByName("OK").click();
		
	}
	@Test (priority = 2, enabled = true)
	public void ScrollAndReadValue() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    Map<String, String> params = new HashMap<>();
	    params.put("direction", "up");
	    js.executeScript("mobile: swipe", params);
	    
	    driver.findElementByAccessibilityId("Steppers").click();

		//Click the + sign twice and then grab the value
	    driver.findElementByAccessibilityId("Increment").click();
	    driver.findElementByAccessibilityId("Increment").click();
	    //user .findElements when the characteristic is not unique - print out the values
	    System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText());
	    
	    System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
	    driver.findElementByAccessibilityId("Decrement").click();
	    System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText());
	}
	@Test (priority = 4, enabled = true)
	public void PickerView() {
		//picker view
		driver.findElementByAccessibilityId("Picker View").click();
		// send keys for the value you want to select
		driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
		driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
	}
	
	

		
	

}
