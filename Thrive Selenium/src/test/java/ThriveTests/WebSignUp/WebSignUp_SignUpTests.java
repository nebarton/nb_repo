package ThriveTests.WebSignUp;

import ThrivePageObjects.WebSignUp.CommonWebSignupPage;
import ThrivePageObjects.WebSignUp.WebSignUp_SignUpPage;
import ThrivePageObjects.WebSignUp.WebSignUp_WelcomePage;

import ThriveTests.WebSignUp.FrameWorkUtils.WebSignUpBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class WebSignUp_SignUpTests extends WebSignUpBaseTest {
    private Logger logger = LogManager.getLogger(WebSignUp_SignUpTests.class);

    private WebSignUp_SignUpPage signUp;
    private WebSignUp_WelcomePage welcome;
    private CommonWebSignupPage commonWeb;


    @Before
    public void Setup(){
        signUp = new WebSignUp_SignUpPage(driver);
        welcome = new WebSignUp_WelcomePage(driver);
        commonWeb = new CommonWebSignupPage(driver);

        driver.manage().window().maximize();
        commonWeb.visitWebSignupPage();


    }

    Random rndNum = new Random();
    int r = rndNum.nextInt(100000);

    @Test
    public void fillOutTheSignUpForm() {
        logger.info("Starting the fillOutTheSignUpForm test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation","QE Test","automation"+r+"@qemail.abc","tester","Password1!");
        signUp.submitSignUpForm();
        welcome.validateWelcomePage();

        logger.info("The fillOutTheSignUpForm test Completed successfully");
    }

    @Test
    public void validateFirstNameIsRequired() {

        logger.info("Starting the validateFirstNameIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("","QE Test"+r,"automation"+r+"@qemail.abc","tester","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validateFirstNameIsRequired test Completed successfully");
    }

    @Test
    public void validateLastNameIsRequired() {

        logger.info("Starting the validateLastNameIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation"+r,"","automation"+r+"@qemail.abc","tester","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validateLastNameIsRequired test Completed successfully");
    }

    @Test
    public void validateGoodEmailFormatComIsRequired() {

        logger.info("Starting the validateGoodEmailFormatComIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation"+r,"QE Test"+r,"automation"+r+"@qemail.","tester","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validateGoodEmailFormatComIsRequired test Completed successfully");
    }

    @Test
    public void validateGoodEmailFormatDomainIsRequired() {

        logger.info("Starting the validateGoodEmailFormatDomainIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation"+r,"QE Test"+r,"automation@.com","tester","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validateGoodEmailFormatDomainIsRequired test Completed successfully");
    }

    @Test
    public void validateGoodEmailFormatNameIsRequired() {

        logger.info("Starting the validateGoodEmailFormatNameIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation"+r,"QE Test"+r,"@domain.com","tester","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validateGoodEmailFormatNameIsRequired test Completed successfully");
    }

    @Test
    public void validateGroupCodeIsRequired() {

        logger.info("Starting the validateGroupCodeIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation"+r,"QE Test"+r,"name@domain.com","","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validateGroupCodeIsRequired test Completed successfully");
    }

    @Test
    public void validatePasswordIsRequired() {

        logger.info("Starting the validatePasswordIsRequired test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation"+r,"QE Test"+r,"name@domain.com","tester","");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertFalse(buttonState);

        logger.info("The validatePasswordIsRequired test Completed successfully");
    }

    @Test
    public void validateRequiredToEnableSignUpButton() {

        logger.info("Starting the validateRequiredToEnableSignUpButton test");

        signUp.navigateToSignUpPage();
        signUp.fillOutSignUpForm("Automation","QE Test","name@domain.com","tester","Password1!");
        boolean buttonState = signUp.signUpButtonEnabled();
        Assert.assertTrue(buttonState);

        logger.info("The validateRequiredToEnableSignUpButton test Completed successfully");
    }
}
