package com.liquidtool.test.platform.pages.login;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePageObject {

    private static String pageUrl = "https://identity.test.liquidtool.com/auth/realms/lts/protocol/openid-connect/auth?client_id=liquid-tool-portal&redirect_uri=https%3A%2F%2Fplatform.test.liquidtool.com%2F&state=0322c0ff-ff6e-49ce-998d-1352c2699f64&response_mode=fragment&response_type=code&scope=openid&nonce=ed86753e-4eec-4da9-884a-5a55243f7422";

    private By emailLocator = By.xpath("//input[@id='username']");
    private By passwordLocator = By.xpath("//input[@id='password']");
    private By keepMeSignedInLocator = By.xpath("//input[@id='rememberMe']");
    public static By signInButtonLocator = By.xpath("//div[@id='kc-form-buttons']");
    private By forgotPasswordButtonLocator = By.xpath("//a[@id='forgot-password']");
    private static By errorMessageLocator = By.xpath("//div[@class='alert alert-error']");
    private By pleaseContactUsButtonLocator = By.xpath("//a[@id='contactLink']");
    private static By successMessageLocator = By.xpath("//div[@class='alert alert-success']");

    public LogInPage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /** Open Log In page with it's url */
    public void openPage() {
        log.info("Open page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Log In page is opened!");

    }

    /** Get URL variable from PageObject */
    public static String getPageUrl() {
        return pageUrl;

    }

    /** Execute log in */
    public LogInPage logIn(String email, String password) {
        log.info("Execute LogIn with email [" + email + "], password [" + password + "]");
        type(email, emailLocator);
        type(password, passwordLocator);
        click(signInButtonLocator);
        return new LogInPage(driver, log);

    }

    /** Verification of error is visible on the page */
    public static boolean isErrorMessageVisible() {
        waitForVisibilityOf(errorMessageLocator, 60);
        return find(errorMessageLocator).isDisplayed();

    }

    /** Verification of error text on the page */
    public static void waitForErrorMessage(){
        waitForVisibilityOf(errorMessageLocator,5);
    }

    /** Return text from error message */
    public static String getErrorMessageText() {
        return find(errorMessageLocator).getText();

    }

    /** Go to ContactUs page */

    public LogInPage contactUs() {
        click(pleaseContactUsButtonLocator);
        return new LogInPage (driver, log);

    }

    /** Find page "Contact LIQUIDTOOL System: We are here for you" and switch to it */
    public static LogInPage switchToContactUsPage() {
        log.info("Looking fot 'Contact' page");
        switchToWindowWithTitle("Contact");
        return new LogInPage(driver, log);

    }

    /** Go to ContactUs page */

    public LogInPage forgotPassword() {
        click(forgotPasswordButtonLocator);
        return new LogInPage (driver, log);

    }

    /** Verification of success message text on the page */
    public static boolean isSuccessMessageVisible(){
        waitForVisibilityOf(successMessageLocator,5);
        return find(successMessageLocator).isDisplayed();
    }

    /** Return text from success message */
    public static String getSuccessMessageText() {
        return find(successMessageLocator).getText();

    }

    /** Check SignIn button */
    public static boolean isSignInButtonActive() {
        return find(signInButtonLocator).isDisplayed();

    }
}