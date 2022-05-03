package com.liquidtool.test.platform.pages.profile;

import com.liquidtool.test.platform.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject {

    private static String pageUrl = "https://platform.test.liquidtool.com/profile/profile";

    private static By uploadUserImage = By.xpath("//button[@id='upload_avatar_btn']");
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

//    /** Click upload button */
//    public static ProfilePage uploadImage() {
//        click(uploadUserImage);
//        return new ProfilePage(driver, log);

//    }

    /** Select file */
    public static void selectFile(String fileName) {
        log.info("Selecting '" + fileName + "' file from Files folder");
        String filePath = System.getProperty("user.dir") + "src/main/resources/files/" + fileName;
        type(filePath, uploadUserImage);
        log.info("File uploaded");
    }
}
