package ThrivePageObjects.WebSignUp;

import ThrivePageObjects.GlobalUtils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;


public class CommonWebSignupPage extends BasePage {


    By locatorPlaceholder                            = By.id("locatorPlaceholder");


    public CommonWebSignupPage(WebDriver driver){
        //Used by class constructors to invoke constructors of its parent class.
        super(driver);
    }


    public void visitWebSignupPage(){
        visit("https://staging-members.thriveglobal.com/");
    }

}
