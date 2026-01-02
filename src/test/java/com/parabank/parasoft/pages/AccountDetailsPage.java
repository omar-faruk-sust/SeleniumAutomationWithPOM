package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

public class AccountDetailsPage extends BasePage {
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    //TODO why debugging is passed but running is getting failed!
    public boolean isLoadedCorrectAccountDetails() throws InterruptedException {
        By selector = By.xpath("//td[@id='accountId']");

        String accountNumber = getWebElement(selector).getText();
        String currentUrl = driver.getCurrentUrl();

        // Extract query parameters
        Map<String, String> queryParams = Common.getQueryParams(currentUrl);
        Thread.sleep(5000);
        // Print the parameters
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            if (entry.getValue().trim().equalsIgnoreCase(accountNumber)) {
                return true;
            }
        }

        return false;
    }

    public AccountDetailsPage selectAccountActivityPeriod(String month) {
        By selector = By.xpath("//select[@id='month']");
        waitForElement(selector);
        new Select(getWebElement(selector)).selectByVisibleText(month);

        return this;
    }

    public AccountDetailsPage selectAccountActivityType(int index) {
        By selector = By.xpath("//select[@id='transactionType']");
        waitForElement(selector);
        new Select(getWebElement(selector)).selectByIndex(index);

        return this;
    }

    public AccountDetailsPage clickFindActivityBtn() {
        By selector = By.xpath("//input[@value='Go']");
        waitForElement(selector);
        getWebElement(selector).click();

        return this;
    }

    public boolean noActivityRecord() {
        return getWebElement(By.xpath("//p[@id='noTransactions']/b")).getText().trim().equalsIgnoreCase("No transactions found.");
    }

    public boolean hasActivityRecord() {
        return getWebElements(By.cssSelector("table[id='transactionTable'] tbody tr")).size() > 0;
    }
}
