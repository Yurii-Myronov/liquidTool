package com.liquidtool.test.platform.profile;

import com.liquidtool.test.platform.base.TestUtilities;
import com.liquidtool.test.platform.pages.home.HomePage;
import com.liquidtool.test.platform.pages.login.LogInPage;
import com.liquidtool.test.platform.pages.profile.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTest extends TestUtilities {

    @Test(priority = 1)
    public void uploadUserImage() {
        log.info("Starting uploadUserImage test");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        //Execute log in
        logInPage.logIn("pevacem@mailinator.com", "Pa$$w0rd!");

        //Verification
        //Profile icon is visible
        Assert.assertTrue(HomePage.isProfileIconVisible(), "Profile icon is not visible");

        //Scroll to bottom
        HomePage.scrollToBottom();

        //Open UserProfile page
        HomePage.myProfile();

        //Click Upload button
        ProfilePage.uploadImage();

        //Select image
        String fileName = "images (6).jpeg";
        ProfilePage.selectFile(fileName);

        sleep(9000);
    }
}
