package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.TransferFundsPage;
import com.parabank.parasoft.util.Common;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    @Test(enabled = true, priority = 1)
    public void transferShouldSucceed() throws InterruptedException {

        AccountOverviewPage accountOverviewPage = loginAndGetAccountOverviewPage();

        Thread.sleep(3000);

        TransferFundsPage fundsPage = accountOverviewPage
                .clickTransferFundLink()
                .fillAmount(0.5F)
                .selectFromAccount(0)
                .selectToAccount(1)
                .clickTransferBtn();

        Assert.assertTrue(fundsPage.hasComplete());
    }

    @Test(enabled = true, priority = 2)
    public void transferShouldNotBeSuccessfulWithoutAmount(){
        AccountOverviewPage accountOverviewPage = loginAndGetAccountOverviewPage();

        TransferFundsPage transferFundsPage = accountOverviewPage
                .clickTransferFundLink()
                .clickTransferBtn();

        Assert.assertTrue(transferFundsPage.hasError());
    }
}
