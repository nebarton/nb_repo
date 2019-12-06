package com.appium.util;

import com.appium.util.Config;
import com.appium.util.LaunchAppiumProgramatically;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements Config {
    @BeforeClass
    public static void moSetup() {
/*
        LaunchAppiumProgramatically.startAppiumonMac();
        LaunchAppiumProgramatically.stopAppium();
        LaunchAppiumProgramatically.startAppiumonMac();

        Thread.sleep(16000);
*/

    }
    protected AppiumDriver driver;

    @Rule
    public ExternalResource resource = new ExternalResource() {




        @Override
        protected void before() throws Exception {


            if (platformName.equals("Android")) {

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("automationName", "Appium");
                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability("platformVersion", platformVersion);
                capabilities.setCapability("deviceName", deviceName);
                capabilities.setCapability("app", app);
                //capabilities.setCapability("appActivity", ".LoginActivity");
                //capabilities.setCapability("unlockType", "pin");
                //capabilities.setCapability("unlockKey", "1111");
                capabilities.setCapability("clearSystemFiles", true);

                //capabilities.setCapability("appPackage", "com.ten.mtodplay");
                //capabilities.setCapability("appActivity", "com.motortrend.ui.main.MainActivity");
                driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            }else{

                IOSDriver<IOSElement>driver;

                DesiredCapabilities capabilities=new DesiredCapabilities();
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
                    capabilities.setCapability("platformName", platformName);
                    capabilities.setCapability("platformVersion", platformVersion);
                    capabilities.setCapability("app", app);
                    capabilities.setCapability("autoGrantPermissions", true);

                    capabilities.setCapability("clearSystemFiles", true);
                    capabilities.setCapability("wdaStartupRetryInterval", 1000);
                    capabilities.setCapability("useNewWDA", true);
                    capabilities.setCapability("waitForQuiescence", false);
                    capabilities.setCapability("shouldUseSingletonTestManager", false);
                    capabilities.setCapability("showXcodeLog", true);

                    capabilities.setCapability("fullReset", false);

                    driver=new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
                    PageFactory.initElements(new AppiumFieldDecorator(driver),this);

                    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);



            }

        }





        @AfterClass
        public void teardownEnv(){
            driver.quit();

        }

    };
}
