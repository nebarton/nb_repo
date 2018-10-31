package mytasks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base {
	public static IOSDriver<WebElement> driver;

	
	@BeforeTest
		
	public IOSDriver<IOSElement> setup() throws MalformedURLException {
		IOSDriver<IOSElement>driver;

			// setup method creates the test environment, including app and simulator details
			DesiredCapabilities d = new DesiredCapabilities();
			d.setCapability(MobileCapabilityType.DEVICE_NAME, "NB");
			d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
			d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			d.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Desktop/MyTasks.app");
			d.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
			
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return driver;
			}
		// 
		
	}


