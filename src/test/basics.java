package test;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics{
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver=capabilities();

		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		//find element by id
		driver.findElementById("android:id/checkbox").click();
		//identify by xpath index
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//send text into a text box
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello World");
		//when multiple results for xpath, specify which one to click
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		
	}

	private static AndroidDriver<AndroidElement> capabilities() {
		// TODO Auto-generated method stub
		return null;
	}

}
