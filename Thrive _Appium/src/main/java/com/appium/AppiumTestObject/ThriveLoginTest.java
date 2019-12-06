package com.appium.AppiumTestObject;

import com.appium.AppiumPageObject.*;
import com.appium.util.BaseTest;
import com.appium.util.RetryTest;
import com.csvreader.CsvReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThriveLoginTest extends BaseTest {
    private ThriveLoginPage thriveLogin;
    private ThriveHomePage thriveHome;
    private ThriveCommonPageObjects commonAction;

    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);
    Random rand = new Random();
    int  s = rand.nextInt(50000) + 1;

    @Before
    public void Setup() {
        thriveLogin = new ThriveLoginPage(driver);
        thriveHome = new ThriveHomePage(driver);
    }

    @Test
    public void loginThiveUser() throws IOException {
        if (driver instanceof AndroidDriver) {
            AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;
            thriveLogin.validateThriveSplashScreen();
            thriveLogin.selectLoginButton();
            assertEquals("Welcome Back", thriveLogin.validateWelcomeBackFormTitleText());
            thriveLogin.signInAsReturningUser("ehenderson+108@surgeforward.com", "Love2Test!");
            thriveLogin.ValidateThePresentsOftheHomePage();

/*            if (thriveLogin.loginError() == true) {
                thriveLogin.createUserFromWelcomeBackForm("Enrique", "Henderson", "ehenderson+108@surgeforward.com", "Love2Test!", "ThriveFriends");
                thriveLogin.selectSignUpButton();
                thriveLogin.validateOnBoardingAppears();
                androidDriver.closeApp();

            } else {}*/
        }else {
            IOSDriver<IOSElement> iosDriver = (IOSDriver<IOSElement>) driver;






        }

    }

    @Test
    public void nicoleSignUp() throws IOException {
        if (driver instanceof AndroidDriver) {
            AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;

            thriveLogin.addAccount();
            thriveLogin.fillOutAccountForm("nbtest+401", "Barton", "nbtest+401@nmail.com", "Password1!", "nbtest");







        }

    }
}
