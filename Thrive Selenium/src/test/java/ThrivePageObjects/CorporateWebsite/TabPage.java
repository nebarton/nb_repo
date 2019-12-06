package ThrivePageObjects.CorporateWebsite;

import ThrivePageObjects.GlobalUtils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ThriveTests.CorporateWebSite.FrameWorkUtils.CorporateWebSiteConfig.browser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TabPage extends BasePage {


    By wellBeingTab                             = By.linkText("WELL-BEING");
    By wisdomTab                                = By.linkText("WISDOM");
    By wonderTab                                = By.linkText("WONDER");
    By purposeTab                               = By.linkText("PURPOSE");
    By sleepTab                                 = By.linkText("SLEEP");
    By specialSectionsLink                      = By.linkText("SPECIAL SECTIONS");
    By communityTab                             = By.linkText("COMMUNITY");
    By wellBeingTabEdge                         = By.linkText("WELL-BEING");
    By wellBeingTabSafari                       = By.linkText("Well-Being");

    By wisdomTabEdge                            = By.linkText("Wisdom");
    By wonderTabEdge                            = By.linkText("Wonder");
    By purposeTabEdge                           = By.linkText("Purpose");
    By sleepTabEdge                             = By.linkText("Sleep");
    By specialSectionsLinkEdge                  = By.linkText("Special Sections");
    By communityTabEdge                         = By.linkText("CommunityY");

    //Well-being Page
    By wellBeingTitleText                       = By.className("archiveHeader__title--3_J08");
    By wellBeingFirstBlogText                   = By.cssSelector(".articleGridContentItem__title--h3FCE");
    By wellBeingFirstBlogTextIE                 = By.cssSelector(".articleGridContentItem__title--h3FCE");

    //image__wrapper--i55tn articleGridContentItem__image--2pJCZ
    By firstArticleText                         = By.className("articleHeader__title--1OFB2");

    //Wisdom Page
    By wisdomTabTitleText                       = By.className("archiveHeader__title--3_J08");
    By wisdomFirstBlogText                      = By.className("articleGridContentItem__title--h3FCE");
    By wisdomFirstArticleText                   = By.className("articleHeader__title--1OFB2");

    //Wonder Page
    By wonderTabTitleText                       = By.className("archiveHeader__title--3_J08");
    By wonderFirstBlogText                      = By.className("articleGridContentItem__title--h3FCE");
    By wonderFirstArticleText                   = By.className("articleHeader__title--1OFB2");

    //Purpose Page
    By purposeTabTitleText                      = By.className("archiveHeader__title--3_J08");
    By purposeFirstBlogText                     = By.className("articleGridContentItem__title--h3FCE");
    By purposeFirstArticleText                  = By.className("articleHeader__title--1OFB2");

    //Sleep Page
    By sleepTabTitleText                        = By.className("termSponsor__nameLink--2ow3Z");
    By sleepFirstBlogText                       = By.className("articleGridContentItem__title--h3FCE");
    By sleepFirstArticleText                    = By.className("articleHeader__title--1OFB2");

    //Special Sections Page
    By specialSectionsTitleText                 = By.className("SPECIAL SECTIONS");
    By specialSectionsPerfectionLink            = By.className("PERFECTION REFRAMED");
    By specialSectionsMindfulLink               = By.className("MINDFUL SCREENING");
    By specialSectionsAskForFriendLink          = By.className("ASKING FOR A FRIEND");
    By specialSectionsThriveCampusLink          = By.className("THRIVE ON CAMPUS");
    By specialSectionsUnplugRechargeLink        = By.className("UNPLUG & RECHARGE");
    By specialSectionsSocialChangeLink          = By.className("WELLBEING AND SOCIAL CHANGE");
    By specialSectionsSleepLink                 = By.className("SLEEP WELL");
    By specialSectionsRevolutionLink            = By.className("HUMAN REVOLUTION");
    By specialSectionsMicroStepLink             = By.className("MICROSTEP MONTH");
    By specialSectionsDiariesLink               = By.className("THE OPTIMISM DIARIES");
    By specialSectionsLearningLink              = By.className("NEVER STOP LEARNING");
    By specialSectionsWearToWorkLink            = By.className("WHAT WE WEAR TO WORK");
    By specialSectionsSmallBusinessLink         = By.className("HOW SMALL BUSINESSES THRIVE");
    By specialSectionsPodCastLink               = By.className("THRIVE PODCASTS");
    By specialSectionsGeniusLink                = By.className("STROKE OF GENIUS");
    By specialSectionsQuestionnaireLink         = By.className("THE THRIVE QUESTIONNAIRE");
    By specialSectionsRelationshipsLink         = By.className("THRIVING RELATIONSHIPS");
    By specialSectionsMindAtWorkLink            = By.className("YOUR MIND AT WORK");


    //Community Page
    By communityTabTitleText                    = By.className("archiveHeader__title--3_J08");
    By communityFirstBlogText                   = By.className("articleGridContentItem__title--h3FCE");
    By communityFirstArticleText                = By.className("articleHeader__title--1OFB2");



    public TabPage(WebDriver driver){
        //Used by class constructors to invoke constructors of its parent class.
        super(driver);

    }

    public void selectEachTab(){

        if(browser == "edge"){
            isDisplayed(wellBeingTabEdge,10);
            clickJS(wellBeingTabEdge);
        }else {
            isDisplayed(wellBeingTab,10);
            click(wellBeingTab);
        }




        isDisplayed(wellBeingTitleText,10);
        String wellBeing = getText(wellBeingTitleText);
        Assert.assertEquals("WELL-BEING",wellBeing);




        isDisplayed(wisdomTab,10);
        click(wisdomTab);
        isDisplayed(wisdomTabTitleText,10);

        String wisdom = getText(wisdomTabTitleText);
        Assert.assertEquals("WISDOM",wisdom);

        isDisplayed(wonderTab,10);
        click(wonderTab);
        isDisplayed(wonderTabTitleText,10);

        String wonder = getText(wonderTabTitleText);
        Assert.assertEquals("WONDER",wonder);

        isDisplayed(purposeTab,10);
        click(purposeTab);
        isDisplayed(purposeTabTitleText,10);

        isDisplayed(sleepTab,10);
        click(sleepTab);
        isDisplayed(sleepTabTitleText,10);

        isDisplayed(specialSectionsLink,10);
        click(specialSectionsLink);
        isDisplayed(specialSectionsTitleText,10);

        isDisplayed(communityTab,10);
        click(communityTab);
        isDisplayed(specialSectionsTitleText,10);

    }

    public void validateFirstBlogOfEachTab(){

        if(browser == "edge"){
            isDisplayed(wellBeingTabEdge,10);
            click(wellBeingTabEdge);


        }
        if(browser == "safari"){
            isDisplayed(wellBeingTabSafari,10);
            click(wellBeingTabSafari);
        }
        else {
            isDisplayed(wellBeingTab,10);
            click(wellBeingTab);
        }
        isDisplayed(wellBeingFirstBlogText,10);
        String firstBlog = getText(wellBeingFirstBlogText);
        click(wellBeingFirstBlogText);


        isDisplayed(firstArticleText,10);
        String firstArticle = getText(firstArticleText);

        isDisplayed(firstArticleText,10);

        Assert.assertEquals(firstArticle,firstBlog);
        //articleGridContentItem__content--2jWsi
        //articleGridContentItem__content--2jWsi



        isDisplayed(wisdomTab,10);
        click(wisdomTab);

        isDisplayed(wellBeingFirstBlogText,10);
        firstBlog = getText(wellBeingFirstBlogText);
        click(wellBeingFirstBlogText);

        isDisplayed(firstArticleText,10);
        firstArticle = getText(firstArticleText);
        isDisplayed(firstArticleText,10);
        Assert.assertEquals(firstArticle,firstBlog);


        isDisplayed(wonderTab,10);
        click(wonderTab);

        isDisplayed(wellBeingFirstBlogText,10);
        firstBlog = getText(wellBeingFirstBlogText);
        click(wellBeingFirstBlogText);

        isDisplayed(firstArticleText,10);
        firstArticle = getText(firstArticleText);
        isDisplayed(firstArticleText,10);
        Assert.assertEquals(firstArticle,firstBlog);


        isDisplayed(purposeTab,10);
        click(purposeTab);

        isDisplayed(wellBeingFirstBlogText,10);
        firstBlog = getText(wellBeingFirstBlogText);
        click(wellBeingFirstBlogText);

        isDisplayed(firstArticleText,10);
        firstArticle = getText(firstArticleText);
        isDisplayed(firstArticleText,10);
        Assert.assertEquals(firstArticle,firstBlog);


        isDisplayed(sleepTab,10);
        click(sleepTab);

        isDisplayed(wellBeingFirstBlogText,10);
        firstBlog = getText(wellBeingFirstBlogText);
        click(wellBeingFirstBlogText);

        isDisplayed(firstArticleText,10);
        firstArticle = getText(firstArticleText);
        isDisplayed(firstArticleText,10);
        Assert.assertEquals(firstArticle,firstBlog);

/*
        isDisplayed(specialSectionsLink,10);
        click(specialSectionsLink);
        isDisplayed(specialSectionsTitleText,10);
*/

        isDisplayed(communityTab,10);
        click(communityTab);

        isDisplayed(wellBeingFirstBlogText,10);
        firstBlog = getText(wellBeingFirstBlogText);
        click(wellBeingFirstBlogText);

        isDisplayed(firstArticleText,10);
        firstArticle = getText(firstArticleText);
        isDisplayed(firstArticleText,10);
        Assert.assertEquals(firstArticle,firstBlog);
    }

}
