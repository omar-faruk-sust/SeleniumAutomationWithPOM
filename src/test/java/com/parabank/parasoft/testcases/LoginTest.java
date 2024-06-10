package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.util.Common;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void doLoginWithUsernameShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        loginPage = loginPage.fillUsername(getUsername()).clickLoginLinkBtn();

        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void doLoginWithPasswordShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        loginPage = loginPage.fillPassword(getPassword()).clickLoginLinkBtn();

        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void doLoginShouldFail() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        loginPage = loginPage.clickLoginLinkBtn();

        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void doLoginShouldSucceed() {
        //Login->fill info -> AccountOverview
        LoginPage loginPage = page.getInstance(LoginPage.class);
        AccountOverviewPage overviewPage = loginPage.fillUsername(getUsername()).fillPassword(getPassword()).clickLoginBtn();
        Assert.assertTrue(overviewPage.hasLogoutLink());
    }

    @Test
    public void checkTitle() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), Common.LOGIN_TITLE);
    }
}
