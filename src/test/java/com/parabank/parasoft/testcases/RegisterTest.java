package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.AccountOverviewPage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.RegisterPage;
import com.parabank.parasoft.util.SSNGenerator;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registrationShouldFailWithoutData() {
        RegisterPage registerPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .clickRegisterBtnWithoutFillingRequiredFields();

        Assert.assertTrue(registerPage.hasError());
        Assert.assertNotEquals(0, registerPage.numberOfErrors());
    }

    @Test
    public void registrationShouldFailWithOnlyFirstname() {
        RegisterPage registerPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillFirstname(LoremIpsum.getInstance().getFirstName())
                .clickRegisterBtnWithoutFillingRequiredFields();

        Assert.assertTrue(registerPage.hasError());
        Assert.assertNotEquals(1, registerPage.numberOfErrors());
    }

    public void registrationShouldFailWithOnlyLastname() {
        RegisterPage registerPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillLastname(LoremIpsum.getInstance().getLastName())
                .clickRegisterBtnWithoutFillingRequiredFields();

        Assert.assertTrue(registerPage.hasError());
        Assert.assertNotEquals(1, registerPage.numberOfErrors());
    }

    @Test
    public void registrationShouldSuccessful() {
        //Login -> click register -> fill infos -> click register btn -> redirect AccountOverview page

        AccountOverviewPage accountOverviewPage = page.getInstance(LoginPage.class)
                .clickRegistrationLink()
                .fillFirstname(dataFaker.getFirstName())
                .fillLastname(dataFaker.getLastName())
                .fillAddress(dataFaker.getTitle(5))
                .fillCity(dataFaker.getCity())
                .fillState(dataFaker.getStateFull())
                .fillZipCode((dataFaker.getZipCode()))
                .fillPhoneNumber(dataFaker.getPhone())
                .fillSsn(SSNGenerator.generateRandomSSN())
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .fillConfirmPassword(getPassword())
                .clickRegisterBtn();

        Assert.assertTrue(accountOverviewPage.hasLogoutLink());
    }
}
