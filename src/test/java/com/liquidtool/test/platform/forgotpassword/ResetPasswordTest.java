package com.liquidtool.test.platform.forgotpassword;

import com.liquidtool.test.platform.base.TestUtilities;
import com.liquidtool.test.platform.pages.forgotpassword.ForgotPasswordPage;
import com.liquidtool.test.platform.pages.login.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetPasswordTest extends TestUtilities {

    @Test (priority = 1)
    public void resetPasswordTest() {

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        // go to Forgot password page
        logInPage.forgotPassword();

        ForgotPasswordPage.forgotPassword("botscrew.qa@gmail.com");

        //Verification success message shown
        Assert.assertTrue(LogInPage.isSuccessMessageVisible(), "Error message is not visible ");

        //Success message is correct
        String expectedSuccessMessage = "If this is an active account, you will receive an email with further instructions. Please also check your spam-folder.";
        String actualSuccessMessage = LogInPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "Expected error message doesn't contain expectedErrorMessage\nexpectedErrorMessage: "
                + expectedSuccessMessage + "\nactualErrorMessage: " + actualSuccessMessage);

    }

    @Test (priority = 2)
    public void failedResetPasswordTest() {

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        // go to Forgot password page
        logInPage.forgotPassword();

        ForgotPasswordPage.forgotPassword("");

        //Verification error me sage is shown
        Assert.assertTrue(ForgotPasswordPage.isErrorMessageVisible(), "Error message is not visible ");

        //Error message is correct
        String expectedErrorMessage = "Please specify username.";
        String actualErrorMessage = ForgotPasswordPage.getErrorMessageText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Expected error message doesn't contain expectedErrorMessage\nexpectedErrorMessage: "
                + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);

    }

    @Test (priority = 3)
    public void backToLogInPage() {

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        // go to Forgot password page
        logInPage.forgotPassword();

        // go Back to LogIn page
        ForgotPasswordPage.backToLogIn();

    }
}
