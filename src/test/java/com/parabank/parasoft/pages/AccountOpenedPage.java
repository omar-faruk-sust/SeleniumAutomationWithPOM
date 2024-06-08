package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOpenedPage extends BasePage {
    public AccountOpenedPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasAccountId() {
        return !getWebElements(By.xpath("//a[@id='newAccountId']")).isEmpty();
    }

    public AccountDetailsPage clickOpenedAccountLink(){
        getWebElement(By.xpath(("//a[@id='newAccountId']"))).click();
        return getInstance(AccountDetailsPage.class);
    }



}
