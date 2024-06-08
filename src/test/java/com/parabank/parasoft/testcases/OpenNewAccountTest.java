package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.AccountOpenedPage;
import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.util.Common;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {

    @Test(priority = 1)
    public void openAccountShouldSucceed() {
        LoginPage loginPage = page.getInstance(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), Common.LOGIN_TITLE);

        AccountOverviewPage accountOverviewPage = loginPage.doLogin(getUsername(), getPassword());
        Assert.assertTrue(accountOverviewPage.hasLogoutLink());

        AccountOpenedPage accountOpenedPage = accountOverviewPage
                .clickOpenAccountLink()
                .selectAccountTypes(Common.CHECKING)
                .accountNumber(1)
                .clickOpenAccountBtn();
        Assert.assertTrue(accountOpenedPage.hasAccountId());
    }

    @Test(enabled = false)
    public void openAccountShouldSucceed2() {
        AccountOpenedPage accountOpenedPage = page.getInstance(LoginPage.class)
                .doLogin(getUsername(), getPassword())
                .clickOpenAccountLink()
                .selectAccountTypes(Common.CHECKING)
                .accountNumber(1)
                .clickOpenAccountBtn();
        Assert.assertTrue(accountOpenedPage.hasAccountId());
    }
}
