package com.liquidtool.test.platform.pages.coolantmanager;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoolantManagerPage extends BasePageObject {

    private String pageUrl = "https://platform.test.liquidtool.com/coolant_manager/machines";

    private static By machinePageTitleLocator = By.xpath("//p[@id='title']//span[contains(text(),'Machines')]");
    private static By plusButtonLocator = By.xpath("//span[@id='entities_add']");
    private static By addMachineButtonLocator = By.xpath("//div[@role='button']");


    public CoolantManagerPage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /** Get URL variable from PageObject */
    public String getPageUrl() {
        return pageUrl;

    }

    /** Verification if machinePageTitle is visible on the page */
    public static boolean isMachinePageTitleVisible() {
        waitForVisibilityOf(machinePageTitleLocator, 60);
        return find(machinePageTitleLocator).isDisplayed();

    }

    /** Open addMachineFlow page */
    public static CoolantManagerPage plusButton() {
        click(plusButtonLocator);
        return new CoolantManagerPage(driver, log);

    }

    public static CoolantManagerPage addMachineButton() {
        click(addMachineButtonLocator);
        return new CoolantManagerPage(driver, log);

    }
}
