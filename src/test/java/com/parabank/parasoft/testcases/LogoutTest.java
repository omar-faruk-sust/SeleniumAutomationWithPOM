package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutShouldBeSuccessful() {
       LoginPage loginPage = loginAndGetAccountOverviewPage().clickLogoutLink();

        Assert.assertTrue(loginPage.isLogout());
    }
}
