package com.employeegalaxy.tests;

import com.employeegalaxy.pages.LeavePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateLeaveTest extends TestBase {

    @Test
    public void testCreateLeave() {
        System.out.println("=== Starting Create Leave Test ===");

        // Initialize LeavePage
        LeavePage leavePage = new LeavePage(driver);

        // Step 1: Verify login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.urlContains("dashboard")); // check URL contains "dashboard"
            System.out.println("✅ Login successful, now on: " + driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("❌ Login did not succeed, current page: " + driver.getCurrentUrl());
            Assert.fail("Login failed, cannot proceed with leave creation.");
        }

        // Step 2: Navigate to Leaves page
        try {
            leavePage.openLeavesPage();
            System.out.println("✅ Navigated to Leaves page");
        } catch (Exception e) {
            System.out.println("❌ Could not open Leaves page, element not found.");
            e.printStackTrace();
            Assert.fail("Leaves page navigation failed.");
        }

        // Step 3: Create Leave
        try {
            leavePage.createLeave("Sick Leave", "Fever and rest");
            System.out.println("✅ Leave creation submitted.");
        } catch (Exception e) {
            System.out.println("❌ Leave creation failed.");
            e.printStackTrace();
            Assert.fail("Leave creation step failed.");
        }
    }
}
