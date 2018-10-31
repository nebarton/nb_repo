package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage {
	
	//have to concatenate page object to test class via driver
	//define constructor - it takes the name of the class as the method name
	//constructor accepts arguments, in this case the driver
	//it listens and catches the argument
	//driver object is being thrown from test class, page object then catches that driver object
	public WelcomePage(AndroidDriver driver) {
		//initialize all elements with driver
		//when referring to own page use "this", else specify other page
		//initialize all page object elements with the driver object
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

// On-boarding Button
		@AndroidFindBy(accessibility="welcome.lets-go-sign-up-btn") 
		public WebElement StartOnboardingButton;
// Welcome Screen Sign-in button
		@AndroidFindBy(accessibility="onboarding.sign-in-btn") 
		public WebElement SignInButton;
		
// Need accessibility ID's for Terms of use and privacy policy links
// Terms and Condition Link
		@AndroidFindBy(accessibility="TBD") 
		public WebElement TermsLink;
// Privacy Policy Link
		@AndroidFindBy(accessibility="TBD") 
		public WebElement PrivacyLink;
	
//to create a method for findElements (plural)
// public List<WebElement> <insert name of element>;
}
