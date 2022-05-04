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
        //Profile icon is visible®
        Assert.assertTrue(HomePage.isProfileIconVisible(), "Profile icon is not visible");

        //Scroll to bottom
        HomePage.scrollToBottom();

        //Open UserProfile page
        HomePage.myProfile();

        // Click Upload button
        ProfilePage.LocatorInteraction();

        //Select image
        String fileName = "images1.jpeg";
        ProfilePage.selectFile(fileName);

       /* // Get the First name of uploaded file
        String avatarName = ProfilePage.getAvatar();

        // Verify selected file uploaded
        Assert.assertTrue(avatarName.contains("blob:https://platform.test.liquidtool.com/"),
        "User Avatar (" + avatarName + ") is not one of the uploaded (" + avatarName + ")");*/
    }
}
