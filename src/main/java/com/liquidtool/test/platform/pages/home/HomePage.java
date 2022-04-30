package com.liquidtool.test.platform.pages.home;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

    private static String pageUrl = "https://platform.test.liquidtool.com/portal/home";

    private static By profileIcon = By.xpath("//button[@id='userProfileButton']");
    private static By coolantManagerButtonLocator = By.xpath("//button[@id='primaryMenu.coolantManager']");


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
}
