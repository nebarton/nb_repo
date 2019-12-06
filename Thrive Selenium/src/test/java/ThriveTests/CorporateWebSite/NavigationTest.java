package ThriveTests.CorporateWebSite;

import ThrivePageObjects.CorporateWebsite.CommonCorporatePage;
import ThrivePageObjects.CorporateWebsite.TabPage;
import ThriveTests.CorporateWebSite.FrameWorkUtils.CoporateWebSiteBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class NavigationTest extends CoporateWebSiteBaseTest {

    private Logger logger = LogManager.getLogger(NavigationTest.class);

    private TabPage tabs;
    private CommonCorporatePage common;


    @Before
    public void Setup(){
        tabs = new TabPage(driver);

        common = new CommonCorporatePage(driver);
        //if(host != "localhost"){
        driver.manage().window().maximize();
        common.visitCorporatePage();


        //}
    }

    @Test
    public void goToAllTabs() {

        logger.info("Starting the goToAllTabs test");
        tabs.selectEachTab();
        logger.info("The goToAllTabs test Completed successfully");

    }

    @Test

    public void validateFirstBlogOfEach() {
        logger.info("Starting the validateFirstBlogOfEach test");
        tabs.validateFirstBlogOfEachTab();
        logger.info("The validateFirstBlogOfEach test Completed successfully");

    }

}
