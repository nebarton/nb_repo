package ThrivePageObjects.CorporateWebsite;

import ThrivePageObjects.GlobalUtils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ThriveTests.CorporateWebSite.FrameWorkUtils.CorporateWebSiteConfig.browser;

public class CommonCorporatePage extends BasePage {


    By wellBeingTab = By.linkText("WELL-BEING");



    public CommonCorporatePage(WebDriver driver) {
        //Used by class constructors to invoke constructors of its parent class.
        super(driver);

    }


    public void visitCorporatePage(){
        visit("https://thriveglobal.com/");
    }
}
