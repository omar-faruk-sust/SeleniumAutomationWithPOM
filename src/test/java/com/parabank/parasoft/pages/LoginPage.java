package com.parabank.parasoft.pages;


import com.parabank.parasoft.util.Common;
import com.parabank.parasoft.util.SSNGenerator;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * After fill-up the username we stay at the login page so return page LoginPage
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

    /**
     * This is a common method is needed for every single page because we need to do successful login
     * To access other pages
     * @param username
     * @param password
     * @return
     */
    public AccountOverviewPage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public AccountOverviewPage doLoginViaRegistration()  {
        LoremIpsum dataFaker = LoremIpsum.getInstance();

        return getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillFirstname(dataFaker.getFirstName())
                .fillLastname(dataFaker.getLastName())
                .fillAddress(dataFaker.getTitle(5))
                .fillCity(dataFaker.getCity())
                .fillState(dataFaker.getStateFull())
                .fillZipCode((dataFaker.getZipCode()))
                .fillPhoneNumber(dataFaker.getPhone())
                .fillSsn(SSNGenerator.generateRandomSSN())
                .fillUsername(Common.USERNAME)
                .fillPassword(Common.PASSWORD)
                .fillConfirmPassword(Common.PASSWORD)
                .clickRegisterBtn();
    }

    public boolean isLogout() {
        return !getWebElements(By.xpath("//h2[contains(text(),'Customer Login')]")).isEmpty();
    }

}
