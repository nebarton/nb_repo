package com.appium.util;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;

public class ScrollElement {
    AndroidDriver<MobileElement> driver;
    public ScrollElement(AndroidDriver<MobileElement> driver)
    {
        this.driver = driver ;
    }


    public void scrollToExactElement(String str) {

        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
                        + str + "\").instance(0))");
    }

    public void scrollToElement(String str) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + str + "\").instance(0))");
    }



    public void ScrollStepWise(MobileElement ele, int step) {
        ((AndroidElement) ele)
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollForward("+step+"\"));");

    }
    public void scrollToExactElementH(String str) {

        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.ten.mtodplay:id/rv_item_contents\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().descriptionContains(\"Family\"))"));

        //Perform the action on the element
        System.out.println(element.getAttribute("id"));
    }



}
