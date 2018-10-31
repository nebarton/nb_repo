package test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//public class testWelcomeScreen extends baseIOS{
public class TestWelcomeScreen{


/* Tests to construct: 
 * (1) Navigate to Welcome Screen - App Launch Not Logged in
 * (2) Navigate to Welcome Screen - App Update Not logged in
 * (3) Navigate to Welcome Screen after log out
 * (4) Navigate to Welcome Screen after user deleted
 * 
 */
	
/* Notes:
 * call methods or variables of the class with class object and add an action
 */
	private static AndroidDriver<MobileElement> driver;
	//private static IOSDriver<MobileElement> driver;
	
	//static ProcessBuilder processBuilder;
	//static Process process;
	//static MAUtils mau = new MAUtils();
	//static final LinkedHashMap<String, String> msScreens = createMap();
	//private static LinkedHashMap<String, String> createMap() {
		//LinkedHashMap<String, String> tmpMap = new LinkedHashMap<String, String>();
		//tmpMap.put("Messages", "tabs.messages");
		//tmpMap.put("Discover", "tabs.discover");
		//tmpMap.put("Your Profile", "tabs.profile");
		//tmpMap.put("Members", "tabs.match");
		//return tmpMap;	
	//}
	@BeforeTest
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
			return driver; }


	@Test
	public void testDisplayWelcomeScreen() {
		//final String welcomeTxt = "Welcome to MS Buddy";
		//final String tosPpTxt = "Your privacy is important to us. We will not share your personal information.";
		//final String footerTxt = "Terms of use and Privacy policy.";
		//WebDriverWait wait5 = new WebDriverWait(driver, 100);
		driver.findElementByAccessibilityId("welcome.lets-go-sign-up-btn").click();
		//Assert.assertTrue(driver.findElementByAccessibilityId("welcome.lets-go-sign-up-btn").click());
		
	
	
	}
}
	
	


