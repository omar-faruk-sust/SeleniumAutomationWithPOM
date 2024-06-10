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
}
