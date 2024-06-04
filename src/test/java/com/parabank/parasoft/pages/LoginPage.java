package com.parabank.parasoft.pages;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * After fillup the username we stay at the login page so return page LoginPage
     * @param username
     */
    public LoginPage fillUsername(String username) {
        getWebElement(By.xpath("//input[@name='username']")).sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getWebElement(By.xpath("//input[@name='password']")).sendKeys(password);
        return this;
    }

    /**
     * This is successful case
     * @return
     */
    public AccountOverviewPage clickLoginBtn() {
        getWebElement(By.cssSelector("input[value='Log In']")).click();
        return getInstance(AccountOverviewPage.class);
    }

    /**
     * This is for error case
     * @return
     */
    public LoginPage clickLoginLinkBtn() {
        getWebElement(By.cssSelector("input[value='Log In']")).click();
        return this;
    }

    public CustomerLookupPage clickForgetPassLink() {
        getWebElement(By.cssSelector("a[href='lookup.htm']")).click();
        return getInstance(CustomerLookupPage.class);
    }

    public RegisterPage clickRegistrationLink() {
        getWebElement(By.cssSelector("a[href='register.htm']")).click();
        return getInstance(RegisterPage.class);
    }

    public boolean hasError() {
        return getWebElements(By.className("error")).size() > 0;
    }

}
