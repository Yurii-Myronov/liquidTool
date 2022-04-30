package com.liquidtool.test.platform.pages.contactus;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePageObject {

    private static String pageUrl = "https://website.test.liquidtool.com/en/contact/";

    private static By contactUsHeader = By.xpath("//h1[normalize-space()='Contact us']");
    private static By titleLocator = By.xpath("//select[@id='form-field-title']");
    private static By firstNameLocator = By.xpath("//input[@id='form-field-first_name']");
    private static By lastNameLocator = By.xpath("//input[@id='form-field-last_name']");
    private static By emailLocator = By.xpath("//input[@id='form-field-email']");
    private static By companyLocator = By.xpath("//input[@id='form-field-company']");
    private static By messageLocator = By.xpath("//textarea[@id='form-field-message']");
    private static By sendButtonLocator = By.xpath("//button[@type='submit']");
    private static By successMessageLocator = By.xpath("//div[@role='alert']");
    private static By formLocator = By.xpath("//section[@class='elementor-section elementor-top-section elementor-element elementor-element-b408943 lt-section elementor-section-boxed elementor-section-height-default elementor-section-height-default is-first']//div[@class='elementor-container elementor-column-gap-default']");

    public ContactUsPage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    /** Get URL variable from PageObject */
    public static String getPageUrl() {
        return pageUrl;

    }

    /** Verification if contactUsHeader is visible */
    public static boolean isContactUsHeaderVisible() {
        waitForVisibilityOf(contactUsHeader, 60);
        return find(contactUsHeader).isDisplayed();

    }

    /** Verification if for is visible on the page */
    public static boolean isFormVisible() {
        waitForVisibilityOf(formLocator, 60);
        return find(formLocator).isDisplayed();
    }

    /** Send message */
    public static ContactUsPage contactUs(String firstName, String lastName,
                                          String email, String company, String message) {
        log.info("Send message to support with: ["+ firstName +"], ["+ lastName +"], " +
                "["+ email +"], ["+ company +"], ["+ message +"]");
        type(firstName, firstNameLocator);
        type(lastName, lastNameLocator);
        type(email, emailLocator);
        type(company, companyLocator);
        type(message, messageLocator);
        click(sendButtonLocator);
        return new ContactUsPage(driver, log);
    }

    /** Given option from 'title' dropdown */
    public static void selectOption(int i) {
        log.info("Select option " + i + " from dropdown");
        WebElement dropdownElement = find(titleLocator);
        Select titleLocator = new Select(dropdownElement);

        //select elements in dropdown
        titleLocator.selectByIndex(i);
        //titleLocator.selectByValue("" + i);
        //titleLocator.selectByVisibleText("Option " + i);
    }

    /** Returns selected options in the dropdown */
    public static String getSelectedOption() {
        WebElement dropdownElement = find(titleLocator);
        Select titleLocator = new Select(dropdownElement);
        String selectedOption = titleLocator.getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }


    /** Verification of error text on the page */
    public static boolean isSuccessMessageVisible(){
        waitForVisibilityOf(successMessageLocator,5);
        return find(successMessageLocator).isDisplayed();
    }

    /** Return text from error message */
    public static String getSuccessMessageText() {
        return find(successMessageLocator).getText();

    }
}
