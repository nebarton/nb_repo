package ThriveTests.WebSignUp.FrameWorkUtils;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.net.URL;


/**
 * Base class for the tests.
 */
public class WebSignUpBaseTest implements WebSignUpConfig {

    protected WebDriver driver;

    //junit rule
    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            if (host.equals("browserstack")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                //LEGO-709
                capabilities.setCapability("browserstack.local", "false");
                //LEGO-709
                capabilities.setCapability("browserstack.localIdentifier", "Test123");
                capabilities.setCapability("browser", browser);
                capabilities.setCapability("browser_version", browserVersion);
                capabilities.setCapability("os", platform);
                capabilities.setCapability("os_version", os_version);
                capabilities.setCapability("resolution", resolution);
                if (browser.equals("chrome")) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--kiosk");
                    options.addArguments("--start-maximized");
                    options.addArguments("--incognito");
                }
                if (browser.equals("firefox")) {
                    capabilities.setCapability("firefox", true);
                    FirefoxOptions options = new FirefoxOptions();
                    options.addPreference("dom.file.createInChild", true);
                }
                capabilities.setCapability("browserstack.debug", "true");

                String browserStackUrl = String.format("https://thrivetechadmin1:LZcFpmZp93fkmQE4N33K@hub-cloud.browserstack.com/wd/hub");

                driver = new RemoteWebDriver(new URL(browserStackUrl), capabilities);
            } else if (host.equals("localhost")) {
                if (browser.equals("firefox")) {
                    //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/vendor/geckodriver 2");
                    DesiredCapabilities cap = DesiredCapabilities.firefox();
                    cap.setCapability("firefox", true);
                    driver = new FirefoxDriver(cap);
                    driver.manage().window().maximize();
                } else if (browser.equals("chrome")) {
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability("resolution", resolution);
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("--kiosk");
                    options.addArguments("--start-maximized");
                    options.addArguments("--incognito");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    System.setProperty("webdriver.chrome.driver",
                            //System.getProperty("user.dir") + "/vendor/chromedriver.exe");
                            System.getProperty("user.dir") + "/vendor/chromedriver");
                    driver = new ChromeDriver(capabilities);
                } else if (browser.equals("IE")) {
                    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                    ieCapabilities.setCapability("nativeEvents", false);
                    ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
                    ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
                    ieCapabilities.setCapability("disable-popup-blocking", true);
                    ieCapabilities.setCapability("enablePersistentHover", true);
                    File file = new File("C:/AutomationFrameWorks/CommMaster/comsearch-ui-tests/vendor/IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    driver = new InternetExplorerDriver(ieCapabilities);
                } else if (browser.equals("safari")) {
                    SafariOptions safariCap = new SafariOptions();
                    safariCap.setCapability("nativeEvents", false);
                    safariCap.setCapability("unexpectedAlertBehaviour", "accept");
                    safariCap.setCapability("screenResolution", "1280x1024");
                    safariCap.setCapability("disable-popup-blocking", true);
                    safariCap.setCapability("enablePersistentHover", true);
                    File file = new File("C:/AutomationFrameWorks/CommMaster/comsearch-ui-tests/vendor/IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                    driver = new SafariDriver(safariCap);
                }
            }
        }


        @Override
        protected void after() {
            driver.quit();

        }
    };


}
