package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateProfilePage extends BasePage {

    public UpdateProfilePage(WebDriver driver) {
        super(driver);
    }

    public UpdateProfilePage fillFirstName(String firstName) {
        By selector = By.xpath("//input[@id='customer.firstName']");
        waitForElement(selector);
        inputClearOrSend(firstName, getWebElement(selector));
        return this;
    }

    public UpdateProfilePage fillLastName(String lastName) {
        By selector = By.xpath("//input[@id='customer.lastName']");
        waitForElement(selector);
        inputClearOrSend(lastName, getWebElement(selector));
        return this;
    }

    public UpdateProfilePage fillAddress(String address) {
        By selector = By.xpath("//input[@id='customer.address.street']");
        inputClearOrSend(address, getWebElement(selector));
        return this;
    }

    public UpdateProfilePage fillCity(String city) {
        By selector = By.xpath("input[name='customer.address.city']");
        inputClearOrSend(city, getWebElement(selector));
        return this;
    }

    public UpdateProfilePage fillState(String state) {
        By selector = By.xpath("input[name='customer.address.state']");
        inputClearOrSend(state, getWebElement(selector));
        return this;
    }

    public UpdateProfilePage fillZipCode(String zipCode) {
        By selector = By.xpath("input[name='customer.address.zipCode']");
        inputClearOrSend(zipCode, getWebElement(selector));
        return this;
    }

    public UpdateProfilePage fillPhone(String phone) {
        By selector = By.xpath("input[name='customer.phoneNumber']");
        inputClearOrSend(phone, getWebElement(selector));
        return this;
    }

    public boolean hasCustomerFirstNameRequiredFieldError() {
        return hasRequiredError(getWebElement(By.id("firstName-error")));
    }

    public boolean hasCustomerLastNameRequiredFieldError() {
        return hasRequiredError(getWebElement(By.id("lastName-error")));
    }

    public boolean hasCustomerAddressRequiredFieldError() {
        return hasRequiredError(getWebElement(By.id("street-error")));
    }

    public boolean hasCustomerCityRequiredFieldError() {
        return hasRequiredError(getWebElement(By.id("city-error")));
    }

    public boolean hasCustomerStateRequiredFieldError() {
        return hasRequiredError(getWebElement(By.id("state-error")));
    }

    public boolean hasCustomerZipCodeErrorRequiredFieldError() {
        return hasRequiredError(getWebElement(By.id("zipCode-error")));
    }

    /**
     * this is a common method to check if an error message is shown or not
     * @return boolean
     */
    private static boolean hasRequiredError(WebElement errorElement) {
        return errorElement.getAttribute("style").isEmpty();
    }

    public boolean hasProfileUpdated() {
        return getWebElements(By.cssSelector("div[id='zipCode-error'] h1[class='error']")).size() > 0;
    }

    public UpdateProfilePage clickUpdateProfileBtn() {
        By btnSelector = By.cssSelector("input[value='Update Profile']");
        waitForElement(btnSelector);
        getWebElement(btnSelector).click();
        return this;
    }

    private static void inputClearOrSend(String inputValue, WebElement inputWebElement) {
        if(inputValue.isEmpty()) {
            inputWebElement.clear();
        } else {
            inputWebElement.sendKeys(inputValue);
        }
    }
}
