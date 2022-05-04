package com.liquidtool.test.platform.pages.profile;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.util.Set;

public class ProfilePage extends BasePageObject {

    private static String pageUrl = "https://platform.test.liquidtool.com/profile/profile";

    private static By inputField = By.xpath("//input[@type='file']");
    private static By userAvatar = By.xpath("(//img[@class='MuiAvatar-img-1432'])[2]");
    private static By deleteUserImage = By.xpath("//span[@id='delete_avatar_btn']");
    private static By titleDropdown = By.xpath("//div[@id='title_selectbox']");
    private static By selectTitle = By.xpath("//li[@class='MuiButtonBase-root-15516 MuiListItem-root-15508 MuiMenuItem-root-15505 Mui-selected MuiMenuItem-gutters-15506 MuiListItem-gutters-15513 MuiListItem-button-15514 Mui-selected']");
    private static By firstNameField = By.xpath("//div[@class='MuiInputBase-root-15420 jss15326 jss15414 MuiInputBase-fullWidth-15427']");
    private static By lastNameField = By.xpath("//div[@class='MuiInputBase-root-15420 jss15326 jss15435 MuiInputBase-fullWidth-15427']");
    private static By emailField = By.xpath("//div[@class='MuiInputBase-root-15420 jss15326 jss15441 MuiInputBase-fullWidth-15427']");
    private static By phoneNumberField = By.xpath("//div[@class='MuiInputBase-root-15420 jss15326 jss15447 MuiInputBase-fullWidth-15427']");
    private static By saveButton = By.xpath("//button[@id='save_btn']");

    public ProfilePage(WebDriver driver, Logger log) {
        super(driver, log);

    }

    // Interact with first invisible locator
    public static ProfilePage LocatorInteraction() {
        log.info("Interact with First invisible locator");
        ElementsInteraction(inputField);
        return new ProfilePage(driver, log);
    }

    public static void selectFile(String fileName) {
        waitForVisibilityOf(inputField);
        log.info("Selecting '" + fileName + "' file from Files folder");
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(filePath, inputField);
        log.info("File uploaded");
    }

    /*// Get the first name of uploaded file
    public static String getAvatar() {
        log.info("Uploading avatar");
        waitForVisibilityOf(userAvatar);
        String name = String.valueOf(find(userAvatar).getAttribute("src"));
        return name;
    }*/

}
