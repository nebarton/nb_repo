package iosnativeapp;


import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class IOSTest extends base{

	public static void main(String[] args) throws MalformedURLException {
		
		IOSDriver<IOSElement>driver=capabilities();
		// navigate to text field and enter text
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByAccessibilityId("Text Entry").click();
		driver.findElementByClassName("XCUIElementTypeOther").sendKeys("Keep Going - you are doing great");
		driver.findElementByName("OK").click();
		// going back to home menu
		driver.navigate().back(); 
		
		// scroll code used to replace previously depricated .swipe method. Specific to iOS
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
		// driver.quit();
	    driver.navigate().back();
		
		//picker view
		driver.findElementByAccessibilityId("Picker View").click();
		// send keys for the value you want to select
		driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
		driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");
		
		
	}
	
}
	

