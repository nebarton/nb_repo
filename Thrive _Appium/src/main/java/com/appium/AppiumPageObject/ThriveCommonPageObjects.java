package com.appium.AppiumPageObject;

import com.appium.util.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ThriveCommonPageObjects extends BasePage {

    AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;




    public ThriveCommonPageObjects(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



}
