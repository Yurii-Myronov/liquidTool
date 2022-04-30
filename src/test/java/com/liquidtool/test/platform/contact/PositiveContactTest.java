package com.liquidtool.test.platform.contact;

import com.liquidtool.test.platform.base.TestUtilities;
import com.liquidtool.test.platform.pages.contactus.ContactUsPage;
import com.liquidtool.test.platform.pages.login.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveContactTest extends TestUtilities {

    @Test
    public void contactUsTest() {
        log.info("Starting positive contactUs test");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        logInPage.logIn("pevacem@mailinator.com", "Pa$$word!");

        //Click contactUs button
        logInPage.contactUs();

        //Find new tab
        LogInPage contactUsPage = LogInPage.switchToContactUsPage();

        String pageSource = contactUsPage.getCurrentPageSource();

        //Verification
        //New page url is expected

        Assert.assertEquals(ContactUsPage.getPageUrl(), ContactUsPage.getCurrentUrl());

        //ContactUs header is visible
        Assert.assertTrue(ContactUsPage.isContactUsHeaderVisible(), "ContactUs button is not visible");

        Assert.assertTrue(pageSource.contains("Contact"), "New page source does not find"  );

        //Verification visible form
        Assert.assertTrue(ContactUsPage.isFormVisible(), "Form is not visible!");

        //Select option
        ContactUsPage.selectOption(1);

        //Verification "Mr" is selected
        String selectOption = ContactUsPage.getSelectedOption();
        Assert.assertEquals(selectOption, "Mr.",
                "Option 'Mr' is not selected. Instead selected - " + selectOption);

        //Send message to support
        ContactUsPage.contactUs("test1", "test1", "tester9@mailinator.com", "test co", "text t");

        //Verification send message to support
        Assert.assertTrue(ContactUsPage.isSuccessMessageVisible(), "Success message is not visible ");
        //Error message is correct
        String expectedSuccessMessage = "The form was sent successfully.";
        String actualSuccessMessage = ContactUsPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "Expected error message doesn't contain expectedErrorMessage\nexpectedErrorMessage: "
                + expectedSuccessMessage + "\nactualErrorMessage: " + actualSuccessMessage);

    }
}
