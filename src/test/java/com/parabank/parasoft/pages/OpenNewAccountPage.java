package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    // Finds and list your web elements(actions) of your page first and based on the behaviour you have to decide what will be the return type (same page/ different page)

    public OpenNewAccountPage selectAccountTypes(String accountType) {
        WebElement selectType = getWebElement(By.xpath("//select[@id='type']"));
        new Select(selectType).selectByVisibleText(accountType);

        return this;
    }

    public OpenNewAccountPage accountNumber(int index) {
       new Select(getWebElement(By.xpath("//select[@id='fromAccountId']"))).selectByIndex(index);

        return this;
    }

    public AccountOpenedPage clickOpenAccountBtn() {
        getWebElement(By.xpath("//input[@value='Open New Account']")).click();

        return getInstance(AccountOpenedPage.class);
    }
}
