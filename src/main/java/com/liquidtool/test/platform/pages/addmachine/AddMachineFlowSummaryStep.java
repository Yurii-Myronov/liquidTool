package com.liquidtool.test.platform.pages.addmachine;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddMachineFlowSummaryStep extends BasePageObject {

    private static By machineBlockLocator = By.xpath("//p/span[contains(text(),'Machine')]");
    private static By coolantBlockLocator = By.xpath("//p/span[contains(text(),'Coolant')]");
    private static By measurementConfigurationBlockLocator = By.xpath("//span[normalize-space()='Measurement configuration']");
    private By backButtonLocator = By.xpath("//span[normalize-space()='Back']");
    private static By finishButtonLocator = By.xpath("//button[@id='finish_btn']");
    private By cancelButtonLocator = By.xpath("//button[@id='cancel_btn']");

    public AddMachineFlowSummaryStep(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /** Check visibility of machineBlock */
    public static boolean machineBlock() {
        waitForVisibilityOf(machineBlockLocator);
        return find(machineBlockLocator).isDisplayed();

    }

    /** Scroll to the bottom */
    public static void scrollToCoolantBlock() {
        log.info("Scroll");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 300)");

    }


    /** Check visibility of coolantBlock */
    public static boolean coolantBlock() {
        waitForVisibilityOf(coolantBlockLocator);
        return find(coolantBlockLocator).isDisplayed();

    }

    /** Check visibility of measurementConfigurationBlock */
    public static boolean measurementConfigurationBlock() {
        waitForVisibilityOf(measurementConfigurationBlockLocator);
        return find(measurementConfigurationBlockLocator).isDisplayed();

    }

    /** Scroll to the bottom */
    public static void scrollToBottom() {
        log.info("Scroll");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    /** Go to the next step
     * @return*/
    public static AddMachineFlowSummaryStep finish() {
        click(finishButtonLocator);
        return new AddMachineFlowSummaryStep(driver, log);

    }

}
