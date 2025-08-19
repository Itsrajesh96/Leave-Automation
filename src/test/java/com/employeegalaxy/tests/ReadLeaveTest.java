package com.employeegalaxy.tests;

import com.employeegalaxy.pages.BaseTest;
import com.employeegalaxy.pages.LeavePage;
import com.employeegalaxy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadLeaveTest extends BaseTest {
    @Test
    public void testReadLeave() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("rajeshvariganji@gmail.com", "nDynTgmJ");

        LeavePage leavePage = new LeavePage(driver);
        leavePage.openLeavesPage();

        Assert.assertTrue(leavePage.isLeavePresent("08/20/2025", "08/21/2025"), "Leave not found in table!");
    }
}
