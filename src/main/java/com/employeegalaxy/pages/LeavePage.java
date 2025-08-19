package com.employeegalaxy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeavePage {
    private WebDriver driver;

    // Locators
    private By menuIcon = By.xpath("//svg[@data-testid='MenuIcon']");
    private By leavesOption = By.xpath("//span[text()='Leaves']");
    private By startDate = By.xpath("//input[@id=':r4h:']");
    private By endDate = By.xpath("//input[@id=':r4k:']");
    private By leaveTypeDropdown = By.id("mui-component-select-leaveType");
    private By leaveTypeOptions = By.xpath("//li[@role='option']");
    private By submitBtn = By.xpath("//button[@type='submit' and contains(text(),'Submit')]");

    // Table Data
    private By tableRows = By.xpath("//div[@role='row' and @data-rowindex]");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLeavesPage() {
        driver.findElement(menuIcon).click();
        driver.findElement(leavesOption).click();
    }

    public void createLeave(String start, String end, String type) {
        driver.findElement(startDate).sendKeys(start);
        driver.findElement(endDate).sendKeys(end);
        driver.findElement(leaveTypeDropdown).click();

        List<WebElement> options = driver.findElements(leaveTypeOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(type)) {
                option.click();
                break;
            }
        }
        driver.findElement(submitBtn).click();
    }

    public boolean isLeavePresent(String start, String end) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(start) && row.getText().contains(end)) {
                return true;
            }
        }
        return false;
    }

    public void updateLeave(String oldStart, String newStart) {
        WebElement row = driver.findElement(By.xpath("//div[contains(text(),'" + oldStart + "')]/ancestor::div[@role='row']"));
        row.findElement(By.xpath(".//button[contains(text(),'Edit')]")).click();
        WebElement startField = driver.findElement(startDate);
        startField.clear();
        startField.sendKeys(newStart);
        driver.findElement(submitBtn).click();
    }

    public void deleteLeave(String start) {
        WebElement row = driver.findElement(By.xpath("//div[contains(text(),'" + start + "')]/ancestor::div[@role='row']"));
        row.findElement(By.xpath(".//button[contains(text(),'Delete')]")).click();
    }
}
