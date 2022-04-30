package com.liquidtool.test.platform.login;

import com.liquidtool.test.platform.base.TestUtilities;
import com.liquidtool.test.platform.pages.home.HomePage;
import com.liquidtool.test.platform.pages.login.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends TestUtilities {

    @Test (priority = 1)
    public void logInTest() {
        log.info("Starting positive logIn test");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        //Execute log in
        logInPage.logIn("yurii.myronov@mailinator.com", "Pa$$w0rd!");

        //Verification
        //Profile icon is visible
        Assert.assertTrue(HomePage.isProfileIconVisible(), "Profile icon is not visible");

    }

    @Test (priority = 2)
    public void negativeLogInTest() {
        log.info("Starting negative negativeLogInTest");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        logInPage.logIn("yurii.myronov@mailinator.com", "Pa$$word!");

        //Verification
        LogInPage.waitForErrorMessage();
        String message = LogInPage.getErrorMessageText();

        //Error message is shown
        Assert.assertTrue(LogInPage.isErrorMessageVisible(), "Error message is not visible");

        //Error message is correct
        String expectedErrorMessage = "Invalid username or password.";
        String actualErrorMessage = LogInPage.getErrorMessageText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Expected error message doesn't contain expectedErrorMessage\nexpectedErrorMessage: "
                + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }

    @Test (priority = 3)
    public void checkSignInButtonTest() {
        log.info("Starting negative checkSignInButtonTest");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        // check SignIn button
        Assert.assertTrue(LogInPage.isSignInButtonActive(), "SignIn button is active");

    }
}
