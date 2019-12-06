package com.appium.AppiumPageObject;

import com.appium.util.ScrollElement;
import com.appium.util.BasePage;

import com.appium.util.RetryTest;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ThriveLoginPage extends BasePage {


    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    Random rand = new Random();

    int s = rand.nextInt(50000) + 1;

    public void Setup() {

    }

    AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;


    //region Welcome Back Locators
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/login_label\")")
    private static WebElement welcomeBackFormTitleText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/login_button\")")
    private static WebElement splashLoginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/email_textfield\")")
    private static WebElement welcomeBackSignInEmailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/password_textfield\")")
    private static WebElement welcomeBackSignInPasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/createAccountButton\")")
    private static WebElement welcomeBackCreateAccountLink;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/login_button\")")
    private static WebElement welcomeBackSignInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/snackbar_text\")")
    private static WebElement loginErrorMessage;

    //endregion

    //region Sign Up Locators

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/signUpTextView\")")
    private static WebElement thriveCreateAnAccountLink;

    @AndroidFindBy(xpath = ".//*[@text='Log into your Corporate Account']")
    @iOSFindBy(xpath = ".//*[@text='Log into your IOS Corporate Account']")
    private static WebElement thriveSplashScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/create_account_label\")")
    private static WebElement signUpTitleText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/firstname_textfield\")")
    private static WebElement signUpFirstNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/lastname_textfield\")")
    private static WebElement signUpLastNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/email_textfield\")")
    private static WebElement signUpEmailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/password_textfield\")")
    private static WebElement signUpPasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/companyCodeEditText\")")
    private static WebElement signUpCompanyCodeField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/loginTextView\")")
    private static WebElement signUpLoginLink;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/signup_button\")")
    private static WebElement signUpButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/textHeader\")")
    private static WebElement initialPostSignUpScreenTitile;

    //endregion

    //region On Boarding

    @AndroidFindBy(className = "android.widget.ImageButton")
    private static WebElement onBoardingSplashBackButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/action_skip\")")
    private static WebElement onBoardingSplashSkipButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/textHeader\")")
    private static WebElement onBoardingSplashTitleText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/textView\")")
    private static WebElement onBoardingSplashTitleSubText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/beginButton\")")
    private static WebElement onBoardingSplashBeginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/skipButton\")")
    private static WebElement onBoardingSplashDoThisLaterLink;

    //endregion

    //region HomePage

    @AndroidFindBy(className = "android.widget.TextView")
    private static WebElement todayMicrostepTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/dateTextView\")")
    private static WebElement todaysDateText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/addMicrostepView\")")
    private static WebElement addMicroStepButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/viewAllMicroStepsTextView\")")
    private static WebElement viewAllLink;

    //endregion

    //region Nicole
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/signUpTextView\")")
    private static WebElement nbCreateAccountLink;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/firstname_textfield\")")
    private static WebElement nbFirstNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/lastname_textfield\")")
    private static WebElement nbLastNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/email_textfield\")")
    private static WebElement nbEmailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/password_textfield\")")
    private static WebElement nbPasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/companyCodeEditText\")")
    private static WebElement nbCompanyCodeField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/signUp_button\")")
    private static WebElement nbSignUpButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.thriveglobal.thrive.debug:id/loginTextView\")")
    private static WebElement nbLoginTextView;

    //endregion

    public ThriveLoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }







    //region Nicole Methods

    public void addAccount(){
        nbCreateAccountLink.isDisplayed();
        nbCreateAccountLink.click();
        nbCompanyCodeField.isDisplayed();
    }

    public void fillOutAccountForm(String fn, String ln, String email, String pwd, String ccd){
        nbFirstNameField.isDisplayed();
        nbFirstNameField.sendKeys(fn);
        nbLastNameField.sendKeys(ln);
        nbEmailField.sendKeys(email);
        nbPasswordField.sendKeys(pwd);
        hideKeyboard();
        nbCompanyCodeField.sendKeys(ccd);
        hideKeyboard();
        nbSignUpButton.click();

    }

    //endregion

    //region Welcome Back Methods

    public void selectLoginButton(){
        splashLoginButton.isDisplayed();
        splashLoginButton.click();
    }

    public String validateWelcomeBackFormTitleText(){
        String a = welcomeBackFormTitleText.getText();
        return a;
    }

    public void signInAsReturningUser(String email, String password){
        welcomeBackSignInEmailField.sendKeys(email);
        welcomeBackSignInPasswordField.sendKeys(password);
        welcomeBackSignInButton.click();
    }

    public boolean loginError(){
        boolean a = loginErrorMessage.isDisplayed();
        return a;
    }

    public void ValidateThePresentsOftheHomePage(){
        todayMicrostepTitle.isDisplayed();
        todaysDateText.isDisplayed();
    }

    public void createUserFromWelcomeBackForm(String firstName,String lastName,String email,String password,String companyCode){
        welcomeBackCreateAccountLink.isDisplayed();
        welcomeBackCreateAccountLink.click();
        validateSignupFormElements();
        enterSignupFormValues(firstName,lastName,email,password,companyCode);
    }

    public void selectLoginLink(){
        signUpLoginLink.isDisplayed();
        signUpLoginLink.click();
    }

    //endregion

    //region Sign Up Methods

    public void validateThriveSplashScreen(){
        thriveSplashScreen.isDisplayed();
        thriveCreateAnAccountLink.isDisplayed();
    }

    public void selectTheAccountLink(){
        thriveCreateAnAccountLink.isDisplayed();
        thriveCreateAnAccountLink.click();
    }

    public String validateSignupFormTitleText() {

        String a = signUpTitleText.getText();
        return a;
    }

    public void validateSignupFormElements(){

        signUpFirstNameField.isDisplayed();
        signUpLastNameField.isDisplayed();
        signUpEmailField.isDisplayed();
        signUpPasswordField.isDisplayed();
        signUpCompanyCodeField.isDisplayed();
        signUpLoginLink.isDisplayed();
    }

    public void enterSignupFormValues(String firstName,String lastName,String email,String password,String comanyCode){

        signUpLoginLink.isDisplayed();
        signUpFirstNameField.sendKeys(firstName);
        signUpLastNameField.sendKeys(lastName);
        signUpEmailField.sendKeys(email);
        signUpPasswordField.sendKeys(password);
        hideKeyboard();
        signUpCompanyCodeField.sendKeys(comanyCode);
        hideKeyboard();
    }

    public void validateOnBoardingAppears(){
        onBoardingSplashBackButton.isDisplayed();
        onBoardingSplashBeginButton.isDisplayed();
        onBoardingSplashDoThisLaterLink.isDisplayed();
        onBoardingSplashTitleSubText.isDisplayed();
        onBoardingSplashSkipButton.isDisplayed();
        onBoardingSplashTitleText.isDisplayed();

    }

    public void selectSignUpButton(){

        signUpButton.isDisplayed();
        signUpButton.click();
    }

    //endregion


}
