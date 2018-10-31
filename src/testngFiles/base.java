package testngFiles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;


public class base {
	
@BeforeTest
	
public IOSDriver<IOSElement> setup() throws MalformedURLException {
	IOSDriver<IOSElement>driver;


		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "Test iPhone");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		d.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Desktop/UICatalog.app");
		d.setCapability(MobileCapabilityType.AUTO_WEBVIEW, "True");
		d.setCapability(MobileCapabilityType.FULL_RESET, "True");
		
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		}
	
}
	
	



		
			 
		
			

		






