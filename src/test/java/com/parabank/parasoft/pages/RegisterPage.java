package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage fillFirstname(String firstName) {
        getWebElement(By.id("customer.firstName")).sendKeys(firstName);

        return this;
    }

    public RegisterPage fillLastname(String lastName) {
        getWebElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(lastName);

        return this;
    }

    public RegisterPage fillAddress(String address) {
        getWebElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(address);

        return this;
    }

    public RegisterPage fillCity(String city) {
        getWebElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);

        return this;
    }

    public RegisterPage fillState(String state) {
        getWebElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);

        return this;
    }

    public RegisterPage fillZipCode(String zipCode) {
        getWebElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(String.valueOf(zipCode));

        return this;
    }

    public RegisterPage fillPhoneNumber(String phoneNumber) {
        getWebElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(String.valueOf(phoneNumber));

        return this;
    }

    public RegisterPage fillSsn(String ssn) {
        getWebElement(By.id("customer.ssn")).sendKeys(ssn);

        return this;
    }

    public RegisterPage fillUsername(String username) {
        getWebElement(By.id("customer.username")).sendKeys(username);

        return this;
    }

    public RegisterPage fillPassword(String password) {
        getWebElement(By.id("customer.password")).sendKeys(password);

        return this;
    }

    public RegisterPage fillConfirmPassword(String confirmPassword) {
        getWebElement(By.id("repeatedPassword")).sendKeys(confirmPassword);

        return this;
    }

    /**
     * Basically it returns into another page, but we are redirecting it into AccountOverview page
     * @return
     */
    public AccountOverviewPage clickRegisterBtn() {
        getWebElement(By.cssSelector("input.button[value='Register']")).click();

        return getInstance(AccountOverviewPage.class);
    }

    public boolean hasError() {
        return !getWebElements(By.className("error")).isEmpty();
    }

    public int numberOfErrors() {
        return getWebElements(By.className("error")).size();
    }

    public RegisterPage clickRegisterBtnWithoutFillingRequiredFields() {
        getWebElement(By.cssSelector("input.button[value='Register']")).click();

        return this;
    }
}
