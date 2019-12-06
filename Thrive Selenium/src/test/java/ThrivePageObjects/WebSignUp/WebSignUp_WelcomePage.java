package ThrivePageObjects.WebSignUp;

import ThrivePageObjects.GlobalUtils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertTrue;


public class WebSignUp_WelcomePage extends BasePage {


    By welcomeTitleText                      = By.className("sc-ckVGcZ");
    By downLoadAppSubTitleText               = By.className("sc-hSdWYo");

    public WebSignUp_WelcomePage(WebDriver driver){
        //Used by class constructors to invoke constructors of its parent class.
        super(driver);

        //visit("");
    }

    public void validateWelcomePage() {
        assertTrue(isDisplayed(welcomeTitleText,10));
        assertTrue(isDisplayed(downLoadAppSubTitleText,10));

        String welcomText = getText(welcomeTitleText);
        Assert.assertEquals("Welcome to Thrive",welcomText);

        String downLoadText = getText(downLoadAppSubTitleText);
        Assert.assertEquals("Download the Thrive App",downLoadText);

    }

}
