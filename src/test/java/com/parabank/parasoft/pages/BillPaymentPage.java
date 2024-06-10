package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BillPaymentPage extends BasePage {

    public BillPaymentPage(WebDriver driver) {
        super(driver);
    }

    public BillPaymentPage fillPayeeName(String payeeName) {
        getWebElement(By.cssSelector("input[name='payee.name']")).sendKeys(payeeName);

        return this;
    }

    public BillPaymentPage fillAddress(String address) {
        getWebElement(By.cssSelector("input[name='payee.address.street']")).sendKeys(address);

        return this;
    }

    public BillPaymentPage fillCity(String city) {
        getWebElement(By.cssSelector("input[name='payee.address.city']")).sendKeys(city);

        return this;
    }

    public BillPaymentPage fillState(String state) {
        getWebElement(By.cssSelector("input[name='payee.address.state']")).sendKeys(state);

        return this;
    }

    public BillPaymentPage fillZipCode(String zipCode) {
        getWebElement(By.cssSelector("input[name='payee.address.zipCode']")).sendKeys(zipCode);

        return this;
    }

    public BillPaymentPage fillPhone(String phone) {
        getWebElement(By.cssSelector("input[name='payee.phoneNumber']")).sendKeys(phone);

        return this;
    }

    public BillPaymentPage fillPayeeAccount(String account) {
        By payeeAccountSelector = By.cssSelector("input[name='payee.accountNumber']");
        waitForElement(payeeAccountSelector);

        getWebElement(payeeAccountSelector).sendKeys(account);

        return this;
    }

    public BillPaymentPage fillPayeeReAccount(String reAccount) {
        By verifyAccountSelector = By.cssSelector("input[name='verifyAccount']");
        waitForElement(verifyAccountSelector);

        getWebElement(verifyAccountSelector).sendKeys(reAccount);

        return this;
    }

    public BillPaymentPage fillAmount(double amount) {
        getWebElement(By.cssSelector("input[name='amount']")).sendKeys(String.valueOf(amount));

        return this;
    }

    public BillPaymentPage fillInvalidAmount(String amount) {
        getWebElement(By.cssSelector("input[name='amount']")).sendKeys(amount);

        return this;
    }

    public BillPaymentPage selectFromAccount(int index) {
        By accountSelector = By.cssSelector("select[name='fromAccountId']");
        waitForElement(accountSelector);

        new Select(getWebElement(accountSelector)).selectByIndex(index);
        return this;
    }

    public BillPaymentPage clickSendPaymentBtnWithoutRequiredData() {
        getWebElement(By.cssSelector("input[value='Send Payment']")).click();

        return this;
    }

    /**
     * need to find a way to capture all errors with this function
     * @return
     */
    public boolean hasErrorOfNotFillUpRequiredField() {
        return getWebElements(By.xpath("//span[@id^='validationModel-']")).size() > 0;
    }

    public boolean hasPayeeNameRequiredFieldError() {
        WebElement payeeNameError = getWebElement(By.id("validationModel-name"));
        if (payeeNameError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasAddressRequiredFieldError() {
        WebElement payeeNameError = getWebElement(By.id("validationModel-address"));
        if (payeeNameError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasCityRequiredFieldError() {
        WebElement cityError = getWebElement(By.id("validationModel-city"));
        if (cityError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasStateRequiredFieldError() {
        WebElement stateError = getWebElement(By.id("validationModel-state"));
        if (stateError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasZipCodeErrorRequiredFieldError() {
        WebElement zipCodeError = getWebElement(By.id("validationModel-zipCode"));
        if (zipCodeError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasPhoneNumberErrorRequiredFieldError() {
        WebElement phoneNumberCodeError = getWebElement(By.id("validationModel-phoneNumber"));
        if (phoneNumberCodeError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasPayeeAccountRequiredFieldError() {
        WebElement accountNumberError = getWebElement(By.id("validationModel-account-empty"));
        if (accountNumberError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasPayeeAccountInvalidFieldError() {
        WebElement accountNumberError = getWebElement(By.id("validationModel-account-invalid"));
        if (accountNumberError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasVerifyErrorRequiredFieldError() {
        WebElement verifyAccountError = getWebElement(By.id("validationModel-verifyAccount-empty"));
        if (verifyAccountError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasVerifyAccountInvalidFieldError() {
        WebElement accountNumberError = getWebElement(By.id("validationModel-verifyAccount-invalid"));
        if (accountNumberError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasVerifyAccountMismatchError() {
        WebElement accountNumberError = getWebElement(By.id("validationModel-verifyAccount-mismatch"));
        if (accountNumberError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasAmountEmptyErrorRequiredFieldError() {
        WebElement amountError = getWebElement(By.id("validationModel-amount-empty"));
        if (amountError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public boolean hasAmountInvalidErrorFieldError() {
        WebElement amountError = getWebElement(By.id("validationModel-amount-invalid"));
        if (amountError.getAttribute("style").isEmpty() ) {
            return true;
        }
        return false;
    }

    public BillPaymentPage clickSendPaymentBtn() {
        getWebElement(By.cssSelector("input[value='Send Payment']")).click();

        return this;
    }

    public boolean hasBillPaymentComplete() throws InterruptedException {
        Thread.sleep(2000);
        By selectorOfTitle = By.cssSelector("div[id='billpayResult'] h1[class='title']");
        waitForElement(selectorOfTitle);
        String pageTitle = getWebElement(selectorOfTitle).getText();

        Assert.assertEquals("Bill Payment Complete", pageTitle);

        return true;
    }

    /**
     * This method is redundant still keeping it just to check purpose
     * @return
     */
    public BillPaymentPage clickPaymentBtnWithAllData() {
        getWebElement(By.cssSelector("input[value='Send Payment']")).click();
        return this;
    }

    public boolean hasErrorAfterSendPayment() {
        return !getWebElements(By.cssSelector("div[id='billpayError'] h1[class='title']")).isEmpty();
    }
}
