package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.UpdateProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest extends BaseTest {

    @Test(priority = 1)
    public void profileUpdateShouldFailWithEmptyFirstName() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillFirstName("")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasCustomerFirstNameRequiredFieldError());
    }

    @Test(priority = 2)
    public void profileUpdateShouldFailWithEmptyLastName() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillLastName("")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasCustomerLastNameRequiredFieldError());
    }

    @Test(priority = 3)
    public void profileUpdateShouldFailWithEmptyAddress() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillAddress("")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasCustomerAddressRequiredFieldError());
    }

    @Test(priority = 4)
    public void profileUpdateShouldFailWithEmptyCity() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillCity("")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasCustomerCityRequiredFieldError());
    }

    @Test(priority = 5)
    public void profileUpdateShouldFailWithEmptyState() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillState("")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasCustomerStateRequiredFieldError());
    }

    @Test(priority = 6)
    public void profileUpdateShouldFailWithEmptyZipCode() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillZipCode("")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasCustomerZipCodeErrorRequiredFieldError());
    }

    @Test(priority = 6)
    public void profileUpdateShouldSuccessful() {
        UpdateProfilePage updateProfilePage = loginAndGetAccountOverviewPage()
                .clickUpdateContactInfoLink()
                .fillFirstName(dataFaker.getFirstName())
                .fillLastName(dataFaker.getLastName())
                .fillAddress(dataFaker.getTitle(4))
                .fillCity(dataFaker.getCity())
                .fillState(dataFaker.getStateFull())
                .fillZipCode(dataFaker.getZipCode())
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateProfilePage.hasProfileUpdated());
    }
}
