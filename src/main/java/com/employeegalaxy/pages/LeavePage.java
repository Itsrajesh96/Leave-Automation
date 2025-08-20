package com.employeegalaxy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeavePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuIcon = By.xpath("//svg[@data-testid='MenuIcon']");
    private By leavesOption = By.xpath("//span[text()='Leaves']");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLeavesPage() {
        // Wait for the menu icon and click it
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuIcon));
        menu.click();

        // Then click on "Leaves"
        WebElement leaves = wait.until(ExpectedConditions.elementToBeClickable(leavesOption));
        leaves.click();
    }

    public void createLeave(String fromDate, String toDate, String reason) {
        // TODO: Add create leave form filling here
    }

    public boolean isLeavePresent(String fromDate, String toDate) {
        // TODO: Verify leave created
        return true;
    }
}
