package test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseAndroid {
	
	

	
	/* Base class contains the Capability method and returns an object
	 * For Android only, place the .apk file in the source file of the directory and specify the file name
	 * Create the desired capabilities object
	 * Create the driver object (responsible for executing the tests), including local host URL and port for appium server
	 * wd = web driver object
	 * Can't start a new test again for 60 seconds, unless manually stop and start the appium server
	 */

	public static AndroidDriver<AndroidElement> main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;
		File appDir =new File("src");
		File app =new File(appDir, "bcbuddy-qa.apk");
		//File app =new File(appDir, "msbuddy-qa.apk");
		//File app =new File(appDir, "app-release.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android8");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "ANDROID");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		
			
		//can't start the test again foe 60 seconds - takes this long to close the session but connection is still open
		// to force the connection close ctrl c in the appium server window
		//driver is responsible for all automation - has to be sent to basics class
		
			
			
			
			

	}
}


