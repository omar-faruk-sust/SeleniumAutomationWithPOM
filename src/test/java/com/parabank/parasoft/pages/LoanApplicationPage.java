package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoanApplicationPage extends BasePage {

    public LoanApplicationPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasErrorAfterSubmit() {
        WebElement error = getWebElement(By.cssSelector("div[id='requestLoanError']"));
        String errorMessage = error.findElement(By.cssSelector("h1[class='title']")).getText().trim();
        boolean isStyleEmpty = error.getAttribute("style").isEmpty();

        return isStyleEmpty && errorMessage.equalsIgnoreCase("Error!");
    }

    public LoanApplicationPage fillLoanAmount(float loanAmount) {
        By selector = By.id("amount");
        waitForElement(selector);
        getWebElement(selector).sendKeys(String.valueOf(loanAmount));

        return this;
    }

    public LoanApplicationPage fillDownPayment(float downPayment) {
        By selector = By.id("downPayment");
        waitForElement(selector);
        getWebElement(selector).sendKeys(String.valueOf(downPayment));

        return this;
    }

    public LoanApplicationPage selectAccount(int index) {
        By selector = By.id("fromAccountId");
        waitForElement(selector);
        new Select(getWebElement(selector)).selectByIndex(index);

        return this;
    }

    public LoanApplicationPage clickApplyBtn() {
        By selector = By.cssSelector("input[value='Apply Now']");
        waitForElement(selector);

        getWebElement(selector).click();
        return this;
    }

    public boolean hasLoanRetestSuccessful() {
        WebElement element = getWebElement(By.cssSelector("div[id='requestLoanResult']"));
        boolean message = element.findElement(By.cssSelector("h1[class='title']")).getText().trim().equalsIgnoreCase("Loan Request Processed");
        boolean isStyleEmpty = element.getAttribute("style").isEmpty();
        boolean loanStatus = getWebElement(By.xpath("//td[@id='loanStatus']")).getText().trim().equalsIgnoreCase("Approved");

        return isStyleEmpty && message && loanStatus;
    }
}
