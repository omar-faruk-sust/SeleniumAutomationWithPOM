package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.AccountDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

public class AccountDetailsTest extends BaseTest {

    @Test
    public void accountDetailsPageShouldLoadCorrectAccountDetails() throws InterruptedException {
        AccountDetailsPage accountDetailsPage = loginAndGetAccountOverviewPage().clickAccountLink();

        Assert.assertTrue(accountDetailsPage.isLoadedCorrectAccountDetails());
    }

    @Test
    public void noAccountActivityShouldFound() {
        AccountDetailsPage accountDetailsPage = loginAndGetAccountOverviewPage()
                .clickAccountLink()
                .selectAccountActivityPeriod("January")
                .selectAccountActivityType(1)
                .clickFindActivityBtn();

        Assert.assertTrue(accountDetailsPage.noActivityRecord());
    }

    @Test
    public void accountActivityShouldBeFound() {
        LocalDate currentdate = LocalDate.now();
        //Getting the current month
        String currentMonth = currentdate.getMonth().toString().toLowerCase();

        AccountDetailsPage accountDetailsPage = loginAndGetAccountOverviewPage()
                .clickAccountLink()
                .selectAccountActivityPeriod(currentMonth.substring(0, 1).toUpperCase() + currentMonth.substring(1))
                .selectAccountActivityType(1)
                .clickFindActivityBtn();

        Assert.assertTrue(accountDetailsPage.hasActivityRecord());
    }
}
