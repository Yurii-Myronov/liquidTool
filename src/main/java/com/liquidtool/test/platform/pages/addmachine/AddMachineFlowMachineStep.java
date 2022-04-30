package com.liquidtool.test.platform.pages.addmachine;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddMachineFlowMachineStep extends BasePageObject {

    private static String pageUrl = "https://platform.test.liquidtool.com/coolant_manager/machines/add";

    private static By machineBrandDropdownLocator = By.xpath("//div[@id='machineManufacturerLookup-input']//div//div[@class=' css-tlfecz-indicatorContainer']");
    private static By machineBrandListLocator = By.xpath("//div[@id='fetchedItems']");
    private static By brandLocator = By.xpath("//div[@id='fetchedItems']/div/div[2]");
    private static By machineModelDropdownLocator = By.xpath("//div[@id='machineLookup-input']");
    private static By modelListLocator = By.xpath("//div[@id='fetchedItems']");
    private static By modelLocator = By.xpath("//div[@id='fetchedItems']/div/div[2]");
    private static By machineIdentifierFieldLocator = By.xpath("//input[@id='internalName']");
    private By locationFiledLocator = By.xpath("//input[@placeholder='Please choose']");
    private By factoryLocator = By.xpath("(//div[@id='topology_item'])[1]");
    private static By tankSizeFieldLocator = By.xpath("//input[@id='tankSize']");
    private static By coolantSpecialistDropdownLocator = By.xpath("//div[@id='coolantSpecialists-input']");
    private static By coolantSpecialistList = By.xpath("//div[@id='fetchedItems']/div[@class=' css-11unzgr']");
    private static By coolantSpecialist = By.xpath("//div[@class=' css-11unzgr']/div[1]");
    private static By liquidToolSpecialistDropdownLocator = By.xpath("//div[@id='liquidtoolSpecialists-input']");
    private static By liquidToolSpecialistList = By.xpath("//div[@id='fetchedItems']/div[@class=' css-11unzgr']");
    private static By liquidToolSpecialist = By.xpath("//div[@class=' css-11unzgr']/div[1]");
    private By cancelButtonLocator = By.xpath("//button[@id='cancel_btn']");
    private static By nextButtonLocator = By.xpath("//button[@id='next_btn']");
    private By backButtonLocator = By.xpath("//span[normalize-space()='Back']");
    private static By addMachineTitleLocator = By.xpath("//div[@class='jss164']");


    public AddMachineFlowMachineStep(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /** Get URL variable from PageObject */
    public static String getPageUrl() {
        return pageUrl;

    }

    /** Select MachineBrand dropdown */
    public static AddMachineFlowMachineStep selectBrandField() {
        click(machineBrandDropdownLocator);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Check visibility of brand list */
    public static boolean brandListIsShown() {
        waitForVisibilityOf(machineBrandListLocator);
        return find(machineBrandListLocator).isDisplayed();
    }

    /** Check visibility of brand */
    public static boolean machineBrandVisible() {
        waitForVisibilityOf(brandLocator);
        return find(brandLocator).isDisplayed();
    }

    /** Select Machine brand */
    public static AddMachineFlowMachineStep selectMachineBrand() {
        click(brandLocator);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Select MachineModel dropdown */
    public static AddMachineFlowMachineStep selectModelField() {
        click(machineModelDropdownLocator);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Check visibility of model list */
    public static boolean modelListIsShown() {
        waitForVisibilityOf(modelListLocator);
        return find(modelListLocator).isDisplayed();
    }

    /** Check visibility of model */
    public static boolean machineModelVisible() {
        waitForVisibilityOf(brandLocator);
        return find(brandLocator).isDisplayed();
    }


    /** Select Machine model */
    public static AddMachineFlowMachineStep selectMachineModel() {
        click(modelLocator);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Enter data in the MachineIdentifier and TankSize fields */
    public static AddMachineFlowMachineStep firstStep(String name, String size) {
        log.info("Execute LogIn with email [" + name + "], password [" + size + "]");
        type(name, machineIdentifierFieldLocator);
        type(size, tankSizeFieldLocator);
        return new AddMachineFlowMachineStep(driver, log);

    }

    /** Scroll to the bottom */
    public static void scrollToBottom() {
        log.info("Scroll");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /** Select CoolantSpecialistDropdown */
    public static AddMachineFlowMachineStep selectCoolantSpecialistDropdown() {
        click(coolantSpecialistDropdownLocator);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Check visibility of CoolantSpecialist list */
    public static boolean coolantSpecialistList() {
        waitForVisibilityOf(coolantSpecialistList);
        return find(coolantSpecialistList).isDisplayed();
    }

    /** Select CoolantSpecialist */
    public static AddMachineFlowMachineStep selectCoolantSpecialist() {
        click(coolantSpecialist);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Select LiquidTollSpecialistDropdown */
    public static AddMachineFlowMachineStep selectLiquidTollSpecialistDropdown() {
        click(liquidToolSpecialistDropdownLocator);
        return new AddMachineFlowMachineStep(driver, log);
    }

    /** Check visibility of CoolantSpecialist list */
    public static boolean liquidToolSpecialistList() {
        waitForVisibilityOf(liquidToolSpecialistList);
        return find(liquidToolSpecialistList).isDisplayed();
    }

    /** Select CoolantSpecialist */
    public static AddMachineFlowMachineStep selectLiquidToolSpecialist() {
        click(liquidToolSpecialist);
        return new AddMachineFlowMachineStep(driver, log);
    }


    /** Go to the next step */
    public static AddMachineFlowMachineStep nextStep() {
        click(nextButtonLocator);
        return new AddMachineFlowMachineStep(driver, log);

    }
}
