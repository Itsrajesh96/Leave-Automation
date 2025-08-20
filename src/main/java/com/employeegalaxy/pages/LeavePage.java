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

    // Example locators – adjust based on your actual DOM
    private By createLeaveBtn = By.xpath("//button[contains(text(),'Create Leave')]");
    private By fromDateInput = By.name("fromDate");
    private By toDateInput = By.name("toDate");
    private By reasonInput = By.name("reason");
    private By saveBtn = By.xpath("//button[contains(text(),'Save')]");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLeavesPage() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuIcon));
        menu.click();
        WebElement leaves = wait.until(ExpectedConditions.elementToBeClickable(leavesOption));
        leaves.click();
    }

    // ✅ CREATE
    public void createLeave(String fromDate, String toDate, String reason) {
        wait.until(ExpectedConditions.elementToBeClickable(createLeaveBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput)).sendKeys(fromDate);
        driver.findElement(toDateInput).sendKeys(toDate);
        driver.findElement(reasonInput).sendKeys(reason);
        driver.findElement(saveBtn).click();
    }

    // ✅ READ
    public boolean isLeavePresent(String fromDate, String toDate) {
        // Simplified locator - adjust to your table/list
        By leaveRow = By.xpath("//td[contains(text(),'" + fromDate + "') and following-sibling::td[contains(text(),'" + toDate + "')]]");
        return driver.findElements(leaveRow).size() > 0;
    }

    // ✅ UPDATE
    public void updateLeave(String oldReason, String newReason) {
        By editBtn = By.xpath("//td[contains(text(),'" + oldReason + "')]/following-sibling::td//button[contains(text(),'Edit')]");
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
        WebElement reasonField = wait.until(ExpectedConditions.visibilityOfElementLocated(reasonInput));
        reasonField.clear();
        reasonField.sendKeys(newReason);
        driver.findElement(saveBtn).click();
    }

    // ✅ DELETE
    public void deleteLeave(String reason) {
        By deleteBtn = By.xpath("//td[contains(text(),'" + reason + "')]/following-sibling::td//button[contains(text(),'Delete')]");
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

        // Confirm delete (if there’s a dialog)
        By confirmDelete = By.xpath("//button[contains(text(),'Confirm') or contains(text(),'Yes')]");
        if (driver.findElements(confirmDelete).size() > 0) {
            driver.findElement(confirmDelete).click();
        }
    }
}
