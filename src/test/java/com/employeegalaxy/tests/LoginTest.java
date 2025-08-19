package com.employeegalaxy.tests;

import com.employeegalaxy.pages.BaseTest;
import com.employeegalaxy.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("rajeshvariganji@gmail.com", "nDynTgmJ");
    }
}
