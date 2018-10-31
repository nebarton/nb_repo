package mytasks;

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
	
	@AfterTest
	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	
	
	
	
	@Test (priority = 1, enabled = true)
	public void TestLoginScreenDisplay() {
		Assert.assertTrue(driver.findElementByXPath
		/* Future Tests
		 *  Turn Login into a utility 
		 */ 
		 	
		}
	
	@Test  (priority = 2, enabled = true)
	public void TestTextInput() {
		driver.findElementByClassName("XCUIElementTypeOther").sendKeys("1234abcd!@#$");
		driver.findElementByAccessibilityId("OK").click(); 
		 /*Future Tests:
		 * Boundary testing of user name fields, also special character and spaces in user names
		 * Verify that User name field is blank when first displayed
		 * Bug: No validation message is triggered when user name field is blank*/
		 
		}
	
	@Test (priority = 3, enabled = true)
	public void TestBlankTaskListDisplay() {
		Assert.assertTrue(driver.findElementByAccessibilityId("My Tasks").isEnabled());
		Assert.assertTrue(driver.findElementByAccessibilityId("emptyList").isEnabled());
		Assert.assertTrue(driver.findElementByAccessibilityId("There is no Task for show").isEnabled());
		Assert.assertTrue(driver.findElementByAccessibilityId("addButton").isEnabled());}
	
	@Test (priority = 4, enabled = true)
	public void TestDisplayAddNewTaskForm() {
	
		driver.findElementByAccessibilityId("addButton").click();
		}
	
	@Test (priority = 5, enabled = true)
	public void TestAddNewTaskFormDisplay() {
		Assert.assertTrue(driver.findElementByAccessibilityId("nameField").isEnabled());
		driver.findElementByAccessibilityId("nameField").sendKeys("Task #1");
			
		Assert.assertTrue(driver.findElementByAccessibilityId("dateField").isEnabled());
		driver.findElementByAccessibilityId("dateField").click();
		
		Assert.assertTrue(driver.findElementByAccessibilityId("descriptionContainer").isEnabled());
		driver.findElementByAccessibilityId("descriptionContainer").sendKeys("Testing Description Display for Task #1");
		
		Assert.assertTrue(driver.findElementByAccessibilityId("denyButton").isEnabled());
		Assert.assertTrue(driver.findElementByAccessibilityId("acceptButton").isEnabled());
		/*Future Tests:
		 * Verify default date value
		 * Boundary testing of all fields on the screen
		 * Add Accessibility ID's to date picker and test selecting different dates
*/		 
	
}
		
	@Test (priority = 6, enabled = true)
	public void TestCreateNewTask() {
		/*driver.findElementByAccessibilityId("acceptButton").click();
		
		Future Test:
		 * Make this test more independent*/
		 
	}
	@Test (priority = 7, enabled = true)
	public void TestTaskDetailScreenDisplay() {
		
		driver.findElementByName("Task #1").click();
		Assert.assertTrue(driver.findElementByName(taskName).isDisplayed());
		Assert.assertTrue(driver.findElementByName(descriptionText).isDisplayed());
		
		Assert.assertTrue(driver.findElementByName("By 1234abcd!@#$").isDisplayed());
		Assert.assertTrue(driver.findElementByAccessibilityId("editButton").isEnabled());
		Assert.assertTrue(driver.findElementByAccessibilityId("deleteButton").isEnabled());
		/* Future Tests
		 * Remove all hard coded strings and convert to reusable variables
		 * Add verification for Date text
		 * */
		 
	}
	@Test (priority = 8, enabled = true)
	public void TestEditTaskScreenDisplay() {
		driver.findElementByAccessibilityId("editButton").click();
		Assert.assertTrue(driver.findElementByName(taskName).isDisplayed());
		Assert.assertTrue(driver.findElementByName(descriptionText).isDisplayed());
		Assert.assertTrue(driver.findElementByAccessibilityId("denyButton").isEnabled());
		Assert.assertTrue(driver.findElementByAccessibilityId("acceptButton").isEnabled());
		
	}
	@Test (priority = 9, enabled = true)
	public void TestEditTask() {
		driver.findElementByName(taskName).clear();
		driver.findElementByAccessibilityId("nameField").sendKeys("Updating Task #1");
		
		driver.findElementByName(descriptionText).clear();
		driver.findElementByAccessibilityId("descriptionContainer").sendKeys("Updating Description #1");
		driver.findElementByAccessibilityId("acceptButton").click();
		
		//verify My Task List display with updated text
		Assert.assertTrue(driver.findElementByAccessibilityId("acceptButton").isEnabled());
		Assert.assertTrue(driver.findElementByName("Updating Task #1").isDisplayed());
		
		
	}
	@Test (priority = 10, enabled = true)
	public void TestDeleteTask() {
		driver.findElementByName("Updating Task #1").click();
		Assert.assertTrue(driver.findElementByAccessibilityId("addButton").isEnabled());
		driver.findElementByAccessibilityId("deleteButton").click();
		
		//verify Empty Task List is displayed
		Assert.assertTrue(driver.findElementByAccessibilityId("emptyList").isEnabled());
	
	
	}
}
	
		
		
		
	
		

	
		

		
		
		
	



