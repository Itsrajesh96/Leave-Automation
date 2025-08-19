package com.employeegalaxy.tests;

import com.employeegalaxy.pages.BaseTest;
import com.employeegalaxy.pages.LeavePage;
import com.employeegalaxy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateLeaveTest extends BaseTest {
    @Test
    public void testCreateLeave() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("rajeshvariganji@gmail.com", "nDynTgmJ");

        LeavePage leavePage = new LeavePage(driver);
        leavePage.openLeavesPage();
        leavePage.createLeave("08/20/2025", "08/21/2025", "Sick");

        Assert.assertTrue(leavePage.isLeavePresent("08/20/2025", "08/21/2025"), "Leave not created!");
    }
}
