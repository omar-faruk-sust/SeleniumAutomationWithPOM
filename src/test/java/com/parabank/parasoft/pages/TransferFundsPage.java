package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TransferFundsPage extends BasePage {

    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public TransferFundsPage fillAmount(float amount) {
        getWebElement(By.cssSelector("#amount")).sendKeys(String.valueOf(amount));

        return this;
    }

    public TransferFundsPage selectFromAccount(int index) {

        By fromAccountSelector = By.cssSelector("#fromAccountId");
        waitForElement(fromAccountSelector);
        new Select(getWebElement(fromAccountSelector)).selectByIndex(index);

        return this;
    }

    public TransferFundsPage selectToAccount(int index) {
        By toAccountSelector = By.cssSelector("#fromAccountId");
        waitForElement(toAccountSelector);
        new Select(getWebElement(toAccountSelector)).selectByIndex(index);

        return this;
    }

    public TransferFundsPage clickTransferBtn() {
        getWebElement(By.cssSelector("input[value='Transfer']")).click();

        return this;
    }

    public boolean hasComplete() throws InterruptedException {
        Thread.sleep(4000);
        By selectorOfTitle = By.cssSelector("div[id='showResult'] h1[class='title']");
        waitForElement(selectorOfTitle);
        String pageTitle = getWebElement(selectorOfTitle).getText();

        Assert.assertEquals("Transfer Complete!", pageTitle);

        return true;
    }

    public boolean hasError() {
        return !getWebElements(By.xpath("//div[@id='showError']")).isEmpty();
    }
}
