package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;


public class baseIOS {
	/* Base class contains the Capability method and returns an object
	 * For iOS only, supply the path to the app within the XCODE directory
	 * Create the desired capabilities object
	 * Create the driver object (responsible for executing the tests), including local host URL and port for appium server
	 * wd = web driver object
	 * Can't start a new test again for 60 seconds, unless manually stop and start the appium server
	 */
	@BeforeTest
	public void setup() throws MalformedURLException {
		// which simulator to use, along with iOS version
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Test iPhone");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
		//only add if working with iOS greater that 10.2
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		//capabilities.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Library/Developer/Xcode/DerivedData/MSBuddy-cwncamulzmszxnbhkghxlydjvzzw/Build/Products/Debug-iphonesimulator/MSBuddy.app");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/nbarton/Library/Developer/Xcode/DerivedData/BCBuddy-bpstnyvfpjnaivbshvljdlinumoa/Build/Products/Debug-iphonesimulator/BCBuddy.app");
		capabilities.setCapability("bundleId", "com.healthline.msbuddy-qa");
		
		IOSDriver<IOSElement>driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	
	}

}


