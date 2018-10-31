package pageobject;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class testLoginScreen {


/* Tests to construct: 
 * (1) Navigate to Welcome Screen - App Launch Not Logged in
 * (2) Navigate to Welcome Screen - App Update Not logged in
 * (3) Navigate to Welcome Screen after log out
 * (4) Navigate to Welcome Screen after user deleted
 * 
 */
	public static void main(String[] args) throws MalformedURLException {
	AndroidDriver<AndroidElement> driver=capabilities();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//click the Login screen and verify display
	//turn this into a utility - click on Sign-in button
	driver.findElementByAccessibilityId("welcome.lets-go-sign-up-btn").click();
	
	// verify display of login screen
	driver.findElementByAccessibilityId("sign-in.email-txt-fld").isDisplayed();
	driver.findElementByAccessibilityId("sign-in.google-btn").isDisplayed();
	driver.findElementByAccessibilityId("sign-in.facebook-btn").isDisplayed();
	driver.findElementByAccessibilityId("sign-in.forgotpassword-btn").isDisplayed();
	driver.findElementByAccessibilityId("sign-in.next-btn").isDisplayed();
	driver.findElementByAccessibilityId("sign-in.password-txt-fld").isDisplayed();
	




		
	
	}

private static AndroidDriver<AndroidElement> capabilities() {
	// TODO Auto-generated method stub
	return null;
}
	
}
	


