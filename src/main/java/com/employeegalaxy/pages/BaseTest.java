package com.employeegalaxy.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage"); // fixes shared memory issues in CI
        options.addArguments("--no-sandbox");            // required in GitHub Actions
        options.addArguments("--headless=new");          // headless mode for CI/CD
        options.addArguments("--disable-gpu");           // optional, for stability
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get("https://employeegalaxy.com/login"); // ✅ ensure login page is opened
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
