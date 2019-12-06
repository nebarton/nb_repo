package ThrivePageObjects.WebSignUp;

import ThrivePageObjects.GlobalUtils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;


public class WebSignUp_SignUpPage extends BasePage {


    By signUpLink                            = By.id("nav-bar-sign-up");
    By signUpPageTitleText                   = By.id("landmark-heading");
    By firstNameField                        = By.id("sign-up-form-input-first-name");
    By lastNameField                         = By.id("sign-up-form-input-last-name");
    By workEmailField                        = By.id("sign-up-form-input-email");
    By groupCodeField                        = By.id("sign-up-form-input-group-code");
    By passwordField                         = By.id("sign-up-form-input-password");
    By signUpButton                          = By.id("sign-up-btn-submit");




    public WebSignUp_SignUpPage(WebDriver driver){
        //Used by class constructors to invoke constructors of its parent class.
        super(driver);

    }

    public void navigateToSignUpPage() {

            assertTrue(isDisplayed(signUpLink, 10));
            click(signUpLink);

    }
    public void fillOutSignUpForm(String fName, String lName, String wkEmail, String gCode, String pWord) {
        assertTrue(isDisplayed(signUpPageTitleText,10));
        String signUpTitle = getText(signUpPageTitleText);
        Assert.assertEquals("Sign Up",signUpTitle);

        assertTrue("First Name Field is not present",isDisplayed(firstNameField,10));
        assertTrue("Last Name Field is not present",isDisplayed(lastNameField,10));
        assertTrue("Work Email Field is not present",isDisplayed(workEmailField,10));
        assertTrue("Group Code Field is not present",isDisplayed(groupCodeField,10));
        assertTrue("Password Field is not present",isDisplayed(passwordField,10));

        type(fName,firstNameField);
        type(lName,lastNameField);
        type(wkEmail,workEmailField);
        type(gCode,groupCodeField);
        type(pWord,passwordField);

    }

    public boolean signUpButtonEnabled(){

        boolean state = enabled(signUpButton);
        return state;
    }

    public void submitSignUpForm() {
        assertTrue("Sign up button is not present",isDisplayed(signUpButton,10));
        click(signUpButton);
    }

}
