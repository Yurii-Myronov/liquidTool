package com.liquidtool.test.platform.machine;

import com.liquidtool.test.platform.base.TestUtilities;
import com.liquidtool.test.platform.pages.addmachine.AddMachineFlowCoolantStep;
import com.liquidtool.test.platform.pages.addmachine.AddMachineFlowMachineStep;
import com.liquidtool.test.platform.pages.addmachine.AddMachineFlowSummaryStep;
import com.liquidtool.test.platform.pages.coolantmanager.CoolantManagerPage;
import com.liquidtool.test.platform.pages.home.HomePage;
import com.liquidtool.test.platform.pages.login.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddMachineFlowTest extends TestUtilities {

    @Test (priority = 1)
    public void addMachineTest() {
        log.info("Positive add machine test Started");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        //Execute log in
        logInPage.logIn("pevacem@mailinator.com.com", "Pa$$w0rd!");

        // Open the Machines page
        HomePage.coolantManagerButton();

        // Coolant header is visible
        Assert.assertTrue(CoolantManagerPage.isMachinePageTitleVisible(), "Machine page title is not visible");

        // Open AddMachine flow
        CoolantManagerPage.plusButton();
        CoolantManagerPage.addMachineButton();

        //Machine Step
        // AddMachine page title is visible
        Assert.assertEquals(AddMachineFlowMachineStep.getPageUrl(), AddMachineFlowMachineStep.getCurrentUrl());

        //Select Machine brand
        AddMachineFlowMachineStep.selectBrandField();

        Assert.assertTrue(AddMachineFlowMachineStep.brandListIsShown(), "Brand list is not visitable");
        Assert.assertTrue(AddMachineFlowMachineStep.machineBrandVisible(), "Brand is not visitable");

        AddMachineFlowMachineStep.selectMachineBrand();


        //Select Machine model
        AddMachineFlowMachineStep.selectModelField();

        Assert.assertTrue(AddMachineFlowMachineStep.modelListIsShown(), "Model list is not visitable");
        Assert.assertTrue(AddMachineFlowMachineStep.machineModelVisible(), "Model is not visitable");

        AddMachineFlowMachineStep.selectMachineModel();

        //Fill fields
        AddMachineFlowMachineStep.firstStep("Auto-test-1", "300");

        //Scroll to the bottom
        AddMachineFlowMachineStep.scrollToBottom();

        //Go to next step
        AddMachineFlowMachineStep.nextStep();

        //Get step title
        Assert.assertTrue(AddMachineFlowCoolantStep.coolantBrandTitleField(), "Icon is not visible");

        //Coolant step
        //Select coolant name
        AddMachineFlowCoolantStep.selectCoolantNameDropdown();

        Assert.assertTrue(AddMachineFlowCoolantStep.coolantNameList(), "Coolant name list is not visible");
        Assert.assertTrue(AddMachineFlowCoolantStep.coolantNameVisible(), "Coolant name is not visible");

        AddMachineFlowCoolantStep.selectCoolantName();

        //Fill refractometer
        AddMachineFlowCoolantStep.enterRefractometer("1");

        //Scroll to limits
        AddMachineFlowCoolantStep.scrollTo();

        //Check visibility of limit fields
        Assert.assertTrue(AddMachineFlowCoolantStep.concentrationLimitsFields(), "Concentration fields are not visible");

        //Set limits
        AddMachineFlowCoolantStep.enterLimits("1", "2", "3");

        //Scroll to the bottom
        AddMachineFlowCoolantStep.scrollToBottom();

        //Go to next step
        AddMachineFlowCoolantStep.nextStep();

        //Check visibility blocks on summery step
        AddMachineFlowSummaryStep.scrollToCoolantBlock();

        Assert.assertTrue(AddMachineFlowSummaryStep.machineBlock(), "Machine block is not visible");
        Assert.assertTrue(AddMachineFlowSummaryStep.coolantBlock(),"Coolant block is not visible");
        Assert.assertTrue(AddMachineFlowSummaryStep.measurementConfigurationBlock(), "Configuration block is not visible");

        //Scroll to bottom
        AddMachineFlowSummaryStep.scrollToBottom();

        //Create machine
        AddMachineFlowSummaryStep.finish();

    }

    @Test(priority = 2)
    public void addMachineWithSpecialistsTest() {
        log.info("Positive add machine with specialists test Started");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        //Execute log in
        logInPage.logIn("pevacem@mailinator.com", "Pa$$w0rd!");

        // Open the Machines page
        HomePage.coolantManagerButton();

        // Coolant header is visible
        Assert.assertTrue(CoolantManagerPage.isMachinePageTitleVisible(), "Machine page title is not visible");

        // Open AddMachine flow
        CoolantManagerPage.plusButton();
        CoolantManagerPage.addMachineButton();

        //Machine Step
        // AddMachine page title is visible
        Assert.assertEquals(AddMachineFlowMachineStep.getPageUrl(), AddMachineFlowMachineStep.getCurrentUrl());

        //Select Machine brand
        AddMachineFlowMachineStep.selectBrandField();

        Assert.assertTrue(AddMachineFlowMachineStep.brandListIsShown(), "Brand list is not visitable");
        Assert.assertTrue(AddMachineFlowMachineStep.machineBrandVisible(), "Brand is not visitable");

        AddMachineFlowMachineStep.selectMachineBrand();


        //Select Machine model
        AddMachineFlowMachineStep.selectModelField();

        Assert.assertTrue(AddMachineFlowMachineStep.modelListIsShown(), "Model list is not visitable");
        Assert.assertTrue(AddMachineFlowMachineStep.machineModelVisible(), "Model is not visitable");

        AddMachineFlowMachineStep.selectMachineModel();

        //Fill fields
        AddMachineFlowMachineStep.firstStep("Auto-test-2", "350");

        //Scroll to the bottom
        AddMachineFlowMachineStep.scrollToBottom();

        //Add coolant specialists
        AddMachineFlowMachineStep.selectCoolantSpecialistDropdown();

        Assert.assertTrue(AddMachineFlowMachineStep.coolantSpecialistList(), "Coolant specialist is not visible");

        AddMachineFlowMachineStep.selectCoolantSpecialist();

        //Add liquidTool specialist
        AddMachineFlowMachineStep.selectLiquidTollSpecialistDropdown();

        Assert.assertTrue(AddMachineFlowMachineStep.liquidToolSpecialistList(), "LT specialist is not visible");

        AddMachineFlowMachineStep.selectLiquidToolSpecialist();

        //Scroll to the bottom
        AddMachineFlowMachineStep.scrollToBottom();

        //Go to next step
        AddMachineFlowMachineStep.nextStep();

        //Get step title
        Assert.assertTrue(AddMachineFlowCoolantStep.coolantBrandTitleField(), "Icon is not visible");

        //Coolant step
        //Select coolant name
        AddMachineFlowCoolantStep.selectCoolantNameDropdown();

        Assert.assertTrue(AddMachineFlowCoolantStep.coolantNameList(), "Coolant name list is not visible");
        Assert.assertTrue(AddMachineFlowCoolantStep.coolantNameVisible(), "Coolant name is not visible");

        AddMachineFlowCoolantStep.selectCoolantName();

        //Fill refractometer
        AddMachineFlowCoolantStep.enterRefractometer("1");

        //Scroll to limits
        AddMachineFlowCoolantStep.scrollTo();

        //Check visibility of limit fields
        Assert.assertTrue(AddMachineFlowCoolantStep.concentrationLimitsFields(), "Concentration fields are not visible");

        //Set limits
        AddMachineFlowCoolantStep.enterLimits("1", "2", "3");

        //Scroll to the bottom
        AddMachineFlowCoolantStep.scrollToBottom();

        //Go to next step
        AddMachineFlowCoolantStep.nextStep();

        //Check visibility blocks on summery step
        AddMachineFlowSummaryStep.scrollToCoolantBlock();

        Assert.assertTrue(AddMachineFlowSummaryStep.machineBlock(), "Machine block is not visible");
        Assert.assertTrue(AddMachineFlowSummaryStep.coolantBlock(),"Coolant block is not visible");
        Assert.assertTrue(AddMachineFlowSummaryStep.measurementConfigurationBlock(), "Configuration block is not visible");

        //Scroll to bottom
        AddMachineFlowSummaryStep.scrollToBottom();

        //Create machine
        AddMachineFlowSummaryStep.finish();

    }

    @Test (priority = 3)
    public void addMachineTestWitAllMeasurementConfigurations() {
        log.info("Positive add machine test Started");

        // open logIn page
        LogInPage logInPage = new LogInPage(driver, log);
        logInPage.openPage();

        //Execute log in
        logInPage.logIn("pevacem@mailinator.com", "Pa$$w0rd!");

        // Open the Machines page
        HomePage.coolantManagerButton();

        // Coolant header is visible
        Assert.assertTrue(CoolantManagerPage.isMachinePageTitleVisible(), "Machine page title is not visible");

        // Open AddMachine flow
        CoolantManagerPage.plusButton();
        CoolantManagerPage.addMachineButton();

        //Machine Step
        // AddMachine page title is visible
        Assert.assertEquals(AddMachineFlowMachineStep.getPageUrl(), AddMachineFlowMachineStep.getCurrentUrl());

        //Select Machine brand
        AddMachineFlowMachineStep.selectBrandField();

        Assert.assertTrue(AddMachineFlowMachineStep.brandListIsShown(), "Brand list is not visitable");
        Assert.assertTrue(AddMachineFlowMachineStep.machineBrandVisible(), "Brand is not visitable");

        AddMachineFlowMachineStep.selectMachineBrand();


        //Select Machine model
        AddMachineFlowMachineStep.selectModelField();

        Assert.assertTrue(AddMachineFlowMachineStep.modelListIsShown(), "Model list is not visitable");
        Assert.assertTrue(AddMachineFlowMachineStep.machineModelVisible(), "Model is not visitable");

        AddMachineFlowMachineStep.selectMachineModel();

        //Fill fields
        AddMachineFlowMachineStep.firstStep("Auto-test-3", "300");

        //Scroll to the bottom
        AddMachineFlowMachineStep.scrollToBottom();

        //Go to next step
        AddMachineFlowMachineStep.nextStep();

        //Get step title
        Assert.assertTrue(AddMachineFlowCoolantStep.coolantBrandTitleField(), "Icon is not visible");

        //Coolant step
        //Select coolant name
        AddMachineFlowCoolantStep.selectCoolantNameDropdown();

        Assert.assertTrue(AddMachineFlowCoolantStep.coolantNameList(), "Coolant name list is not visible");
        Assert.assertTrue(AddMachineFlowCoolantStep.coolantNameVisible(), "Coolant name is not visible");

        AddMachineFlowCoolantStep.selectCoolantName();

        //Fill refractometer
        AddMachineFlowCoolantStep.enterRefractometer("1");

        //Scroll to limits
        AddMachineFlowCoolantStep.scrollTo();

        //Accept Cookies
        AddMachineFlowCoolantStep.acceptCookies();

        //Check visibility of limit fields
        Assert.assertTrue(AddMachineFlowCoolantStep.concentrationLimitsFields(), "Concentration fields are not visible");

        //Set Temperature, pH, Hardness, Nitrite, Conductivity limits
        //Select all checkboxes
        AddMachineFlowCoolantStep.selectAllCheckBoxes();

        //Verify all checkboxes are selected
        Assert.assertTrue(AddMachineFlowCoolantStep.areAllCheckBoxesSelected(), "No all checkboxes are selected");

        //Enter all limits
        AddMachineFlowCoolantStep.enterLimitsInAllFields("1", "2", "3",
                "1", "2", "1", "2", "1", "2", "1",
                "1", "2");

        //Scroll to the bottom
        AddMachineFlowCoolantStep.scrollToBottom();

        //Go to next step
        AddMachineFlowCoolantStep.nextStep();

        //Check visibility blocks on summery step
        AddMachineFlowSummaryStep.scrollToCoolantBlock();

        Assert.assertTrue(AddMachineFlowSummaryStep.machineBlock(), "Machine block is not visible");
        Assert.assertTrue(AddMachineFlowSummaryStep.coolantBlock(), "Coolant block is not visible");
        Assert.assertTrue(AddMachineFlowSummaryStep.measurementConfigurationBlock(), "Configuration block is not visible");

        //Scroll to bottom
        AddMachineFlowSummaryStep.scrollToBottom();

        //Create machine
        AddMachineFlowSummaryStep.finish();

    }

}
