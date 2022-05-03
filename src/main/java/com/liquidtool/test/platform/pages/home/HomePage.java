package com.liquidtool.test.platform.pages.home;

import com.liquidtool.test.platform.base.BasePageObject;
import com.liquidtool.test.platform.pages.profile.ProfilePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

    private static String pageUrl = "https://platform.test.liquidtool.com/portal/home";

    private static By profileIcon = By.xpath("//button[@id='userProfileButton']");
    private static By coolantManagerButtonLocator = By.xpath("//button[@id='primaryMenu.coolantManager']");
    private static By myProfileButton = By.xpath("//div[@id='myProfile']");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /** Verification if profileIcon is visible on the page */
    public static boolean isProfileIconVisible() {
        waitForVisibilityOf(profileIcon, 60);
        return find(profileIcon).isDisplayed();

    }

    /** Go to coolantManager page */
    public static HomePage coolantManagerButton() {
        click(coolantManagerButtonLocator);
        return new HomePage(driver, log);

    }

    /** Scroll to the bottom */
    public static void scrollToBottom() {
        log.info("Scroll");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /** Go to User Profile page */
    public static HomePage myProfile() {
        click(myProfileButton);
        return new HomePage(driver,log);
    }
}
