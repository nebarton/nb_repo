package com.appium.util;
//https://stackoverflow.com/questions/5499125/how-to-create-ipa-file-using-xcode
//import com.annotation.values.ElementDescription;
//import com.annotation.values.PageName;
//import com.aventstack.extentreports.Status;
//import com.report.factory.ExtentTestManager;
//import com.appium.util.ScrollElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
//import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

//import java.time.Duration;

public abstract class BasePage implements Config {
    protected AppiumDriver driver;
    AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;


    public void crossPlatformClick(WebElement locator) {
        if (driver instanceof AndroidDriver) {
            AndroidDriver<AndroidElement> androidDriver = (AndroidDriver<AndroidElement>) driver;
            locator.click();
        } else {
            IOSDriver<IOSElement> iOSDriver = (IOSDriver<IOSElement>) driver;
            locator.click();
        }
    }



    protected void swipe_iOS(int startx, int starty, int endx, int endy, int duration) {
        swipe(startx, starty, -startx + endx, -starty + endy, duration);
    }

    protected void swipe(int startx, int starty, int endx, int endy, int duration) { // Android ONLY!
        System.out.println("    swipe(" + startx + ", " + starty + ", " + endx + ", " + endy + ")");
        new TouchAction(driver).press(startx, starty).waitAction(Duration.ofMillis(duration)).moveTo(endx, endy).release().perform();
    }


    public boolean swipeToDirection_iOS_XCTest(MobileElement el, String direction) {
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                swipeObject.put("direction", "down");
            } else if (direction.equals("u")) {
                swipeObject.put("direction", "up");
            } else if (direction.equals("l")) {
                swipeObject.put("direction", "left");
            } else if (direction.equals("r")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element", el.getId());
            js.executeScript("mobile:swipe", swipeObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void swiper(int locator){
        TouchAction swipe = new TouchAction(driver).press(30, 600)
                .waitAction(Duration.ofSeconds(3))
                .moveTo(30,locator)
                .release();
        swipe.perform();
    }



    public boolean scrollToDirection_iOS_XCTest(MobileElement el, String direction) {
        // The main difference from swipe call with the same argument is that scroll will try to move
        // the current viewport exactly to the next/previous page (the term "page" means the content,
        // which fits into a single device screen)
        try {
            JavascriptExecutor js = driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                scrollObject.put("direction", "down");
            } else if (direction.equals("u")) {
                scrollObject.put("direction", "up");
            } else if (direction.equals("l")) {
                scrollObject.put("direction", "left");
            } else if (direction.equals("r")) {
                scrollObject.put("direction", "right");
            }
            scrollObject.put("element", el.getId());
            scrollObject.put("toVisible", "true"); // optional but needed sometimes
            js.executeScript("mobile:scroll", scrollObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public BasePage(AppiumDriver driver){ this.driver = driver; }
    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }


    /**
     * Will check to see if an element is not present Instead of returning exception this will return false
     *
     * @param locator
     * @param timeout
     * @return
     */
    public Boolean isDisplayed(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void swipe() throws InterruptedException {
        MobileElement firstSlider = (MobileElement) driver.findElement(By.id("com.android.systemui:id/activity_description"));

       // ScrollElement se = new ScrollElement((AndroidDriver<MobileElement>) driver);
        //se.scrollToExactElement( "EXCLUSIVE FOR SUBSCRIBERS");

        TouchAction a = new  TouchAction(driver);
        a.longPress(firstSlider).moveTo(14,658).release().perform();
        a.longPress(firstSlider).moveTo(14,658).release().perform();


        Thread.sleep(8000);

    }

    public String getFieldText(By locator){
        AndroidElement textBoxContent = (AndroidElement) driver.findElement(locator);
        String mobileFieldValue = new String();
        mobileFieldValue = textBoxContent.getAttribute("content-desc");
        return mobileFieldValue;
    }



    public WebElement find(By locator){
        return driver.findElement(locator);
    }



    public WebElement findByAccessibility(String locator){
        return driver.findElementByAccessibilityId(locator);
    }



    public void tap(By locator){
        find(locator).click();
    }






        //Logger logger = Logger.getLogger(BasePage.class);

/*        public CommonAppiumTest(AppiumDriver<MobileElement> driver) {
            this.driver = driver;
        }*/

        public void waitForPageToLoad(WebElement id) {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(id));
        }

        public void waitForElementToDisAppear(String id) {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
        }

        public WebElement waitForElement(WebElement arg) {
            waitForPageToLoad(arg);
            WebElement el = arg;
            return el;
        }



        public void swipeRightUntilLogOutScreen() {
            do {
                swipeRight();
            } while (!isElementPresent(By.id("com.android.systemui:id/activity_description")));
        }

        public boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }

        }

        public void swipeLeftUntilTextExists(String expected) {
            do {
                swipeLeft();
            } while (!driver.getPageSource().contains(expected));
        }

        public void swipeRight() {
            Dimension size = driver.manage().window().getSize();
            int startx = (int) (size.width * 0.9);
            int endx = (int) (size.width * 0.20);
            int starty = size.height / 2;
            new TouchAction(driver).press(startx, starty)
                    //.waitAction(Duration.ofSeconds(2))
                    .moveTo(endx,starty).release().perform();
        }

        public void swipeLeft() {
            Dimension size = driver.manage().window().getSize();
            int startx = (int) (size.width * 0.8);
            int endx = (int) (size.width * 0.20);
            int starty = size.height / 2;
            new TouchAction(driver).press(startx, starty)
                    //.waitAction(Duration.ofSeconds(3000))
                    .moveTo(endx,starty).release();
        }

        /**
         * method to set the context to required view.
         *
         * @param context view to be set
         */
        public void setContext(String context) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
            }
            driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

            //logger.info("Current context" + driver.getContext());
        }

    public void lockDevices(){
        ((AndroidDriver) driver).lockDevice();    }

        public void clickBackButton() {
            driver.navigate().back(); //Closes keyboard
            //driver.navigate().back(); //Comes out of edit mode
        }

        public void hideKeyboard(){
            driver.hideKeyboard();
        }

        public String getCurrentMethodName() {
            return Thread.currentThread().getStackTrace()[2].getMethodName();
        }




/*        public void logStepIntoExtentReport(String elementDescription, String action,String typeString) {
            ExtentTestManager.getTest().log(Status.INFO,
                    elementDescription + "; " + withBoldHTML("Text") + ": " + typeString);
        }*/

/*        public String withBoldHTML(String string) {
            if (!string.trim().isEmpty()) {
                return "<b>" + string + "</b>";
            } else {
                return "";
            }
        }*/

/*        public String getPageObjectElemetDescription(Object pageObject, String fieldName) {
            try {
                return this.getClass().getAnnotation(PageName.class).value() + "::" +
                        pageObject.getClass().getField(fieldName).getAnnotation(ElementDescription.class)
                                .value();
            } catch (NoSuchFieldException e) {

                e.printStackTrace();
            }
            return "";
        }*/
    }


