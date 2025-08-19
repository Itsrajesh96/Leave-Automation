package com.employeegalaxy.tests;

import com.employeegalaxy.pages.BaseTest;
import com.employeegalaxy.pages.LeavePage;
import com.employeegalaxy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateLeaveTest extends BaseTest {
    @Test
    public void testUpdateLeave() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("rajeshvariganji@gmail.com", "nDynTgmJ");

        LeavePage leavePage = new LeavePage(driver);
        leavePage.openLeavesPage();
        leavePage.updateLeave("08/20/2025", "08/22/2025");

        Assert.assertTrue(leavePage.isLeavePresent("08/22/2025", "08/21/2025"), "Leave not updated!");
    }
}
