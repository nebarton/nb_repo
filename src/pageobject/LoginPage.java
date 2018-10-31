package pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage(AppiumDriver driver) {
		//initialize all elements with driver
		//when referring to own page use "this", else specify other page
		//initialize all page object elements with the driver object
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	}
