package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage {
    AccountOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogoutLink() {
        return !getWebElements(By.cssSelector("a[href='logout.htm']")).isEmpty();
    }

    // Login --> fill username, pass, click (successful) --> AccountOverview -> OpenNewAccount
    public OpenNewAccountPage clickOpenAccountLink() {
        getWebElement(By.cssSelector("a[href='openaccount.htm']")).click();

        return getInstance(OpenNewAccountPage.class);
    }

    // Login --> fill username, pass, click (successful) --> AccountOverview -> TransferFundsPage
    public TransferFundsPage clickTransferFundLink() {
        getWebElement(By.cssSelector("a[href='transfer.htm']")).click();

        return getInstance(TransferFundsPage.class);
    }

    public BillPaymentPage clickBillPaymentLink() {
        By selector = By.cssSelector("a[href='billpay.htm']");
        waitForElement(selector);
        getWebElement(selector).click();

        return getInstance(BillPaymentPage.class);
    }
}
