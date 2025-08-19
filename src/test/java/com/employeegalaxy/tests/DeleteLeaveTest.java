package com.employeegalaxy.tests;

import com.employeegalaxy.pages.BaseTest;
import com.employeegalaxy.pages.LeavePage;
import com.employeegalaxy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteLeaveTest extends BaseTest {
    @Test
    public void testDeleteLeave() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("rajeshvariganji@gmail.com", "nDynTgmJ");

        LeavePage leavePage = new LeavePage(driver);
        leavePage.openLeavesPage();
        leavePage.deleteLeave("08/22/2025");

        Assert.assertFalse(leavePage.isLeavePresent("08/22/2025", "08/21/2025"), "Leave not deleted!");
    }
}
