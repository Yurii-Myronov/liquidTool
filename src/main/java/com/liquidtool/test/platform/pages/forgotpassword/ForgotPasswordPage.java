package com.liquidtool.test.platform.pages.forgotpassword;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePageObject {

    private static By emailLocator = By.xpath("//input[@id='username']");
    private static By backToLogInPageLocator = By.xpath("//a[@id='back2login']");
    private static By submitButtonLocator = By.xpath("//input[@value='Submit']");
    private static By errorMessageLocator = By.xpath("//div[@class='alert alert-error']");

    public ForgotPasswordPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Reset password */
    public static ForgotPasswordPage forgotPassword(String email) {
        log.info("Execute Reset password with email [" + email + "]");
        type(email, emailLocator);
        click(submitButtonLocator);
        return new ForgotPasswordPage(driver, log);
    }

    /** Go back to LogIn password page */
    public static ForgotPasswordPage backToLogIn() {
        log.info("Go back to Log in");
        click(backToLogInPageLocator);
        return new ForgotPasswordPage(driver, log);

    }

    /** Verification of error is visible on the page */
    public static boolean isErrorMessageVisible() {
        waitForVisibilityOf(errorMessageLocator, 60);
        return find(errorMessageLocator).isDisplayed();
    }

    /** Return text from error message */
    public static String getErrorMessageText() {
        return find(errorMessageLocator).getText();

    }
}
