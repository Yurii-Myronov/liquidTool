package com.liquidtool.test.platform.pages.addmachine;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddMachineFlowCoolantStep extends BasePageObject {

    private static By coolantBrandField = By.xpath("//span[contains(text(),'Coolant brand')]");
    private By coolantBrandDropdownLocator = By.xpath("//div[@id='coolantManufacturerLookup-input']");
    private static By coolantNameDropdownLocator = By.xpath("//div[@id='coolantLookup-input']//div//div[@class=' css-tlfecz-indicatorContainer']");
    private static By coolantNameListLocator = By.xpath("//div[@id='fetchedItems']/div[@class=' css-11unzgr']");
    private static By coolantNameLocator = By.xpath("//div[@class=' css-11unzgr']/div[2]");
    private static By refractometerFactorFieldLocator = By.xpath("//input[@id='refractometerFactor']");
    private static By measurementsConfigurator = By.xpath("//div[@class='MuiTableContainer-root-19065']");
    private By dateFilingLocator = By.xpath("//input[@id='coolantDateOfInitialFillingInput']");
    private static By minConcentrationFieldLocator = By.xpath("//input[@id='concentration_limits_min']");
    private static By targetConcentrationFiledLocator = By.xpath("//input[@id='concentration_limits_target']");
    private static By maxConcentrationField = By.xpath("//input[@id='concentration_limits_max']");
    private By checkBoxTemperatureLocator = By.xpath("//input[@id='temperature_checkbox']");
    private static By minTemperatureFiledLocator = By.xpath("//input[@id='temperature_limits_min']");
    private static By maxTemperatureFiledLocator = By.xpath("//input[@id='temperature_limits_max']");
    private By checkBoxPhLocator = By.xpath("//input[@id='ph_checkbox']");
    private static By minPhFieldLocator = By.xpath("//input[@id='ph_limits_min']");
    private static By maxPhFieldLocator = By.xpath("//input[@id='ph_limits_max']");
    private By checkBoxHardnessLocator = By.xpath("//input[@id='hardness_checkbox']");
    private static By minHardnessFieldLocator = By.xpath("//input[@id='hardness_limits_min']");
    private static By maxHardnessFieldLocator = By.xpath("//input[@id='hardness_limits_max']");
    private By checkBoxNitriteLocator = By.xpath("//input[@id='nitrite_checkbox']");
    private static By maxNitriteFieldLocator = By.xpath("//input[@id='nitrite_limits_max']");
    private By checkBoxConductivityLocator = By.xpath("//input[@id='conductivity_checkbox']");
    private static By minConductivityFieldLocator = By.xpath("//input[@id='conductivity_limits_min']");
    private static By maxConductivityFieldLocator = By.xpath("//input[@id='conductivity_limits_max']");
    private By cancelButtonLocator = By.xpath("//button[@id='cancel_btn']");
    private By backButtonLocator = By.xpath("//span[normalize-space()='Back']");
    private static By nextButtonLocator = By.xpath("//button[@id='next_btn']");
    private static By checkBox = By.xpath("//input[@type='checkbox']");
    private static By acceptCookies = By.xpath("//button[@id='accept-cookies']");

    public AddMachineFlowCoolantStep(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /**
     * Check visibility of Coolant brand field
     */
    public static boolean coolantBrandTitleField() {
        waitForVisibilityOf(coolantBrandField);
        return find(coolantBrandField).isDisplayed();
    }

    /**
     * Select CoolantName dropdown
     *
     * @return
     */
    public static AddMachineFlowCoolantStep selectCoolantNameDropdown() {
        click(coolantNameDropdownLocator);
        return new AddMachineFlowCoolantStep(driver, log);
    }

    /**
     * Check visibility of CoolantName list
     */
    public static boolean coolantNameList() {
        waitForVisibilityOf(coolantNameListLocator);
        return find(coolantNameListLocator).isDisplayed();
    }

    /**
     * Check visibility of CoolantName
     */
    public static boolean coolantNameVisible() {
        waitForVisibilityOf(coolantNameLocator);
        return find(coolantNameLocator).isDisplayed();
    }

    /**
     * Select coolantName
     *
     * @return
     */
    public static AddMachineFlowCoolantStep selectCoolantName() {
        click(coolantNameLocator);
        return new AddMachineFlowCoolantStep(driver, log);
    }

    /**
     * Enter data in the Refractometer and limits fields
     */
    public static AddMachineFlowCoolantStep enterRefractometer(String refractometer) {
        log.info("Execute LogIn with refractometer [" + refractometer + "]");
        type(refractometer, refractometerFactorFieldLocator);
        return new AddMachineFlowCoolantStep(driver, log);

    }

    /**
     * Scroll to
     */
    public static void scrollTo() {
        log.info("Scroll");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 800)", "");

    }

    /**
     * Check visibility of fields
     */
    public static boolean concentrationLimitsFields() {
        waitForVisibilityOf(minConcentrationFieldLocator);
        return find(minConcentrationFieldLocator).isDisplayed();
    }


    /** Enter data in the limits fields */
    public static AddMachineFlowCoolantStep enterLimits(String min, String target, String max) {
        log.info("Execute LogIn with concentrateMin [" + min + "], " +
                "concentrateTarget [" + target + "], concentrateMax [" + max + "]");
        type(min, minConcentrationFieldLocator);
        type(target, targetConcentrationFiledLocator);
        type(max, maxConcentrationField);
        return new AddMachineFlowCoolantStep(driver, log);

    }

    /** Scroll to the bottom */
    public static void scrollToBottom() {
        log.info("Scroll");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Go to the next step
     *
     * @return
     */
    public static AddMachineFlowCoolantStep nextStep() {
        click(nextButtonLocator);
        return new AddMachineFlowCoolantStep(driver, log);

    }

    /** Accept cookies */
    public static AddMachineFlowCoolantStep acceptCookies() {
        click(acceptCookies);
        return new AddMachineFlowCoolantStep(driver, log);
    }

    /**
     * Select measurement configuration (check box)
     */
    public static void selectAllCheckBoxes() {
        log.info("Checking all unselected checkboxes");
        List<WebElement> checkBoxes = findAll(checkBox);
        for (WebElement checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
        }
    }

    /**
     * Verify checkBoxes are selected
     */
    public static boolean areAllCheckBoxesSelected() {
        log.info("Verify that all checkboxes are selected");
        List<WebElement> checkBoxes = findAll(checkBox);
        for (WebElement checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                return false;
            }
        }
        return true;
    }

    /** Enter data in the limits fields */
    public static AddMachineFlowCoolantStep enterLimitsInAllFields(String minConcentration, String targetConcentration,
                                                                   String maxConcentration, String minTemperature,
                                                                   String maxTemperature, String minPh, String maxPh,
                                                                   String minHardness, String maxHardness, String maxNitrite,
                                                                   String minConductivity, String maxConductivity) {
        log.info("Execute LogIn with concentrateMin [" + minConcentration + "], " +
                "concentrateTarget [" + targetConcentration + "], concentrateMax [" + maxConcentration + "]," +
                " temperatureMin [" + minTemperature + "], temperatureMax [" + maxTemperature + "], pHMin [" + minPh + "]," +
                "pHMax [" + maxPh + "], HardnessMin [" + minHardness + "], HardnessMax [" + maxHardness + "], " +
                "NitriteMax [" + maxNitrite +"], ConductivityMin [" + minConductivity + "], ConductivityMax [" + maxConcentration +"]");
        type(minConcentration, minConcentrationFieldLocator);
        type(targetConcentration, targetConcentrationFiledLocator);
        type(maxConcentration, maxConcentrationField);
        type(minTemperature, minTemperatureFiledLocator);
        type(maxTemperature, maxTemperatureFiledLocator);
        type(minPh, minPhFieldLocator);
        type(maxPh, maxPhFieldLocator);
        type(minHardness, minHardnessFieldLocator);
        type(maxHardness, maxHardnessFieldLocator);
        type(maxNitrite, maxNitriteFieldLocator);
        type(minConductivity, minConductivityFieldLocator);
        type(maxConductivity, maxConductivityFieldLocator);
        return new AddMachineFlowCoolantStep(driver, log);

    }

}
